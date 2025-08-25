package com.example.wellnestlayoutjournal;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class road_jogging_detailed_activity extends AppCompatActivity { // Renamed to follow Java naming conventions

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road_jogging_detailed);

        // Back button to close the activity
        ImageButton backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> finish()); // Close the activity and return to the previous one
    }
}