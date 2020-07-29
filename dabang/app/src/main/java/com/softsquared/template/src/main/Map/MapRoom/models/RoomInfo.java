package com.softsquared.template.src.main.Map.MapRoom.models;

public class RoomInfo {

    private String complexName; //단지이름
    private String monthlyRent; //월세
    private String lease; //전세
    private String kindOfRoom; //원룸
    private String thisFloor; //2층
    private String exclusiveArea; //33.05
    private String maintenanceCost; //관리비
    private String roomSummary; //방설명



    public RoomInfo(String complexName, String monthlyRent, String lease, String kindOfRoom, String thisFloor, String exclusiveArea,String maintenanceCost,String roomSummary) {
        this.complexName = complexName;
        this.monthlyRent = monthlyRent;
        this.lease = lease;
        this.kindOfRoom = kindOfRoom;
        this.thisFloor = thisFloor;
        this.exclusiveArea = exclusiveArea;
        this.maintenanceCost = maintenanceCost;
        this.roomSummary = roomSummary;
    }

    public String getComplexName() {
        return complexName;
    }

    public String getMonthlyRent() {
        return monthlyRent;
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

    /*
    public static String getComplexName() {
        return complexName;
    }

    public static String getKindOfBuilding() {
        return kindOfBuilding;
    }

    public static String getHouseholdNum() {
        return householdNum;
    }

    public static String getCompletionDate() {
        return completionDate;
    }

    public static String getComplexAddress() {
        return complexAddress;
    }

    public static String getComplexImg() {
        return complexImg;
    }


    public static void setComplexName(String complexName) {
        ComplexInfo.complexName = complexName;
    }

    public static void setKindOfBuilding(String kindOfBuilding) {
        ComplexInfo.kindOfBuilding = kindOfBuilding;
    }

    public static void setHouseholdNum(String householdNum) {
        ComplexInfo.householdNum = householdNum;
    }

    public static void setCompletionDate(String completionDate) {
        ComplexInfo.completionDate = completionDate;
    }

    public static void setComplexAddress(String complexAddress) {
        ComplexInfo.complexAddress = complexAddress;
    }

    public static void setComplexImg(String complexImg) {
        ComplexInfo.complexImg = complexImg;
    }
     */
}
