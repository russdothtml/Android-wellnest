package com.example.wellnestlayoutjournal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class journal extends AppCompatActivity {

    ImageButton back_button, addjournalbutton;
    LinearLayout journalcontainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);

        back_button = findViewById(R.id.back_button);
        addjournalbutton = findViewById(R.id.addjournalbutton);
        journalcontainer = findViewById(R.id.journalcontainer);

        if (addjournalbutton == null) {
            Toast.makeText(this, "Error: addjournalbutton not found in layout!", Toast.LENGTH_LONG).show();
            return;
        }

        back_button.setOnClickListener(v -> finish());

        addjournalbutton.setOnClickListener(v -> {
            Toast.makeText(journal.this, "Opening Write a Journal...", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(journal.this, writeajournal.class);
            startActivity(intent);
        });

        loadSavedJournals();
    }

    @Override
    protected void onResume() {
        super.onResume();
        journalcontainer.removeAllViews();
        loadSavedJournals();
    }

    private void loadSavedJournals() {
        SharedPreferences prefs = getSharedPreferences("JournalPrefs", MODE_PRIVATE);
        String data = prefs.getString("journals", "[]");

        try {
            JSONArray array = new JSONArray(data);
            LayoutInflater inflater = LayoutInflater.from(this);

            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                String date = obj.getString("date");
                String title = obj.getString("title");
                String mood = obj.getString("mood");

                CardView cardView = (CardView) inflater.inflate(R.layout.item_journal_card, journalcontainer, false);

                TextView dateText = cardView.findViewById(R.id.date_text);
                TextView titleText = cardView.findViewById(R.id.title_text);
                TextView moodText = cardView.findViewById(R.id.mood_text);

                dateText.setText(date);
                titleText.setText(title);
                moodText.setText("Mood: " + mood);

                journalcontainer.addView(cardView);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}