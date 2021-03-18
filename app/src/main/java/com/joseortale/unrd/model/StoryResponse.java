package com.joseortale.unrd.model;

import com.google.gson.annotations.SerializedName;

public class StoryResponse {
    @SerializedName("status")
    private Status status;

    @SerializedName("result")
    private Story result;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Story getResult() {
        return result;
    }

    public void setResult(Story result) {
        this.result = result;
    }
}
