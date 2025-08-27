package org.example.cloudeagle.oauth;


import org.example.cloudeagle.dtos.TokenResponseDto;
import retrofit2.Call;
import retrofit2.http.*;

public interface OAuthApi {

    @FormUrlEncoded
    @POST("oauth2/token")
    Call<TokenResponseDto> exchangeToken(
        @Field("code") String code,
        @Field("grant_type") String grantType,
        @Field("client_id") String clientId,
        @Field("redirect_uri") String redirectUri,
        @Field("code_verifier") String codeVerifier
    );
}
