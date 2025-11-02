package com.example.wellnestlayoutjournal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class breathingexercisestype extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathing_exercises_type);

        ImageButton backButton = findViewById(R.id.back_button);
        if (backButton != null) backButton.setOnClickListener(v -> finish());

        View dia = findViewById(R.id.imageDiaphragmaticBreathing);
        if (dia != null) dia.setOnClickListener(v -> startActivity(new Intent(breathingexercisestype.this, diaphragmaticbreathing.class)));
    }
}
