package com.example.wellnestlayoutjournal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class Joggingtype extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogging_type);

        // Back button to close the activity
        ImageButton backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> finish()); // Close the activity

        // Set up click listener for Road Jogging section
        findViewById(R.id.imageJogging).setOnClickListener(v -> {
            startActivity(new Intent(Joggingtype.this, roadjogging.class));
        });
    }
}