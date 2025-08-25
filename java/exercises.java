package com.example.wellnestlayoutjournal;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;



public class exercises extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises); // Ensure this layout exists

        // Back button to navigate to MainActivity
        ImageButton backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(exercises.this, MainActivity.class));
            }
        });

        // Set up cards with click listeners
        findViewById(R.id.jogging_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openJoggingDetail(v);
            }
        });

        findViewById(R.id.yoga_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYogaDetail(v);
            }
        });

        findViewById(R.id.breathing_exercises_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBreathingExercisesDetail(v);
            }
        });

        findViewById(R.id.meditation_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMeditationDetail(v);
            }
        });

        findViewById(R.id.bodyweight_squats_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBodyweightSquatsDetail(v);
            }
        });
    }

    public void openJoggingDetail(View view) {
        Intent intent = new Intent(this, JoggingDetailActivity.class);
        startActivity(intent);
    }

    public void openYogaDetail(View view) {
        Intent intent = new Intent(this, YogaDetailActivity.class);
        startActivity(intent);
    }

    public void openBreathingExercisesDetail(View view) {
        Intent intent = new Intent(this, BreathingExercisesDetailActivity.class);
        startActivity(intent);
    }

    public void openMeditationDetail(View view) {
        Intent intent = new Intent(this, MeditationDetailActivity.class);
        startActivity(intent);
    }

    public void openBodyweightSquatsDetail(View view) {
        Intent intent = new Intent(this, BodyweightSquatsDetailActivity.class);
        startActivity(intent);
    }
}}