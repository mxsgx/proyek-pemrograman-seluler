package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;

public class FormActivity extends AppCompatActivity {

    Bundle bundle;
    Button saveButton;
    EditText addressInput, phoneNumberInput, emailInput, passwordInput;
    RadioGroup genderInputGroup;
    RadioButton genderInput;
    CheckBox[] clubAndActivityInputs;
    Spinner classInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        saveButton = findViewById(R.id.save_button);
        addressInput = findViewById(R.id.address_input);
        phoneNumberInput = findViewById(R.id.phone_number_input);
        emailInput = findViewById(R.id.email_input);
        passwordInput = findViewById(R.id.password_input);
        genderInputGroup = findViewById(R.id.gender_input_group);
        classInput = findViewById(R.id.class_input);
        clubAndActivityInputs = new CheckBox[]{
                findViewById(R.id.club_and_activity_value_1),
                findViewById(R.id.club_and_activity_value_2),
                findViewById(R.id.club_and_activity_value_3),
        };

        bundle = new Bundle();

        saveButton.setOnClickListener(v -> {
            String clubAndActivity = String.join(", ", Arrays.stream(clubAndActivityInputs).filter(CompoundButton::isChecked).map(i -> i.getText().toString()).toArray(String[]::new));
            int selectedGenderInputId = genderInputGroup.getCheckedRadioButtonId();
            genderInput = findViewById(selectedGenderInputId);

            bundle.putString("address", addressInput.getText().toString());
            bundle.putString("phoneNumber", phoneNumberInput.getText().toString());
            bundle.putString("email", emailInput.getText().toString());
            bundle.putString("password", passwordInput.getText().toString());
            bundle.putString("gender", genderInput.getText().toString());
            bundle.putString("class", classInput.getSelectedItem().toString());
            bundle.putString("clubAndActivity", clubAndActivity);

            Intent i = new Intent(FormActivity.this, OtherBioActivity.class);

            i.putExtras(bundle);

            startActivity(i);
        });
    }
}