package com.joseortale.unrd.data.api.endpoints;

import android.content.Context;

import com.joseortale.unrd.data.api.library.APIClient;
import com.joseortale.unrd.data.api.library.IAPIService;
import com.joseortale.unrd.data.database.StoryService;
import com.joseortale.unrd.model.Story;
import com.joseortale.unrd.model.StoryResponse;
import com.joseortale.unrd.view.interfaces.OnDataUpdatedListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StoryEndPoints {
    private static StoryEndPoints instance;
    private StoryService service;

    private IAPIService iapiService;
    private OnDataUpdatedListener dataUpdated;

    private StoryEndPoints() {
        iapiService = APIClient.getClient();
    }

    public static StoryEndPoints getInstance() {
        if (instance == null) {
            instance = new StoryEndPoints();
        }
        return instance;
    }

    /**
     *
     * Updates the app story list
     *
     * @param context
     */
    public void updateStory(final Context context) {
        service = StoryService.getInstance(context);

        Call<StoryResponse> call = iapiService.getStories();
        call.enqueue(new Callback<StoryResponse>() {
            @Override
            public void onResponse(Call<StoryResponse> call, Response<StoryResponse> response) {
                StoryResponse stories = response.body();

                if (stories != null) {
                    service = StoryService.getInstance(context);

                    Story story = stories.getResult();

                    service.save(story);

                    dataUpdated.dataUpdatedSuccesfully(stories);
                }
            }

            @Override
            public void onFailure(Call<StoryResponse> call, Throwable t) {
                dataUpdated.dataUpdateError(t.getMessage());
            }
        });
    }

    /**
     *
     * OnDataUpdatedListener is a listener to tell the view that the data has been updated
     *
     * @param dataUpdated
     */
    public void setOnDataUpdatedListener(OnDataUpdatedListener dataUpdated) {
        this.dataUpdated = dataUpdated;
    }
}
