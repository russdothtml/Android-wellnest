package com.example.wellnestlayoutjournal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class breathingexercisestype extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathing_exercises_type);

        // Back button to close the activity
        ImageButton backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> finish()); // Close the activity

        findViewById(R.id.imageDiaphragmaticBreathing).setOnClickListener(v -> {
            startActivity(new Intent(breathingexercisestype.this, diaphragmaticbreathing.class));
        });
    }
}