package com.example.myapplication;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataModel3 {
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("time_range")
    @Expose
    private String timeRange;

    @SerializedName("date")
    @Expose
    private String date;

    public Integer getId() {
        return id;
    }

    public String getTimeRange() {
        return timeRange;
    }

    public String getDate() {
        return date;
    }
}
