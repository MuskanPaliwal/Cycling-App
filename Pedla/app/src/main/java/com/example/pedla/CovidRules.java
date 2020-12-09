package com.example.pedla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CovidRules extends AppCompatActivity {
Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_rules);
        btn=findViewById(R.id.bt);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movetohome();
            }
        });



    }

    public void movetohome(){
        Intent intent=new Intent(CovidRules.this,SideBar.class);
        startActivity(intent);
    }
}