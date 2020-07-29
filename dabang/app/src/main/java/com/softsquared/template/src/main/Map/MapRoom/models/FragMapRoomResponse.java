package com.softsquared.template.src.main.Map.MapRoom.models;

import com.google.gson.annotations.SerializedName;


public class FragMapRoomResponse {

    public class result {

        @SerializedName("roomNum")
        private String roomNum;

        @SerializedName("roomList")
        private RoomList[] roomList;

        public String getRoomNum() {
            return roomNum;
        }

        public RoomList[] getRoomList() {
            return roomList;
        }

    }

    public class RoomList {


        @SerializedName("plus")
        private String plus;

        @SerializedName("monthlyRent")
        private String monthlyRent;

        @SerializedName("complexName")
        private String complexName;

        @SerializedName("lease")
        private String lease;

        @SerializedName("kindOfRoom")
        private String kindOfRoom;

        @SerializedName("thisFloor")
        private String thisFloor;

        @SerializedName("exclusiveArea")
        private String exclusiveArea;

        @SerializedName("maintenanceCost")
        private String maintenanceCost;

        @SerializedName("roomSummary")
        private String roomSummary;

        @SerializedName("agencyIdx")
        private String agencyIdx;

        @SerializedName("agencyName")
        private String agencyName;

        @SerializedName("checkedRoom")
        private String checkedRoom;

        @SerializedName("roomImg")
        private FragMapRoomResponse.roomImgList[] roomImgList;

        @SerializedName("hashTag")
        private FragMapRoomResponse.hashTagList[] hashTagList;


        public String getPlus() {
            return plus;
        }

        public String getMonthlyRent() {
            return monthlyRent;
        }

        public String getComplexName() {
            return complexName;
        }

        public String getLease() {
            return lease;
        }

        public String getKindOfRoom() {
            return kindOfRoom;
        }

        public String getThisFloor() {
            return thisFloor;
        }

        public String getExclusiveArea() {
            return exclusiveArea;
        }

        public String getMaintenanceCost() {
            return maintenanceCost;
        }

        public String getRoomSummary() {
            return roomSummary;
        }

        public String getAgencyIdx() {
            return agencyIdx;
        }

        public String getAgencyName() {
            return agencyName;
        }

        public String getCheckedRoom() {
            return checkedRoom;
        }

        public hashTagList[] getHashTagList() {
            return hashTagList;
        }
        public roomImgList[] getRoomImgList() {
            return roomImgList;
        }
    }


    public class hashTagList{

    }

    public class roomImgList{

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

    public RoomList getRoomList() {
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