package com.softsquared.template.src.main.Map.MapEstate.models;

public class EstateInfo {
    private  String agencyName;
    private  String agencyAddress;
    private  String agencyComment;
    private  String agencyBossImg;
    //private  String roomImg;

    public EstateInfo() {

    }


    public EstateInfo(String agencyName, String agencyAddress, String agencyComment, String agencyBossImg) {
        this.agencyName = agencyName;
        this.agencyAddress = agencyAddress;
        this.agencyComment = agencyComment;
        this.agencyBossImg = agencyBossImg;
        //this.roomImg = roomImg;
    }


    public  String getAgencyName() {
        return agencyName;
    }

    public  String getAgencyAddress() {
        return agencyAddress;
    }

    public  String getAgencyComment() {
        return agencyComment;
    }

    public  String getAgencyBossImg() {
        return agencyBossImg;
    }

    //public  String getRoomImg() {
        //return roomImg;
    //}





}
