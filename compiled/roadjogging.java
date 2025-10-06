package com.example.wellnestlayoutjournal;

import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class roadjogging extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road_jogging);

        // Back button to close the activity
        ImageButton backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> finish()); // Close the activity and return to the previous one
    }
}