package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class ActivityResponse {
    @SerializedName("latest_predicted_activity")
    private String latestPredictedActivity;

    public String getLatestPredictedActivity() {
        return latestPredictedActivity;
    }

    public void setLatestPredictedActivity(String latestPredictedActivity) {
        this.latestPredictedActivity = latestPredictedActivity;
    }
}
