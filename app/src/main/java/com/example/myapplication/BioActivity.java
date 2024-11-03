package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BioActivity extends AppCompatActivity {

    Bundle bundle;
    TextView nameText, studentIdText, studyProgramText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bio);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bundle = getIntent().getExtras();
        nameText = findViewById(R.id.name_text);
        studentIdText = findViewById(R.id.student_id_text);
        studyProgramText = findViewById(R.id.study_program_text);

        nameText.setText(bundle.getString("name"));
        studentIdText.setText(bundle.getString("studentId"));
        studyProgramText.setText(bundle.getString("studyProgram"));
    }
}