package com.example.wellnestlayoutjournal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Exercises extends AppCompatActivity implements View.OnClickListener {

    private CardView cardView_joggingcard, cardView_yogacard,
            cardView_breathingexercisescard, cardView_meditationcard,
            cardView_bodyweightsquatscard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        // Initialize CardViews
        cardView_joggingcard = findViewById(R.id.jogging_card);
        cardView_yogacard = findViewById(R.id.yoga_card);
        cardView_breathingexercisescard = findViewById(R.id.breathing_exercises_card);
        cardView_meditationcard = findViewById(R.id.meditation_card);
        cardView_bodyweightsquatscard = findViewById(R.id.bodyweight_squats_card);

        // Set click listeners
        cardView_joggingcard.setOnClickListener(this);
        cardView_yogacard.setOnClickListener(this);
        cardView_breathingexercisescard.setOnClickListener(this);
        cardView_meditationcard.setOnClickListener(this);
        cardView_bodyweightsquatscard.setOnClickListener(this);

        // Back button — returns to MainActivity
        ImageButton backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(Exercises.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

    @Override
    public void onClick(View view) {
        // Handle each exercise card click
        int id = view.getId();

        if (id == R.id.jogging_card) {
            startActivity(new Intent(Exercises.this, Joggingtype.class));
        }
        else if (id == R.id.yoga_card) {
            // Optional: Add when YogaType activity is ready
            // startActivity(new Intent(Exercises.this, Yogatype.class));
        }
        else if (id == R.id.breathing_exercises_card) {
            // startActivity(new Intent(Exercises.this, BreathingExerciseType.class));
        }
        else if (id == R.id.meditation_card) {
            // startActivity(new Intent(Exercises.this, MeditationType.class));
        }
        else if (id == R.id.bodyweight_squats_card) {
            // startActivity(new Intent(Exercises.this, BodyweightSquatsType.class));
        }
    }
}
