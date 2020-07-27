package com.softsquared.template.src.main.Home.models;

import com.google.gson.annotations.SerializedName;

public class postInfo {
    @SerializedName("postImg")
    private int postImg;

    @SerializedName("postUrl")
    private int postUrl;

    @SerializedName("postTitle")
    private String postTitle;

    @SerializedName("postViewCount")
    private String postViewCount;

    public int getPostImg() {
        return postImg;
    }

    public int getPostUrl() {
        return postUrl;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getPostViewCount() {
        return postViewCount;
    }

}
