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
        backButton.setOnClickListener(v -> finish()); // Close the activity
    }
    public void openMindfulnessMeditation(View view) {
        Intent intent = new Intent(meditationtype.this, hathayoga.class);
        startActivity(intent);
    }
}
