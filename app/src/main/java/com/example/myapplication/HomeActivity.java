package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(this);
        Button logoutButton = findViewById(R.id.logout_button);

        logoutButton.setOnClickListener(v -> {
            sharedPreferencesManager.logout();
            navigateToLogin();
        });

        if (!sharedPreferencesManager.isLoggedIn()) {
            navigateToLogin();
        }
    }

    private void navigateToLogin() {
        Intent i = new Intent(HomeActivity.this, SharedPreferencesActivity.class);

        startActivity(i);
        finishAffinity();
    }
}