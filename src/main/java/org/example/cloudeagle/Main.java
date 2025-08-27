package org.example.cloudeagle;

import org.example.cloudeagle.dropbox.DropboxClient;
import org.example.cloudeagle.dtos.TokenResponseDto;
import org.example.cloudeagle.oauth.OAuthAdapter;
import org.example.cloudeagle.oauth.providers.DropboxOAuthAdapter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String CLIENT_ID = System.getenv("DROPBOX_CLIENT_ID");
        String REDIRECT_URI = System.getenv("DROPBOX_REDIRECT_URI");
        String STATE = System.getenv("STATE");
        if (CLIENT_ID == null) {
            System.out.println("Please set DROPBOX_CLIENT_ID as environment variable.");
            return;
        }
        if (REDIRECT_URI == null) {
            REDIRECT_URI = "http://localhost:8080/callback";
        }
        if(STATE == null) {
            STATE = "state123";
        }

        // Create the OAuth Adapter for Dropbox Provider
        OAuthAdapter oauthAdapter = new DropboxOAuthAdapter(CLIENT_ID, REDIRECT_URI);

        // Step 1: Generate the authentication url and ask user to get the code
        String authUrl = oauthAdapter.getAuthorizationUrl(STATE);
        System.out.println("Open browser: " + authUrl);

        // Step 2: Exchange the code for access token
        System.out.println("Enter the code: ");
        String code = new Scanner(System.in).nextLine();
        TokenResponseDto token = oauthAdapter.exchangeCodeForToken(code);

        // Step 3: Create the Dropbox Client Adapter to access apis.
        DropboxClient client = new DropboxClient(token.getAccessToken());
        try {
            System.out.println("=== Team Info ===");
            System.out.println(client.getTeamInfo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
