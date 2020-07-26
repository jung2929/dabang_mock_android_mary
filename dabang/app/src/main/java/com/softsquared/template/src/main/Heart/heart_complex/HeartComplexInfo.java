package com.softsquared.template.src.main.Heart.heart_complex;

public class HeartComplexInfo {
    private static String complexName;
    private static String kindOfBuilding;
    private static String householdNum;
    private static String completionDate;
    private static String complexAddress;
    //private String Img_url;


    public HeartComplexInfo(String complexName, String kindOfBuilding, String householdNum, String completionDate, String complexAdress, String img_url) {
        this.complexName = complexName;
        this.kindOfBuilding = kindOfBuilding;
        this.householdNum = householdNum;
        this.completionDate = completionDate;
        this.complexAddress = complexAdress;
        //this.Img_url = img_url;
    }

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

    public static String getComplexAdress() {
        return complexAddress;
    }


//    public String getImg_url() {
//        return Img_url;
//    }






}
