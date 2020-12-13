package com.example.pedla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class GovardhanSagar extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_govardhan_sagar);
        textView=findViewById(R.id.descrip5);
        String d="In a Beautiful evening with Family I visit Goverdhan Sagar. Its beautiful place in Udaipur Goverdhan Vilas. With a Park & a Museum of Panna Dhay with a Historical Video open till 9 PM. A temple near Sagar make it more attractive. Nice place for PICNIC.";
        textView.setText(d);
    }
}