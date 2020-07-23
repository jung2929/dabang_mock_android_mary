package com.softsquared.template.src.main.MapFragment.models;

import com.google.gson.annotations.SerializedName;


public class FragMapResponse {

    @SerializedName("code") //서버에서 받아온 response를 자동으로 파싱해줌
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

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