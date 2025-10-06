package com.example.wellnestlayoutjournal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class writeajournal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_a_journal);

        ImageButton imagebutton2 = findViewById(R.id.back_image_button2);

        imagebutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(writeajournal.this, MainActivity.class));
            }
        });
    }
}