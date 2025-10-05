package com.example.wellnestlayoutjournal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity {

    private EditText emailInput, passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        emailInput = findViewById(R.id.email_input);
        passwordInput = findViewById(R.id.password_input);
        Button signInButton = findViewById(R.id.sign_in_button);
        TextView registerLink = findViewById(R.id.register_link);

        signInButton.setOnClickListener(v -> signIn());
        registerLink.setOnClickListener(v -> {
            Intent intent = new Intent(SignInActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    private void signIn() {
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();

        // Add your authentication logic here (e.g., Firebase Auth)

        Toast.makeText(this, "Sign In successful for: " + email, Toast.LENGTH_SHORT).show();
        // Navigate to MainActivity after successful sign-in
        startActivity(new Intent(SignInActivity.this, MainActivity.class));
    }
}