package org.example.cloudeagle.dropbox;

import org.example.cloudeagle.dtos.TeamInfoDto;
import retrofit2.Call;
import retrofit2.http.POST;

public interface DropboxApi {
    @POST("team/get_info")
    Call<TeamInfoDto> getTeamInfo();
}
