package org.example.cloudeagle.dtos;

import com.google.gson.annotations.SerializedName;

public class TeamInfoDto {
    private String name;

    @SerializedName("num_licensed_users")
    private int numLicensedUsers;

    @SerializedName("num_provisioned_users")
    private int numProvisionedUsers;

    @SerializedName("num_used_licenses")
    private int numUsedLicenses;

    private PoliciesDto policiesDto;

    @SerializedName("team_id")
    private String teamId;

    // getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getNumLicensedUsers() { return numLicensedUsers; }
    public void setNumLicensedUsers(int numLicensedUsers) { this.numLicensedUsers = numLicensedUsers; }

    public int getNumProvisionedUsers() { return numProvisionedUsers; }
    public void setNumProvisionedUsers(int numProvisionedUsers) { this.numProvisionedUsers = numProvisionedUsers; }

    public int getNumUsedLicenses() { return numUsedLicenses; }
    public void setNumUsedLicenses(int numUsedLicenses) { this.numUsedLicenses = numUsedLicenses; }

    public PoliciesDto getPolicies() { return policiesDto; }
    public void setPolicies(PoliciesDto policiesDto) { this.policiesDto = policiesDto; }

    public String getTeamId() { return teamId; }
    public void setTeamId(String teamId) { this.teamId = teamId; }

    @Override
    public String toString() {
        return "GetTeamInfoResponse{" +
                "name='" + name + '\'' +
                ", numLicensedUsers=" + numLicensedUsers +
                ", numProvisionedUsers=" + numProvisionedUsers +
                ", numUsedLicenses=" + numUsedLicenses +
                ", policies=" + policiesDto +
                ", teamId='" + teamId + '\'' +
                '}';
    }
}

