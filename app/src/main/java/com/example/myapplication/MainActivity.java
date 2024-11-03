package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Bundle bundle;
    EditText studyProgramInput;
    Button submitButton, formButton;
    TextView nameText, studentIdText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        studyProgramInput = findViewById(R.id.study_program_input);
        submitButton = findViewById(R.id.submit_button);
        nameText = findViewById(R.id.name_text);
        studentIdText = findViewById(R.id.student_id_text);

        bundle = new Bundle();

        bundle.putString("name", nameText.getText().toString());
        bundle.putString("studentId", studentIdText.getText().toString());

        submitButton.setOnClickListener(v -> {
            if (studyProgramInput.getText().toString().isEmpty()) {
                Toast.makeText(this, "Program Studi Mahasiswa tidak boleh kosong", Toast.LENGTH_SHORT).show();
                return;
            }

            bundle.putString("studyProgram", studyProgramInput.getText().toString());

            Intent i = new Intent(MainActivity.this, BioActivity.class);
            i.putExtras(bundle);
            startActivity(i);
        });

        formButton = findViewById(R.id.form_button);

        formButton.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, FormActivity.class);
            startActivity(i);
        });
    }
}