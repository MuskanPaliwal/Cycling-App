package com.example.pedla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Trynna extends AppCompatActivity {
TextView tet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trynna);
        tet.findViewById(R.id.trynna);
        tet.setText(getIntent().getStringExtra("title"));
    }
}