package com.example.wellnestlayoutjournal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class Exercises extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises); // Ensure this layout exists

        // Back button to navigate to MainActivity
        ImageButton backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> startActivity(new Intent(Exercises.this, MainActivity.class)));
        // Set up click listeners for exercise cards
        setupClickListeners();
    }
    private void setupClickListeners() {
        findViewById(R.id.jogging_card).setOnClickListener(v -> openJoggingType());
        findViewById(R.id.yoga_card).setOnClickListener(v -> openYogaType());
        findViewById(R.id.breathing_exercises_card).setOnClickListener(v -> openBreathingExercisesType());
        findViewById(R.id.meditation_card).setOnClickListener(v -> openMeditationType());
        findViewById(R.id.bodyweight_squats_card).setOnClickListener(v -> openBodyweightSquatsType());
    }

    private void openJoggingType() {
        startActivity(new Intent(Exercises.this, Joggingtype.class)); // Navigate to Joggingtype activity
    }

    private void openYogaType() {
        startActivity(new Intent(Exercises.this, Yogatype.class)); // Navigate to Yogatype activity
    }

    private void openBreathingExercisesType() {
        startActivity(new Intent(Exercises.this, breathingexercisestype.class)); // Navigate to Breathing Exercises activity
    }

    private void openMeditationType() {
        startActivity(new Intent(Exercises.this, meditationtype.class)); // Navigate to Meditation activity
    }

    private void openBodyweightSquatsType() {
        startActivity(new Intent(Exercises.this, bodyweightsquatstype.class)); // Navigate to Bodyweight Squats activity
    }

    public void openJoggingtype(View view) {
        startActivity(new Intent(Exercises.this, Joggingtype.class));
    }

    public void openYogaType(View view) {
        startActivity(new Intent(Exercises.this, Yogatype.class));
    }

    public void openBreathingExercisesType(View view) {
        startActivity(new Intent(Exercises.this, breathingexercisestype.class));
    }

    public void openMeditationType(View view) {
        startActivity(new Intent(Exercises.this, meditationtype.class));
    }

    public void openBodyweightSquatsType(View view) {
        startActivity(new Intent(Exercises.this, bodyweightsquatstype.class));
    }
}