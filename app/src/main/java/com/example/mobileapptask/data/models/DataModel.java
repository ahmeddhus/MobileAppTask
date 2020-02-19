package com.example.mobileapptask.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataModel {

    @SerializedName("attractions")
    private List<AttractionsModel> attractions;
    @SerializedName("events")
    private List<EventsModel> events;
    @SerializedName("hot_spots")
    private List<HotSpotsModel> hot_spots;

    public List<AttractionsModel> getAttractions() {
        return attractions;
    }

    public List<EventsModel> getEvents() {
        return events;
    }

    public List<HotSpotsModel> getHot_spots() {
        return hot_spots;
    }
}
