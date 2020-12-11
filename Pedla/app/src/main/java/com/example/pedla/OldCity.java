package com.example.pedla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class OldCity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_city);
        textView=findViewById(R.id.descrip6);
        String d="The busy Old City, on the Lake Pichola shore, is home to narrow alleys with traditional haveli houses, craft shops, backpacker hostels, and rooftop eateries in the Lal Ghat area. Upscale restaurants with views dot the lakeside, and City Palace is a waterfront complex of ornate palaces with a museum and the intricately carved, 17th-century Jagdish Temple. Rajasthani fabrics and crafts fill buzzing Hathipole Bazaar";
        textView.setText(d);
    }
}