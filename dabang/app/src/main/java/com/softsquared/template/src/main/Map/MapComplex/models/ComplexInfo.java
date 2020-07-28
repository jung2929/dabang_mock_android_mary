package com.softsquared.template.src.main.Map.MapComplex.models;

public class ComplexInfo {
    /*
    private static String complexName;
    private static String kindOfBuilding;
    private static String householdNum;
    private static String completionDate;
    private static String complexAddress;
    private static String complexImg;
*/

    private String complexName;
    private String kindOfBuilding;
    private String householdNum;
    private String completionDate;
    private String complexAddress;
    private String complexImg;

    public ComplexInfo() {

    }

    public ComplexInfo(String complexName, String kindOfBuilding, String householdNum, String completionDate, String complexAddress,String complexImg) {
        this.complexName = complexName;
        this.kindOfBuilding = kindOfBuilding;
        this.householdNum = householdNum;
        this.completionDate = completionDate;
        this.complexAddress = complexAddress;
        this.complexImg = complexImg;
    }

    public String getComplexName() {
        return complexName;
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

    public String getComplexAddress() {
        return complexAddress;
    }

    public String getComplexImg() {
        return complexImg;
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
