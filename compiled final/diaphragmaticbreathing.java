package com.example.wellnestlayoutjournal;

import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class diaphragmaticbreathing extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diaphragmatic_breathing); // Ensure this layout exists

        // Back button to close the activity
        ImageButton backButton = findViewById(R.id.back_button); // Ensure this matches the layout ID
        backButton.setOnClickListener(v -> finish()); // Close the activity
    }
}