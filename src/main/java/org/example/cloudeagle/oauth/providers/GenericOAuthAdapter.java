package org.example.cloudeagle.oauth.providers;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.example.cloudeagle.dtos.TokenRequestDto;
import org.example.cloudeagle.dtos.TokenResponseDto;
import org.example.cloudeagle.oauth.OAuthAdapter;
import org.example.cloudeagle.oauth.OAuthApi;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

public abstract class GenericOAuthAdapter implements OAuthAdapter {

    protected final String clientId;
    protected final String redirectUri;
    protected final String authEndpoint;
    protected final String tokenEndpoint;
    protected final String scope;

    protected final Retrofit retrofit;
    protected final OAuthApi oAuthApi;

    protected String codeVerifier;

    public GenericOAuthAdapter(String clientId, String redirectUri, String authEndpoint,
                               String tokenEndpoint, String scope) {
        this.clientId = clientId;
        this.redirectUri = redirectUri;
        this.authEndpoint = authEndpoint;
        this.tokenEndpoint = tokenEndpoint;
        this.scope = scope;

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        this.retrofit = new Retrofit.Builder()
                .baseUrl(tokenEndpoint)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.oAuthApi = retrofit.create(OAuthApi.class);
    }

    @Override
    public String getAuthorizationUrl(String state) {
        codeVerifier = generateCodeVerifier();
        String codeChallenge = generateCodeChallenge(codeVerifier);

        return authEndpoint +
                "?client_id=" + urlEncode(clientId) +
                "&redirect_uri=" + urlEncode(redirectUri) +
                "&response_type=code" +
                "&scope=" + urlEncode(scope) +
                "&state=" + urlEncode(state) +
                "&code_challenge=" + urlEncode(codeChallenge) +
                "&code_challenge_method=S256";
    }

    @Override
    public TokenResponseDto exchangeCodeForToken(String code) {
        TokenRequestDto request = new TokenRequestDto(
                code,
                "authorization_code",
                clientId,
                codeVerifier,
                redirectUri
        );

        try {
            Call<TokenResponseDto> call = oAuthApi.exchangeToken(
                request.getCode(),
                request.getGrantType(),
                request.getClientId(),
                request.getRedirectUri(),
                request.getCodeVerifier()
            );
            retrofit2.Response<TokenResponseDto> response = call.execute();
            if (!response.isSuccessful() || response.body() == null) {
                throw new RuntimeException("Token exchange failed: " + response.errorBody().string());
            }
            return response.body();
        } catch (Exception e) {
            throw new RuntimeException("Error exchanging token", e);
        }
    }


    // ==== Helpers ====

    private String generateCodeVerifier() {
        byte[] code = new byte[32];
        new SecureRandom().nextBytes(code);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(code);
    }

    private String generateCodeChallenge(String codeVerifier) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(codeVerifier.getBytes(StandardCharsets.US_ASCII));
            return Base64.getUrlEncoder().withoutPadding().encodeToString(hash);
        } catch (Exception e) {
            throw new RuntimeException("Code challenge generation failed", e);
        }
    }

    private String urlEncode(String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8);
    }
}

