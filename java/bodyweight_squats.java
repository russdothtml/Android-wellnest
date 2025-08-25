package com.example.wellnestlayoutjournal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class bodyweight_squats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bodyweight_squats); // Ensure this layout exists

        // Set up the back button
        findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Close this activity and return to the previous one
            }
        });
    }

    public void openStandardSquat(View view) {
        Intent intent = new Intent(this, jump_squat_detailed_activity.class);
        startActivity(intent);
    }

    public void openJumpSquat(View view) {
        Intent intent = new Intent(this, JumpSquatDetailActivity.class);
        startActivity(intent);
    }

    public void openPistolSquat(View view) {
        Intent intent = new Intent(this, PistolSquatDetailActivity.class);
        startActivity(intent);
    }
}