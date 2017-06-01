package com.example.bubbles.myrestaurants.adapters;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;


import com.example.bubbles.myrestaurants.models.Restaurant;
import com.example.bubbles.myrestaurants.ui.RestaurantDetailFragment;

import java.util.ArrayList;

/**
 * Created by Josephine Menge on 30/05/2017.
 */

public class RestaurantPageAdapter extends FragmentPagerAdapter {
    private ArrayList<Restaurant> mRestaurants;


    public RestaurantPageAdapter (FragmentManager fm, ArrayList<Restaurant> restaurants) {
        super(fm);
        mRestaurants = restaurants;
    }
    @Override
    public Fragment getItem(int position) {
        return RestaurantDetailFragment.newInstance(mRestaurants.get(position));
    }
    @Override
    public int getCount() {
        return mRestaurants.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return mRestaurants.get(position).getName();
    }
}
