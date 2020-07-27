package com.softsquared.template.src.main.Map.MapEstate.models;

public class EstateInfo {
    private static String agencyName;
    private static String agencyAddress;
    private static String agencyComment;
    private static String agencyBossImg;


    public EstateInfo(String agencyName, String agencyAddress, String agencyComment, String agencyBossImg) {
        this.agencyName = agencyName;
        this.agencyAddress = agencyAddress;
        this.agencyComment = agencyComment;
        this.agencyBossImg = agencyBossImg;

    }


    public static String getAgencyName() {
        return agencyName;
    }

    public static String getAgencyAddress() {
        return agencyAddress;
    }

    public static String getAgencyComment() {
        return agencyComment;
    }

    public static String getAgencyBossImg() {
        return agencyBossImg;
    }





}
