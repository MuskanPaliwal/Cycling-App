package com.example.pedla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DoodhTalayi extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doodh_talayi);
        textView=findViewById(R.id.descrip3);
        String d="Contiguous to the beautiful Lake of Pichola, Dudh Talai Lake is a dainty pond at the epicenter of the Udaipur. Encompassed by the marvelous hillocks all around, this lake holds out venturing activities of camel and horse ride. Besides, the beautiful garden of Manikya Lal Verma owing its origin back to the year of 1995 enriches the beauty of Doodh Talai along sides offering the marvelous view of the serene Pichola and the lake of Doodh Talai.";
        textView.setText(d);
    }
}