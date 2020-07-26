package com.softsquared.template.src.main.Map.MapComplex;

public class ComplexInfo {
    private static String complexName;
    private static String kindOfBuilding;
    private static String householdNum;
    private static String completionDate;
    private static String complexAddress;
    private static String complexImg;


    public ComplexInfo(String complexName, String kindOfBuilding, String householdNum, String completionDate, String complexAddress,String complexImg) {
        this.complexName = complexName;
        this.kindOfBuilding = kindOfBuilding;
        this.householdNum = householdNum;
        this.completionDate = completionDate;
        this.complexAddress = complexAddress;
        this.complexImg = complexImg;
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

    public static String getComplexAddress() {
        return complexAddress;
    }

    public static String getComplexImg() {
        return complexImg;
    }





}
