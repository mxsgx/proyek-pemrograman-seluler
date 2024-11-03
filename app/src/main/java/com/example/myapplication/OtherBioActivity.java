package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OtherBioActivity extends AppCompatActivity {

    Bundle bundle;
    TextView addressText, phoneNumberText, emailText, genderText, classText, clubAndActivityText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_other_bio);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bundle = getIntent().getExtras();

        addressText = findViewById(R.id.address_text);
        phoneNumberText = findViewById(R.id.phone_number_text);
        emailText = findViewById(R.id.email_text);
        genderText = findViewById(R.id.gender_text);
        classText = findViewById(R.id.class_text);
        clubAndActivityText = findViewById(R.id.club_and_activity_text);

        addressText.setText(bundle.getString("address"));
        phoneNumberText.setText(bundle.getString("phoneNumber"));
        emailText.setText(bundle.getString("email"));
        genderText.setText(bundle.getString("gender"));
        classText.setText(bundle.getString("class"));
        clubAndActivityText.setText(bundle.getString("clubAndActivity"));
    }
}