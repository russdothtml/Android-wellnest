package com.example.wellnestlayoutjournal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class Joggingtype extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogging_type);

        // Back button
        ImageButton backButton = findViewById(R.id.back_button);
        if (backButton != null) {
            backButton.setOnClickListener(v -> finish());
        }

        // Click listener for the road jogging section
        View roadJogging = findViewById(R.id.imageJogging); // must match XML ID
        if (roadJogging != null) {
            roadJogging.setOnClickListener(v -> {
                Intent intent = new Intent(Joggingtype.this, roadjogging.class);
                startActivity(intent);
            });
        }
    }
}
