package com.softsquared.template.src.main.MapFragment.MapComplex.models;

import com.google.gson.annotations.SerializedName;


public class FragMapComplexResponse {

    public class result {

        @SerializedName("complexNum")
        private String complexNum;

        @SerializedName("complexList")
        private ComplexList[] complexList;

        public String getComplexNum() {
            return complexNum;
        }

        public ComplexList[] getComplexList() {
            return complexList;
        }

    }

        public class ComplexList {

            @SerializedName("complexIdx")
            private String complexIdx;

            @SerializedName("complexName")
            private String complexName;

            @SerializedName("complexAdress")
            private String complexAdress;

            @SerializedName("complexImg")
            private String complexImg;

            @SerializedName("complexNum")
            private String complexNum;

            @SerializedName("roomNum")
            private String roomNum;

            @SerializedName("kindOfBuilding")
            private String kindOfBuilding;

            @SerializedName("householdNum")
            private String householdNum;

            @SerializedName("completionDate")
            private String completionDate;

            public String getComplexIdx() {
                return complexIdx;
            }

            public String getComplexName() {
                return complexName;
            }

            public String getComplexAdress() {
                return complexAdress;
            }

            public String getComplexImg() {
                return complexImg;
            }

            public String getComplexNum() {
                return complexNum;
            }

            public String getRoomNum() {
                return roomNum;
            }

            public String getKindOfBuilding() {
                return kindOfBuilding;
            }

            public String getHouseholdNum() {
                return householdNum;
            }

            public String getCompletionDate() {
                return completionDate;
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

    @SerializedName("complexList")
    private ComplexList complexList;

    public result getResult() {
        return result;
    }

    public ComplexList getComplexList() {
        return complexList;
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