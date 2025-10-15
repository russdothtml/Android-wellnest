package com.example.wellnestlayoutjournal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Exercises extends AppCompatActivity implements View.OnClickListener {

    CardView cardView_joggingcard;
    CardView cardView_yogacard;
    CardView cardView_breathingexercisescard;
    CardView cardView_meditationcard;
    CardView cardView_bodyweightsquatscard;

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

        // Set listeners
        cardView_joggingcard.setOnClickListener(this);
        cardView_yogacard.setOnClickListener(this);
        cardView_breathingexercisescard.setOnClickListener(this);
        cardView_meditationcard.setOnClickListener(this);
        cardView_bodyweightsquatscard.setOnClickListener(this);

        // Back button (to MainActivity)
        ImageButton backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> startActivity(new Intent(Exercises.this, MainActivity.class)));
    }

    @Override
    public void onClick(View view) {
        // Handle each card click
        if (view.getId() == R.id.jogging_card) {
            Intent intent = new Intent(Exercises.this, Joggingtype.class);
            startActivity(intent);
        }
        // (optional: you can add the rest of your cards later)
    }
}
