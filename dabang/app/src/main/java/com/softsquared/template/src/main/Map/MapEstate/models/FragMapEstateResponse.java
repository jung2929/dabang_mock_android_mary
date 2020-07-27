package com.softsquared.template.src.main.Map.MapEstate.models;

import com.google.gson.annotations.SerializedName;

public class FragMapEstateResponse {

    public class result {

        @SerializedName("agencyNum")
        private String agencyNum;

        @SerializedName("agencyList")
        private AgencyList[] agencyList;

        public String getAgencyNum() {
            return agencyNum;
        }

        public AgencyList[] getAgencyList() {
            return agencyList;
        }

    }

    public class AgencyList {

        @SerializedName("agencyIdx")
        private String agencyIdx;

        @SerializedName("agencyName")
        private String agencyName;

        @SerializedName("agencyAddress")
        private String agencyAddress;

        @SerializedName("agencyComment")
        private String agencyComment;

        @SerializedName("agencyBossImg")
        private String agencyBossImg;

        @SerializedName("latitude")
        private String latitude;

        @SerializedName("longitude")
        private String longitude;


        public String getAgencyIdx() {
            return agencyIdx;
        }

        public String getAgencyName() {
            return agencyName;
        }

        public String getAgencyAddress() {
            return agencyAddress;
        }

        public String getAgencyComment() {
            return agencyComment;
        }

        public String getAgencyBossImg() {
            return agencyBossImg;
        }

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

    @SerializedName("result")
    private result result;

    @SerializedName("agencyList")
    private AgencyList agencyList;

    public result getResult() {
        return result;
    }

    public AgencyList getAgencyList() {
        return agencyList;
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