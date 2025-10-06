package com.example.wellnestlayoutjournal;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class journal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);

        ImageButton createJournalButton = findViewById(R.id.create_journal_image_button);
        createJournalButton.setOnClickListener(v -> {
            startActivity(new Intent(journal.this, writeajournal.class));
        });
    }

    public void showMonthList(View view) {
    }

    public void openJournalEntry1(View view) {
    }

    public void openJournalEntry2(View view) {
    }

    public void openJournalEntry3(View view) {
    }

    public void openJournalEntry4(View view) {
    }
}