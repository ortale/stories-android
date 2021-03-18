package com.joseortale.unrd.view.interfaces;

import androidx.fragment.app.Fragment;

/**
 *
 * Interface that makes the communication between the adapter to the Activity passing through view model
 * to replace to a new fragment
 *
 */
public interface OnFragmentChange {
    void setFragment(Fragment fragment);
}
