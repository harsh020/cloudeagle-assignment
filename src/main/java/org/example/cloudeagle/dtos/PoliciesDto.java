package org.example.cloudeagle.dtos;

import com.google.gson.annotations.SerializedName;

public class PoliciesDto {
    @SerializedName("emm_state")
    private TagDto emmState;

    @SerializedName("office_addin")
    private TagDto officeAddin;

    private SharingDto sharingDto;

    @SerializedName("suggest_members_policy")
    private TagDto suggestMembersPolicy;

    @SerializedName("top_level_content_policy")
    private TagDto topLevelContentPolicy;

    // getters and setters
    public TagDto getEmmState() { return emmState; }
    public void setEmmState(TagDto emmState) { this.emmState = emmState; }

    public TagDto getOfficeAddin() { return officeAddin; }
    public void setOfficeAddin(TagDto officeAddin) { this.officeAddin = officeAddin; }

    public SharingDto getSharing() { return sharingDto; }
    public void setSharing(SharingDto sharingDto) { this.sharingDto = sharingDto; }

    public TagDto getSuggestMembersPolicy() { return suggestMembersPolicy; }
    public void setSuggestMembersPolicy(TagDto suggestMembersPolicy) { this.suggestMembersPolicy = suggestMembersPolicy; }

    public TagDto getTopLevelContentPolicy() { return topLevelContentPolicy; }
    public void setTopLevelContentPolicy(TagDto topLevelContentPolicy) { this.topLevelContentPolicy = topLevelContentPolicy; }

    @Override
    public String toString() {
        return "Policies{" +
                "sharing=" + sharingDto +
                ", emmState=" + emmState +
                '}';
    }

}

