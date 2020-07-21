package com.softsquared.template.src.main.map.map_dangi;

public class Dangi_info {
    private static String complexName;
    private static String kindOfBuilding;
    private static String householdNum;
    private static String completionDate;
    private static String complexAdress;
    //private String Img_url;


    public Dangi_info(String complexName, String kindOfBuilding, String householdNum, String completionDate, String complexAdress) {
        this.complexName = complexName;
        this.kindOfBuilding = kindOfBuilding;
        this.householdNum = householdNum;
        this.completionDate = completionDate;
        this.complexAdress = complexAdress;
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
        return complexAdress;
    }


//    public String getImg_url() {
//        return Img_url;
//    }


}
