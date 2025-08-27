# CloudEagle Dropbox API Integration Assignment

This project implements a modular Java client for Dropbox Business APIs with **OAuth2 PKCE authentication**. It demonstrates fetching team information using Retrofit2, structured DTOs, and a generic OAuth adapter pattern.

---

## Project Structure

```sql
cloudeagle/
|-- pom.xml                 # Maven configuration file with dependencies (Retrofit2, Gson, OkHttp)
|-- README.md               # Project documentation and instructions
|-- .gitignore              # Git ignore rules
|-- src
|  |-- main
|  |  |-- resources        # Any configuration files or static resources
|  |  |-- java
|  |  |  |-- org.example.cloudeagle
|  |  |  |  |-- Main.java                       # Entry point to run authentication + Dropbox API calls
|  |  |  |  |-- oauth
|  |  |  |  |  |-- OAuthAdapter.java            # Interface defining generic OAuth methods
|  |  |  |  |  |-- providers
|  |  |  |  |  |  |-- GenericOAuthAdapter.java  # Implements generic OAuth2 + PKCE flow
|  |  |  |  |  |  |-- DropboxOAuthAdapter.java  # Dropbox-specific OAuth adapter
|  |  |  |  |-- utils
|  |  |  |  |  |-- PKCEUtil.java                # Utility for generating PKCE code_verifier & code_challenge
|  |  |  |  |-- dtos
|  |  |  |  |  |-- TokenRequestDto.java        # DTO for token request parameters
|  |  |  |  |  |-- TokenResponseDto.java       # DTO for token response from OAuth
|  |  |  |  |  |-- TeamInfoDto.java            # DTO representing team information response
|  |  |  |  |  |-- PoliciesDto.java            # DTO for nested policies object
|  |  |  |  |  |-- SharingDto.java             # DTO for sharing policy details
|  |  |  |  |  |-- TagDto.java                 # DTO for generic ".tag" fields in Dropbox responses
|  |  |  |  |-- dropbox
|  |  |  |  |  |-- DropboxApi.java             # Retrofit interface for Dropbox API endpoints
|  |  |  |  |  |-- DropboxClient.java          # Dropbox API client that uses Retrofit + access token
|  |-- test
|  |  |-- java                                  # Placeholder for unit tests (not implemented in this assignment)
```

---

## Key Features

### 1. **Modularity**
- **OAuthAdapter** interface abstracts authentication flow.
- **GenericOAuthAdapter** implements PKCE and token exchange for reusable OAuth logic.
- **DropboxOAuthAdapter** extends the generic adapter with Dropbox-specific configuration.
- **DropboxClient** is strictly responsible for calling Dropbox APIs and uses DTOs for structured responses.
- Separation of concerns ensures the OAuth logic is reusable for other SaaS providers in future.

### 2. **PKCE (Proof Key for Code Exchange)**
- Secure OAuth flow for **public clients** that cannot store client secrets.
- Uses `code_verifier` and `code_challenge` to prevent interception attacks.
- No client secret is required in this desktop/console app setup.

### 3. **Retrofit2 + DTOs**
- Retrofit2 is used for API requests.
- `application/x-www-form-urlencoded` is used for token exchange as required by Dropbox.
- DTOs represent structured responses instead of using raw maps or JSON parsing.

---

## Usage

### 1. Configure Dropbox App
- Create a Dropbox Business App via [Dropbox App Console](https://www.dropbox.com/developers/apps).
- Set **redirect URI**: `http://localhost:8080/callback`.
- Copy your **Client ID** (in environment variable).

### 2. Run the Java Application
1. Open project in **IntelliJ IDEA**.
2. Add your Client ID and redirect URI in env.
3. Run `Main.java`.
4. Open the Dropbox authorization URL in browser.
5. Log in as **Team Admin** and authorize the app.
6. Copy the code parameter from the redirected uri and input it in your Java terminal.
7. Token will be exchanged automatically via PKCE.
8. DropboxClient will fetch and print team info.

---


## Notes
- PKCE ensures secure flow without storing a client secret.
- DTOs for nested objects are used to simplify JSON parsing and enable clean toString() logging.
- Modular design allows easy extension to other APIs or SaaS providers.
- Retrofit with @FormUrlEncoded is required for Dropbox token endpoint (JSON body is not supported).

---

## Dependencies
- Java 17+
- Maven
- Retrofit2
- Gson
- OkHttp

---

## Author
@harsh020 (Harsh Soni) – CloudEagle Assessment Implementation