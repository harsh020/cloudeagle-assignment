package org.example.cloudeagle.dtos;

import com.google.gson.annotations.SerializedName;

public class TagDto {
    @SerializedName(".tag")
    private String tag;

    public String getTag() { return tag; }
    public void setTag(String tag) { this.tag = tag; }

    @Override
    public String toString() {
        return tag;
    }
}
