package com.example.wellnestlayoutjournal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class exercises extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises); // Ensure this layout exists

        // Back button to navigate to MainActivity
        ImageButton backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> {
            startActivity(new Intent(exercises.this, MainActivity.class));
        });

        // Set up click listeners for exercise cards
        setupClickListeners();
    }

    private void setupClickListeners() {
        findViewById(R.id.jogging_card).setOnClickListener(v -> {
            startActivity(new Intent(exercises.this, jogging.class)); // Navigate to jogging activity
        });

        findViewById(R.id.yoga_card).setOnClickListener(v -> {
            startActivity(new Intent(exercises.this, yoga.class));
        });

        findViewById(R.id.breathing_exercises_card).setOnClickListener(v -> {
            startActivity(new Intent(exercises.this, breathing_exercises.class));
        });

        findViewById(R.id.meditation_card).setOnClickListener(v -> {
            startActivity(new Intent(exercises.this, meditation.class));
        });

        findViewById(R.id.bodyweight_squats_card).setOnClickListener(v -> {
            startActivity(new Intent(exercises.this, bodyweight_squats.class));
        });
    }

    // Optional: If you need to open detailed views directly, you can keep these methods
    public void openJoggingDetail(View view) {
        Intent intent = new Intent(exercises.this, road_jogging_detailed_activity.class);
        startActivity(intent);
    }

    public void openYogaDetail(View view) {
        Intent intent = new Intent(exercises.this, yoga_detailed_activity.class);
        startActivity(intent);
    }

    public void openBreathingExercisesDetail(View view) {
        Intent intent = new Intent(exercises.this, breathing_exercises_detailed_activity.class);
        startActivity(intent);
    }

    public void openMeditationDetail(View view) {
        Intent intent = new Intent(exercises.this, meditation_detailed_activity.class);
        startActivity(intent);
    }

    public void openBodyweightSquatsDetail(View view) {
        Intent intent = new Intent(exercises.this, bodyweight_squats_detailed_activity.class);
        startActivity(intent);
    }
}