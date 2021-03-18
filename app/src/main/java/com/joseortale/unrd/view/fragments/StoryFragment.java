package com.joseortale.unrd.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.joseortale.unrd.R;
import com.joseortale.unrd.databinding.FragmentStoryListBinding;
import com.joseortale.unrd.model.Story;
import com.joseortale.unrd.view.activities.MainActivity;
import com.joseortale.unrd.view.helpers.ViewHelper;
import com.joseortale.unrd.view.interfaces.OnDataUpdatedListener;
import com.joseortale.unrd.view.interfaces.OnFragmentChange;
import com.joseortale.unrd.viewmodel.StoryViewModel;

public class StoryFragment extends Fragment implements OnDataUpdatedListener, OnFragmentChange {
    private FragmentStoryListBinding viewBinding;
    private StoryViewModel viewModel;

    public StoryFragment() {

    }

    public static StoryFragment newInstance() {
        StoryFragment fragment = new StoryFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_story, container, false);

        updateStoryList();

        return viewBinding.getRoot();
    }

    /**
     *
     * Makes call to API in order to update story list
     *
     */
    private void updateStoryList() {
        showProgressBar();

        viewModel = new StoryViewModel(new Story());
        viewModel.setDataUpdatedListener(this);
        viewModel.updateStoryList(getContext());
    }

    private void showProgressBar() {
        viewBinding.lineStories.setVisibility(View.GONE);
        viewBinding.progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        viewBinding.lineStories.setVisibility(View.VISIBLE);
        viewBinding.progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * Gets updated data to update adapter
     *
     * @param data
     */
    @Override
    public void dataUpdatedSuccesfully(Object data) {
        hideProgressBar();
    }

    /**
     *
     * Displays an error to the user in case of data update error.
     *
     * @param error
     */
    @Override
    public void dataUpdateError(String error) {
        AlertDialog.Builder dialog = ViewHelper.showAlertDialog(getContext());
        dialog.setPositiveButton(android.R.string.ok, (dialogInterface, i) -> {

        });
        dialog.show();
        hideProgressBar();
    }

    /**
     *
     * Receives fragment set by adapter calling method on MainActivity
     *
     * @param fragment
     */
    @Override
    public void setFragment(Fragment fragment) {
        ((MainActivity)getActivity()).setFragment(fragment);
    }
}
