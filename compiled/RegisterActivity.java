package com.example.wellnestlayoutjournal;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText usernameInput, emailInput, passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usernameInput = findViewById(R.id.username_input);
        emailInput = findViewById(R.id.email_input);
        passwordInput = findViewById(R.id.password_input);
        Button registerButton = findViewById(R.id.register_button);

        registerButton.setOnClickListener(v -> register());
    }

    private void register() {
        String username = usernameInput.getText().toString();
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();

        // Add your registration logic here (e.g., Firebase Auth)

        Toast.makeText(this, "Registration successful for: " + username, Toast.LENGTH_SHORT).show();
        // Optionally, navigate to SignInActivity or MainActivity
        finish(); // Close the registration activity
    }
}