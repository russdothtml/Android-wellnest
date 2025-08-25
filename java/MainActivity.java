package com.example.wellnestlayoutjournal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton imagebutton = findViewById(R.id.createjournal_image_button);

        imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, write_a_journal.class));
            }
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