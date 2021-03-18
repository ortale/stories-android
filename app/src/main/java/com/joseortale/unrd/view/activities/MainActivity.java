package com.joseortale.unrd.view.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.joseortale.unrd.R;
import com.joseortale.unrd.view.fragments.StoryFragment;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StoryFragment fragment = StoryFragment.newInstance();
        setFragment(fragment);
    }

    public void setFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.rootFragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        int fragments = getSupportFragmentManager().getBackStackEntryCount();
        if (fragments == 0) {
            super.onBackPressed();
        } else  {
            getFragmentManager().popBackStack();
        }
    }
}
