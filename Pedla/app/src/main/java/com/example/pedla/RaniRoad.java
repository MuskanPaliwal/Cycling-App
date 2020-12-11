package com.example.pedla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class RaniRoad extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rani_road);
        textView=findViewById(R.id.descrip2);
        String d="Rani road a new  place for hangout in udaipur with nature and modern art. where you will find lots of  modern art monument made from marble scrape. Rani road which is a clean, calm place to seat at evening with your friends.A new place for Running ,Cycling, Mourning walk in udaipur. A new place to visit in udaipur.";
        textView.setText(d);
    }
}