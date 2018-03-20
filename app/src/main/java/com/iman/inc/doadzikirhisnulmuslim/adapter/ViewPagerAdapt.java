package com.iman.inc.doadzikirhisnulmuslim.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by z on 16/03/18.
 */

public class ViewPagerAdapt extends FragmentPagerAdapter {
    List <Fragment> listFragment = new ArrayList<>();
    public ViewPagerAdapt(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

    public void addFragment(Fragment fragment){
        listFragment.add(fragment);
    }


}
