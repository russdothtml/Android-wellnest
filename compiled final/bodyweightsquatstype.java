package com.example.wellnestlayoutjournal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class bodyweightsquatstype extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bodyweight_squats_type);

        ImageButton backButton = findViewById(R.id.back_button);
        if (backButton != null) backButton.setOnClickListener(v -> finish());

        View imgStd = findViewById(R.id.imageStandardSquat);
        if (imgStd != null) imgStd.setOnClickListener(v -> startActivity(new Intent(bodyweightsquatstype.this, standardsquat.class)));
    }
}
