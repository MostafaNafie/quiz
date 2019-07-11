package com.mostafanafie.quiz;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class QuestionsStatePagerAdapter extends FragmentStatePagerAdapter {

    // Initialize lists to hold Fragments
    private final List<Fragment> mFragmentList = new ArrayList<>();

    // Constructor
    public QuestionsStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    // A method to add Fragments to the Fragments list
    public void addFragment(Fragment fragment) {
        mFragmentList.add(fragment);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
