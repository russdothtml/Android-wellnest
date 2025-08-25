package com.example.wellnestlayoutjournal;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class bodyweight_squats_detailed_activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bodyweight_squats_detailed);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> finish()); // Close the activity
    }
}
