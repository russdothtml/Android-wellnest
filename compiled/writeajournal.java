package com.example.wellnestlayoutjournal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class writeajournal extends AppCompatActivity {

    private EditText dateInput, titleInput, contentInput;
    private ImageButton sendButton, backButton;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_a_journal); // ✅ matches your XML filename

        dateInput = findViewById(R.id.editTextText2);
        titleInput = findViewById(R.id.editTextText3);
        contentInput = findViewById(R.id.editTextText);
        sendButton = findViewById(R.id.send_button);
        backButton = findViewById(R.id.back_button);

        sharedPreferences = getSharedPreferences("JournalData", Context.MODE_PRIVATE);

        // Back button → return to journal page
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(writeajournal.this, journal.class);
            startActivity(intent);
            finish();
        });

        // Send button → save and go back
        sendButton.setOnClickListener(v -> saveJournal());
    }

    private void saveJournal() {
        String date = dateInput.getText().toString().trim();
        String title = titleInput.getText().toString().trim();
        String content = contentInput.getText().toString().trim();

        if (date.isEmpty() || title.isEmpty() || content.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            String savedData = sharedPreferences.getString("journals", "[]");
            JSONArray journalArray = new JSONArray(savedData);

            JSONObject newJournal = new JSONObject();
            newJournal.put("date", date);
            newJournal.put("title", title);
            newJournal.put("content", content);
            newJournal.put("mood", "Neutral");

            journalArray.put(newJournal);

            sharedPreferences.edit().putString("journals", journalArray.toString()).apply();

            Toast.makeText(this, "Journal saved!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(writeajournal.this, journal.class);
            startActivity(intent);
            finish();

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error saving journal", Toast.LENGTH_SHORT).show();
        }
    }
}
