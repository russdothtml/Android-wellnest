package com.example.wellnestlayoutjournal;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class Joggingtype extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogging_type);

        ImageButton backButton = findViewById(R.id.back_button);
        if (backButton != null) backButton.setOnClickListener(v -> finish());

        // Example: make the Road Jogging section open a detailed page if desired:
        View road = findViewById(R.id.imageJogging);
        if (road != null) {
            road.setOnClickListener(v -> startActivity(new Intent(Joggingtype.this, roadjogging.class)));
        }
    }
}
