package com.example.pedla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class BadiLake extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badi_lake);
        textView=findViewById(R.id.descrip1);
        String d="Lake Badi, situated in Udaipur city in the Indian state of Rajasthan, is an artificial fresh water lake. The lake was built in the village of Badi, about 12 km from the city of Udaipur, by Maharana Raj Singh I to counteract the devastating effects of a famine. He named it Jiyan Sagar after his mother Jana Devi.\n" +
                "Area: 155 km²\n" +
                "Length: 180 m\n" +
                "Width: 18 m\n" +
                "Location: Udaipur, Rajasthan\n" +
                "Fish: Putitor mahseer\n" +
                "Cities: Udaipur\n" +
                "The highlight of the lake is a small hill called ‘Bahubali’. It is a must visit when in Udaipur";
        textView.setText(d);

    }
}