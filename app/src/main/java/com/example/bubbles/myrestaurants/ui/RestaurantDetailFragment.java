package com.example.bubbles.myrestaurants.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bubbles.myrestaurants.R;
import com.example.bubbles.myrestaurants.models.Restaurant;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;


public class RestaurantDetailFragment extends Fragment implements View.OnClickListener {
    @Bind(R.id.restaurantImageView)
    ImageView mImageLabel;
    @Bind(R.id.restaurantNameTextView)
    TextView mNameLabel;
    @Bind(R.id.cuisineTextView) TextView mCategoriesLabel;
    @Bind(R.id.ratingTextView) TextView mRatingLabel;
    @Bind(R.id.websiteTextView) TextView mWebsiteLabel;
    @Bind(R.id.phoneTextView) TextView mPhoneLabel;
    @Bind(R.id.addressTextView) TextView mAdressLabel;
    @Bind(R.id.saveRestaurantButton)
    Button mSaveRestaurantsButton;
    private Restaurant mRestaurant;
    public static final int MAX_WIDTH = 300;
    public static final int MAX_HEIGHT = 500;


    public static RestaurantDetailFragment newInstance(Restaurant restaurant) {
       RestaurantDetailFragment restaurantDetailFragment = new RestaurantDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("restaurant", Parcels.wrap(restaurant));
        restaurantDetailFragment.setArguments(args);
        return  restaurantDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        mRestaurant = Parcels.unwrap(getArguments().getParcelable("restaurant"));
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurant_detail,container,false);
        ButterKnife.bind(this,view);
        Picasso.with(view.getContext()).load(mRestaurant.getImageUrl()).resize(MAX_WIDTH,MAX_HEIGHT).centerCrop().into(mImageLabel);
        mNameLabel.setText(mRestaurant.getName());
        mCategoriesLabel.setText(android.text.TextUtils.join(",", mRestaurant.getCategories()));
        mRatingLabel.setText(Double.toString(mRestaurant.getRating())+"/5");
        mPhoneLabel.setOnClickListener(this);
        mAdressLabel.setOnClickListener(this);
        mWebsiteLabel.setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View v) {
        if (v == mWebsiteLabel) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mRestaurant.getWebsite()));
            startActivity(webIntent);
        }
        if (v == mPhoneLabel) {
            Intent phoneIntent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + mRestaurant.getPhone()));
            startActivity(phoneIntent);
        }
        if (v == mAdressLabel) {
            Intent mapIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:" + mRestaurant.getLatitude()+","+mRestaurant.getLongitude()+ "?q=(" + mRestaurant.getName()+")"));
            startActivity(mapIntent);
        }
    }
}
