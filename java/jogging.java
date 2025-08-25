package com.example.wellnestlayoutjournal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class jogging extends AppCompatActivity { // Renamed to follow Java naming conventions

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogging);

        // Back button to close the activity
        ImageButton backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> finish()); // Close the activity

        // Set up click listener for Road Jogging section
        findViewById(R.id.imageJogging).setOnClickListener(v -> {
            startActivity(new Intent(jogging.this, road_jogging_detailed_activity.class));
        });

        // Set up click listener for Trail Jogging section
        findViewById(R.id.imageTrailJogging).setOnClickListener(v -> {
            startActivity(new Intent(jogging.this, road_jogging_detailed_activity.class)); // Assuming same detailed activity
        });
    }
}