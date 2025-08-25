package com.example.wellnestlayoutjournal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button; // Change to Button if using a regular button
import androidx.appcompat.app.AppCompatActivity;

public class standard_squat_detailed_activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard_squat_detailed_activity); // Ensure this layout exists

        // Back button to close the activity
        Button backButton = findViewById(R.id.backButton); // Ensure this matches the layout ID
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Close the activity
            }
        });
    }
}