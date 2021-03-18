package com.joseortale.unrd.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.joseortale.unrd.BR;
import com.joseortale.unrd.data.api.endpoints.StoryEndPoints;
import com.joseortale.unrd.data.database.StoryService;
import com.joseortale.unrd.model.ListImage;
import com.joseortale.unrd.model.Story;
import com.joseortale.unrd.view.interfaces.OnDataUpdatedListener;

import java.util.List;

/**
 *
 * Story View Model
 *
 */
public class StoryViewModel extends BaseObservable {
    private Story story;

    public StoryViewModel(Story story) {
        this.story = story;
    }

    @Bindable
    public String getName() {
        return story.getName();
    }

    @Bindable
    public void setName(String name) {
        story.setName(name);
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getShortSummary() {
        return story.getShortSummary();
    }

    @Bindable
    public void setShortSummary(String summary) {
        story.setShortSummary(summary);
        notifyPropertyChanged(BR.shortSummary);
    }

    @Bindable
    public List<ListImage> getListImage() {
        return story.getListImage();
    }

    @Bindable
    public Integer getStoryId() {
        return story.getStoryId();
    }

    @Bindable
    public void setStoryId(Integer id) {
        story.setStoryId(id);
        notifyPropertyChanged(BR.storyId);
    }

    /**
     *
     * Interface between view and data layer to update story list
     *
     * @param context
     */
    public void updateStoryList(Context context) {
        StoryEndPoints endPoints = StoryEndPoints.getInstance();
        endPoints.updateStory(context);
    }

    /**
     *
     * @param listener
     */
    public void setDataUpdatedListener(OnDataUpdatedListener listener) {
        StoryEndPoints endPoints = StoryEndPoints.getInstance();
        endPoints.setOnDataUpdatedListener(listener);
    }
}
