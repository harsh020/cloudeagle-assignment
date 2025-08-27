package org.example.cloudeagle.dtos;

import com.google.gson.annotations.SerializedName;

public class SharingDto {
    @SerializedName("default_link_expiration_days_policy")
    private TagDto defaultLinkExpirationDaysPolicy;

    @SerializedName("enforce_link_password_policy")
    private TagDto enforceLinkPasswordPolicy;

    @SerializedName("group_creation_policy")
    private TagDto groupCreationPolicy;

    @SerializedName("shared_folder_join_policy")
    private TagDto sharedFolderJoinPolicy;

    @SerializedName("shared_folder_link_restriction_policy")
    private TagDto sharedFolderLinkRestrictionPolicy;

    @SerializedName("shared_folder_member_policy")
    private TagDto sharedFolderMemberPolicy;

    @SerializedName("shared_link_create_policy")
    private TagDto sharedLinkCreatePolicy;

    @SerializedName("shared_link_default_permissions_policy")
    private TagDto sharedLinkDefaultPermissionsPolicy;

    // getters and setters
    public TagDto getDefaultLinkExpirationDaysPolicy() { return defaultLinkExpirationDaysPolicy; }
    public void setDefaultLinkExpirationDaysPolicy(TagDto defaultLinkExpirationDaysPolicy) { this.defaultLinkExpirationDaysPolicy = defaultLinkExpirationDaysPolicy; }

    public TagDto getEnforceLinkPasswordPolicy() { return enforceLinkPasswordPolicy; }
    public void setEnforceLinkPasswordPolicy(TagDto enforceLinkPasswordPolicy) { this.enforceLinkPasswordPolicy = enforceLinkPasswordPolicy; }

    public TagDto getGroupCreationPolicy() { return groupCreationPolicy; }
    public void setGroupCreationPolicy(TagDto groupCreationPolicy) { this.groupCreationPolicy = groupCreationPolicy; }

    public TagDto getSharedFolderJoinPolicy() { return sharedFolderJoinPolicy; }
    public void setSharedFolderJoinPolicy(TagDto sharedFolderJoinPolicy) { this.sharedFolderJoinPolicy = sharedFolderJoinPolicy; }

    public TagDto getSharedFolderLinkRestrictionPolicy() { return sharedFolderLinkRestrictionPolicy; }
    public void setSharedFolderLinkRestrictionPolicy(TagDto sharedFolderLinkRestrictionPolicy) { this.sharedFolderLinkRestrictionPolicy = sharedFolderLinkRestrictionPolicy; }

    public TagDto getSharedFolderMemberPolicy() { return sharedFolderMemberPolicy; }
    public void setSharedFolderMemberPolicy(TagDto sharedFolderMemberPolicy) { this.sharedFolderMemberPolicy = sharedFolderMemberPolicy; }

    public TagDto getSharedLinkCreatePolicy() { return sharedLinkCreatePolicy; }
    public void setSharedLinkCreatePolicy(TagDto sharedLinkCreatePolicy) { this.sharedLinkCreatePolicy = sharedLinkCreatePolicy; }

    public TagDto getSharedLinkDefaultPermissionsPolicy() { return sharedLinkDefaultPermissionsPolicy; }
    public void setSharedLinkDefaultPermissionsPolicy(TagDto sharedLinkDefaultPermissionsPolicy) { this.sharedLinkDefaultPermissionsPolicy = sharedLinkDefaultPermissionsPolicy; }

    @Override
    public String toString() {
        return "Sharing{" +
                "defaultLinkExpirationDaysPolicy=" + defaultLinkExpirationDaysPolicy +
                ", enforceLinkPasswordPolicy=" + enforceLinkPasswordPolicy +
                ", groupCreationPolicy=" + groupCreationPolicy +
                ", sharedFolderJoinPolicy=" + sharedFolderJoinPolicy +
                ", sharedFolderLinkRestrictionPolicy=" + sharedFolderLinkRestrictionPolicy +
                ", sharedFolderMemberPolicy=" + sharedFolderMemberPolicy +
                ", sharedLinkCreatePolicy=" + sharedLinkCreatePolicy +
                ", sharedLinkDefaultPermissionsPolicy=" + sharedLinkDefaultPermissionsPolicy +
                '}';
    }
}

