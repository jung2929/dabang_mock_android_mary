package com.softsquared.template.src.main.Home.models;

import com.google.gson.annotations.SerializedName;
import com.softsquared.template.src.main.Map.models.FragMapResponse;

import java.util.ArrayList;

public class FragHomeResponse {

    public class result {
        @SerializedName("postImg")
        private String postImg;

        @SerializedName("postUrl")
        private String postUrl;

        @SerializedName("postTitle")
        private String postTitle;

        @SerializedName("postViewCount")
        private String postViewCount;

        public String getPostImg() {
            return postImg;
        }

        public String getPostUrl() {
            return postUrl;
        }

        public String getPostTitle() {
            return postTitle;
        }

        public String getPostViewCount() {
            return postViewCount;
        }


    }

    @SerializedName("code") //서버에서 받아온 response를 자동으로 파싱해줌
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    private FragHomeResponse.result[] result;


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }



    }