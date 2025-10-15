package com.example.wellnestlayoutjournal;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class JournalDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_detail);

        TextView date = findViewById(R.id.detail_date);
        TextView title = findViewById(R.id.detail_title);
        TextView mood = findViewById(R.id.detail_mood);

        date.setText(getIntent().getStringExtra("date"));
        title.setText(getIntent().getStringExtra("title"));
        mood.setText("Mood: " + getIntent().getStringExtra("mood"));
    }
}
