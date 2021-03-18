package com.joseortale.unrd.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ListImage implements Serializable {
    @SerializedName("resource_id")
    private Integer resourceId;

    @SerializedName("resource_uri")
    private String resourceUri;

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceUri() {
        return resourceUri;
    }

    public void setResourceUri(String resourceUri) {
        this.resourceUri = resourceUri;
    }
}
