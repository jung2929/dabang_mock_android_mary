package com.softsquared.template.src.main.Map.models;

import com.google.gson.annotations.SerializedName;


public class FragMapResponse {



    public class result {

        @SerializedName("roomNum")
        private String roomNum;

        @SerializedName("roomList")
        private FragMapResponse.RoomList[] roomList;

        public String getRoomNum() {
            return roomNum;
        }

        public FragMapResponse.RoomList[] getRoomList() {
            return roomList;
        }

    }

    public class RoomList {

        @SerializedName("latitude")
        private String latitude;

        @SerializedName("longitude")
        private String longitude;

        public String getLatitude() {
            return latitude;
        }

        public String getLongitude() {
            return longitude;
        }

    }


    @SerializedName("code") //서버에서 받아온 response를 자동으로 파싱해줌
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("roomList")
    private RoomList roomList;

    @SerializedName("result")
    private result result;

    public result getResult() {
        return result;
    }

    public RoomList getComplexList() {
        return roomList;
    }

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