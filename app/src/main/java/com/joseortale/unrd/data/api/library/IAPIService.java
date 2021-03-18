package com.joseortale.unrd.data.api.library;

import com.joseortale.unrd.model.StoryResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IAPIService {
    @GET("resp.json")
    Call<StoryResponse> getStories();
}
