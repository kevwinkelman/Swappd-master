package com.swappd.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private String TAG;

    // Elements
    private Button backBtn;
    private Button rideBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Instantiate TAG for debugging
        TAG = "HomeActivity";

        // Instantiate  button with onClick event
        backBtn = (Button) findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Back button clicked");

                // Finish activity and go back
                finish();
            }
        });

        // Instantiate  button with onClick event
        rideBtn = (Button) findViewById(R.id.rideBtn);
        rideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Ride button clicked");

                // Finish activity and go back
                Intent intent = new Intent(HomeActivity.this, ParkingActivity.class);
                startActivity(intent);
            }
        });
    }
}
