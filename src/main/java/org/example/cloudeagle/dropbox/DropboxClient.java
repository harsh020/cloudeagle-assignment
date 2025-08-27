package org.example.cloudeagle.dropbox;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.example.cloudeagle.dtos.TeamInfoDto;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class DropboxClient {
    private static final String BASE_URL = "https://api.dropboxapi.com/2/";

    private final DropboxApi dropboxApi;

    public DropboxClient(String accessToken) {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor((Interceptor.Chain chain) -> {
                    Request request = chain.request().newBuilder()
                            .addHeader("Authorization", "Bearer " + accessToken)
                            .build();
                    return chain.proceed(request);
                })
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        dropboxApi = retrofit.create(DropboxApi.class);
    }

    public DropboxApi getApi() {
        return dropboxApi;
    }

    public TeamInfoDto getTeamInfo() throws IOException {
        return dropboxApi.getTeamInfo().execute().body();
    }
}
