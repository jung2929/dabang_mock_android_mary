package com.softsquared.template.src.main.Home.models;

public class InterestInfo {
    private String regionName;
    private String roomNum;
    private String regionImg;
    private String roomType;


    public InterestInfo(String regionName, String roomNum, String regionImg, String roomType) {
        this.regionName = regionName;
        this.roomNum = roomNum;
        this.regionImg = regionImg;
        this.roomType = roomType;
    }

    public String getRegionName() {
        return regionName;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public String getRegionImg() {
        return regionImg;
    }

    public String getRoomType() {
        return roomType;
    }
}
