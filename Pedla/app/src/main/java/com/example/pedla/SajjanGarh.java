package com.example.pedla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SajjanGarh extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sajjan_garh);
        textView=findViewById(R.id.descrip4);
        String d="Sajjangarh, also known as the 'Monsoon Palace', is a wonderful palatial building in Udaipur. The palace is perched at an elevation of 944 m from sea level on the Bansdara Peak of the Aravalli Range. Maharana Sajjan Singh of the Mewar Dynasty built the palace in 1884 to watch the monsoon clouds.\n" +
                "\n" +
                "This beautiful palace is constructed with white marble. Travellers can enjoy amazing views of the Pichola Lake and the surrounding countryside from this place.";
        textView.setText(d);
    }
}