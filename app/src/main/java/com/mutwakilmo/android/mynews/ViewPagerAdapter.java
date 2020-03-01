package com.mutwakilmo.android.mynews;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

/**
 * Created by Mutwakil Mo on 29/02/2020
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    //Constructor
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return NYTConstants.NEWS_SECTIONS[position];
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return NYTConstants.NEWS_SECTIONS.length;
    }
}
