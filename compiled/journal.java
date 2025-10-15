package com.example.wellnestlayoutjournal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import java.util.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class journal extends AppCompatActivity {

    private TextView monthTextView;
    private LinearLayout journalList;
    private SharedPreferences prefs;

    private final Map<String, List<JournalEntry>> journalEntries = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal); // ✅ uses journal.xml

        prefs = getSharedPreferences("JournalPrefs", MODE_PRIVATE);

        // ✅ Match XML IDs
        monthTextView = findViewById(R.id.monthtext);
        journalList = findViewById(R.id.journalcontainer);

        ImageButton addButton = findViewById(R.id.addjournalbutton);
        ImageButton backButton = findViewById(R.id.back_button);
        ImageView dropdownArrow = findViewById(R.id.monthdropdownArrow);

        // ✅ Journal data per month
        journalEntries.put("July", Arrays.asList(
                new JournalEntry("25 July, 2025", "We won a game!", "Happy", "#FFF176"),
                new JournalEntry("26 July, 2025", "I lost my pet", "Sad", "#FFD54F"),
                new JournalEntry("27 July, 2025", "I got the highest score!", "Happy", "#FFB74D"),
                new JournalEntry("28 July, 2025", "Thinking about what I did to my friend", "Concerned", "#F06292")
        ));

        journalEntries.put("June", Arrays.asList(
                new JournalEntry("15 June, 2025", "Trip with family", "Excited", "#FFEB3B"),
                new JournalEntry("20 June, 2025", "Study day", "Calm", "#03A9F4")
        ));

        // Load default month
        loadJournalEntries("July");

        // ✅ Button actions
        dropdownArrow.setOnClickListener(v -> showMonthDropdown());
        addButton.setOnClickListener(v -> startActivity(new Intent(this, writeajournal.class)));
        backButton.setOnClickListener(v -> finish());
    }

    private void showMonthDropdown() {
        final String[] months = {"January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Month");
        builder.setItems(months, (dialog, which) -> {
            monthTextView.setText(months[which]);
            loadJournalEntries(months[which]);
        });
        builder.show();
    }

    private void loadJournalEntries(String month) {
        journalList.removeAllViews();

        List<JournalEntry> entries = new ArrayList<>();

        // Load hardcoded entries for the selected month
        if (journalEntries.containsKey(month)) {
            entries.addAll(journalEntries.get(month));
        }

        // Load saved journals from SharedPreferences
        String savedData = getSharedPreferences("JournalData", MODE_PRIVATE)
                .getString("journals", "[]");

        try {
            JSONArray array = new JSONArray(savedData);
            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                String date = obj.getString("date");
                String title = obj.getString("title");
                String mood = obj.getString("mood");
                String color = "#FFF176"; // default color
                entries.add(new JournalEntry(date, title, mood, color));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (entries.isEmpty()) {
            TextView empty = new TextView(this);
            empty.setText("No journal entries for " + month);
            empty.setPadding(16, 16, 16, 16);
            empty.setTextColor(Color.BLACK);
            journalList.addView(empty);
            return;
        }

        for (JournalEntry entry : entries) {
            // Restore saved mood if exists
            String savedMood = prefs.getString(entry.title, entry.mood);
            entry.mood = savedMood;

            CardView card = new CardView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 0, 0, 16);
            card.setLayoutParams(params);
            card.setRadius(16);
            card.setCardBackgroundColor(Color.parseColor(entry.color));

            LinearLayout inner = new LinearLayout(this);
            inner.setOrientation(LinearLayout.VERTICAL);
            inner.setPadding(32, 32, 32, 32);

            TextView date = new TextView(this);
            date.setText(entry.date);
            date.setTextSize(18);
            date.setTextColor(Color.BLACK);

            TextView title = new TextView(this);
            title.setText(entry.title);
            title.setTextSize(22);
            title.setTextColor(Color.BLACK);
            title.setTypeface(null, android.graphics.Typeface.BOLD);

            TextView mood = new TextView(this);
            mood.setText("Mood: " + entry.mood);
            mood.setTextSize(16);
            mood.setTextColor(Color.BLACK);
            mood.setTypeface(null, android.graphics.Typeface.BOLD);

            inner.addView(date);
            inner.addView(title);
            inner.addView(mood);

            card.addView(inner);
            journalList.addView(card);

            // Change mood
            mood.setOnClickListener(v -> showMoodChanger(entry, mood));

            // Open full journal
            card.setOnClickListener(v -> {
                Intent intent = new Intent(journal.this, JournalDetailActivity.class);
                intent.putExtra("date", entry.date);
                intent.putExtra("title", entry.title);
                intent.putExtra("mood", entry.mood);
                startActivity(intent);
            });
        }
    }

    private void showMoodChanger(JournalEntry entry, TextView moodView) {
        final String[] moods = {"Happy", "Sad", "Excited", "Calm", "Angry", "Concerned"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Change Mood");
        builder.setItems(moods, (dialog, which) -> {
            entry.mood = moods[which];
            moodView.setText("Mood: " + entry.mood);
            saveMood(entry.title, entry.mood);
        });
        builder.show();
    }

    private void saveMood(String title, String mood) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(title, mood);
        editor.apply();
    }

    static class JournalEntry {
        String date, title, mood, color;
        JournalEntry(String date, String title, String mood, String color) {
            this.date = date;
            this.title = title;
            this.mood = mood;
            this.color = color;
        }
    }
}
