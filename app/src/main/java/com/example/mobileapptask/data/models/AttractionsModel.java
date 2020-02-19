package com.example.mobileapptask.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AttractionsModel {

    @SerializedName("name")
    private String name;
    @SerializedName("photos")
    private List<String> photos;
    @SerializedName("categories")
    private List<CategoryModel> categories;

    public String getName() {
        return name;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public List<CategoryModel> getCategories() {
        return categories;
    }
}
