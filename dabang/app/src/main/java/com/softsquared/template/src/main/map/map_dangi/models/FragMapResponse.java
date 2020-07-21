package com.softsquared.template.src.main.map.map_dangi.models;

import android.content.ClipData;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FragMapResponse {

    class result {
        @SerializedName("complexNum")
        private String complexNum;

        public String getComplexNum() {
            return complexNum;
        }

        public ComplexList[] getComplexList() {
            return complexList;
        }

        @SerializedName("complexList")
        ComplexList[] complexList;

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

            @SerializedName("completionDate")
            private String completionDate;


            }


    @SerializedName("code") //서버에서 받아온 response를 자동으로 파싱해줌
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    private result result;

    public result getResult() {
        return result;
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