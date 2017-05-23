package com.example.bubbles.myrestaurants;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private Button mFindRestaurantsButton;
    private EditText mLocationEditText;
    private TextView mmyRestaurantsTextView;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLocationEditText = (EditText) findViewById(R.id.locationEditText);

        mFindRestaurantsButton = (Button) findViewById(R.id.findRestaurantsButton);

        mmyRestaurantsTextView = (TextView) findViewById(R.id.myRestaurantTextView);

        Typeface dumbFont = Typeface.createFromAsset(getAssets(), "fonts/3Dumb.ttf");
        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/ostrich-regular.ttf");
        mListView = (ListView) findViewById(R.id.listView);     ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,restaurants);
        mListView.setAdapter(adapter);
        mmyRestaurantsTextView.setTypeface(ostrichFont);
        mFindRestaurantsButton.setTypeface(dumbFont);

    mFindRestaurantsButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            String location = mLocationEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, RestaurantsActivity.class);
            intent.putExtra("location",location);
            startActivity(intent);
        }
    });

    }
}
