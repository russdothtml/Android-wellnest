package com.example.wellnestlayoutjournal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class writeajournal extends AppCompatActivity {

    private EditText editTextText2, editTextText3, editTextText;
    private Spinner mood_spinner;
    private ImageButton send_button, back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_a_journal);

        // --- Defensive Null Checks to prevent silent crashes ---
        back_button = findViewById(R.id.back_button);
        if (back_button == null) {
            showErrorAndFinish("Error: 'back_button' not found in layout.");
            return;
        }

        send_button = findViewById(R.id.send_button);
        if (send_button == null) {
            showErrorAndFinish("Error: 'send_button' not found in layout.");
            return;
        }

        editTextText2 = findViewById(R.id.editTextText2);
        if (editTextText2 == null) {
            showErrorAndFinish("Error: Date EditText not found.");
            return;
        }

        editTextText3 = findViewById(R.id.editTextText3);
        if (editTextText3 == null) {
            showErrorAndFinish("Error: Title EditText not found.");
            return;
        }

        editTextText = findViewById(R.id.editTextText);
        if (editTextText == null) {
            showErrorAndFinish("Error: Content EditText not found.");
            return;
        }

        mood_spinner = findViewById(R.id.mood_spinner);
        if (mood_spinner == null) {
            showErrorAndFinish("Error: 'mood_spinner' not found.");
            return;
        }
        // --- End of Null Checks ---

        back_button.setOnClickListener(v -> finish());
        send_button.setOnClickListener(v -> saveJournal());
    }

    private void showErrorAndFinish(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        finish(); // Close this activity to prevent further errors
    }

    private void saveJournal() {
        String date = editTextText2.getText().toString().trim();
        String title = editTextText3.getText().toString().trim();
        String content = editTextText.getText().toString().trim();
        String mood = mood_spinner.getSelectedItem() != null ? mood_spinner.getSelectedItem().toString() : "";

        if (date.isEmpty() || title.isEmpty() || content.isEmpty()) {
            Toast.makeText(this, "Please fill all fields before saving", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences prefs = getSharedPreferences("JournalPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        try {
            JSONArray journalArray;
            String existingData = prefs.getString("journals", "[]");
            journalArray = new JSONArray(existingData);

            JSONObject newJournal = new JSONObject();
            newJournal.put("date", date);
            newJournal.put("title", title);
            newJournal.put("content", content);
            newJournal.put("mood", mood);

            journalArray.put(newJournal);

            editor.putString("journals", journalArray.toString());
            editor.apply();

            Toast.makeText(this, "Journal saved successfully!", Toast.LENGTH_SHORT).show();

            // Redirect back to Journal activity
            Intent intent = new Intent(writeajournal.this, journal.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error saving journal.", Toast.LENGTH_SHORT).show();
        }
    }
}
