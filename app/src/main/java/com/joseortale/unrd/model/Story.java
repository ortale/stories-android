package com.joseortale.unrd.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Story implements Serializable {
    @SerializedName("story_id")
    private Integer storyId;

    @SerializedName("name")
    private String name;

    @SerializedName("short_summary")
    private String shortSummary;

    @SerializedName("full_summary")
    private String fullSummary;

    @SerializedName("list_image")
    private List<ListImage> listImage;

    public Integer getStoryId() {
        return storyId;
    }

    public void setStoryId(Integer storyId) {
        this.storyId = storyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortSummary() {
        return shortSummary;
    }

    public void setShortSummary(String shortSummary) {
        this.shortSummary = shortSummary;
    }

    public String getFullSummary() {
        return fullSummary;
    }

    public void setFullSummary(String fullSummary) {
        this.fullSummary = fullSummary;
    }

    public List<ListImage> getListImage() {
        return listImage;
    }

    public void setListImage(List<ListImage> listImage) {
        this.listImage = listImage;
    }
}
