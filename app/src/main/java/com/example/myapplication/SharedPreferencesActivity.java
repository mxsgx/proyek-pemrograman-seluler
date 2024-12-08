package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SharedPreferencesActivity extends AppCompatActivity {
    private final Handler handler = new Handler();
    private EditText emailEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shared_preferences);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(this);
        emailEditText = findViewById(R.id.email_input);
        passwordEditText = findViewById(R.id.password_input);
        Button loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(v -> {
            final String email = emailEditText.getText().toString();
            final String password = passwordEditText.getText().toString();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(SharedPreferencesActivity.this, "Email atau password tidak boleh kosong.", Toast.LENGTH_SHORT).show();
            } else {
                handler.postDelayed(() -> {
                    if (email.equals(sharedPreferencesManager.getEmail()) && password.equals(sharedPreferencesManager.getPassword())) {
                        sharedPreferencesManager.login();
                        navigateToHome();
                    } else {
                        Toast.makeText(SharedPreferencesActivity.this, "Email atau password tidak valid.", Toast.LENGTH_SHORT).show();
                    }
                }, 1);
            }
        });

        if (sharedPreferencesManager.isLoggedIn()) {
            navigateToHome();
        }
    }

    private void navigateToHome() {
        Intent i = new Intent(SharedPreferencesActivity.this, HomeActivity.class);

        startActivity(i);
        finishAffinity();
    }
}