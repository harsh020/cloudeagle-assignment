package org.example.cloudeagle.oauth;

import org.example.cloudeagle.dtos.TokenResponseDto;

public interface OAuthAdapter {
    String getAuthorizationUrl(String state);

    TokenResponseDto exchangeCodeForToken(String code);

//    TokenResponse refreshToken(String refreshToken);
}

