package com.example.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataModel1 {
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("check")
    @Expose
    private String check;

    @SerializedName("day")
    @Expose
    private String day;

    @SerializedName("date")
    @Expose
    private String date;

    public Integer getId() {
        return id;
    }

    public String getCheck() {
        return check;
    }

    public String getDay() {
        return day;
    }

    public String getDate() {
        return date;
    }
}

