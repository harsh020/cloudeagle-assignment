package org.example.cloudeagle.dtos;

public class TokenRequestDto {
    private String code;
    private String grantType;
    private String clientId;
    private String codeVerifier;
    private String redirectUri;

    public TokenRequestDto(String code, String grantType, String clientId, String codeVerifier, String redirectUri) {
        this.code = code;
        this.grantType = grantType;
        this.clientId = clientId;
        this.codeVerifier = codeVerifier;
        this.redirectUri = redirectUri;
    }

    public String getCode() {
        return code;
    }

    public String getGrantType() {
        return grantType;
    }

    public String getClientId() {
        return clientId;
    }

    public String getCodeVerifier() {
        return codeVerifier;
    }

    public String getRedirectUri() {
        return redirectUri;
    }
}