package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewActivity extends AppCompatActivity {

    List<ContactModel> elements;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycle_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addData();
    }

    private void addData() {
        elements = new ArrayList<>();

        elements.add(new ContactModel("#46C8DA", "Inami Anju", "0812345678910", "Available"));
        elements.add(new ContactModel("#46C8DA", "Saito Shuka", "0812345678910", "Available"));
        elements.add(new ContactModel("#46C8DA", "Aida Rikako", "0812345678910", "Available"));
        elements.add(new ContactModel("#46C8DA", "Kobayashi Aika", "0812345678910", "Available"));
        elements.add(new ContactModel("#46C8DA", "Furihata Ai", "0812345678910", "Available"));
        elements.add(new ContactModel("#46C8DA", "Komiya Arisha", "0812345678910", "Available"));
        elements.add(new ContactModel("#46C8DA", "Suzuki Aina", "0812345678910", "Available"));
        elements.add(new ContactModel("#46C8DA", "Nanaka Suwa", "0812345678910", "Available"));
        elements.add(new ContactModel("#46C8DA", "Takatsuki Kanako", "0812345678910", "Available"));

        ContactAdapter adapter = new ContactAdapter(elements, this, item -> {
            //
        });

        RecyclerView recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}