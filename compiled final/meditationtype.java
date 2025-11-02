package com.example.wellnestlayoutjournal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class meditationtype extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation_type);

        ImageButton backButton = findViewById(R.id.back_button);
        if (backButton != null) backButton.setOnClickListener(v -> finish());

        View mindfulness = findViewById(R.id.imageMindfulnessMeditation);
        if (mindfulness != null) mindfulness.setOnClickListener(v -> startActivity(new Intent(meditationtype.this, mindfulnessmeditation.class)));
    }
}
