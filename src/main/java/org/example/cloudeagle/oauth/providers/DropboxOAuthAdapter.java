package org.example.cloudeagle.oauth.providers;


public class DropboxOAuthAdapter extends GenericOAuthAdapter {
    private static final String AUTH_ENDPOINT = "https://www.dropbox.com/oauth2/authorize";
    private static final String TOKEN_ENDPOINT = "https://api.dropboxapi.com/2/oauth2/token";
    private static final String BASE_URL = "https://api.dropboxapi.com/";
    private static final String SCOPES = "team_info.read members.read events.read";

    public DropboxOAuthAdapter(String clientId, String redirectUri) {
        super(clientId, redirectUri, AUTH_ENDPOINT, BASE_URL, SCOPES);
    }
}

