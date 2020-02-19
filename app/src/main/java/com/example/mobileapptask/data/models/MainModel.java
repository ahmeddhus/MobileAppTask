package com.example.mobileapptask.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MainModel {

    @SerializedName("status_code")
    private String status_code;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    public DataModel data;

    public String getStatus_code() {
        return status_code;
    }

    public String getMessage() {
        return message;
    }

    public DataModel getData() {
        return data;
    }
}
