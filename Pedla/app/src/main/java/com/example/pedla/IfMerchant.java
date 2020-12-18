package com.example.pedla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IfMerchant extends AppCompatActivity {

    Button backtoch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_if_merchant);
        backtoch=findViewById(R.id.backtochoice);
        backtoch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(IfMerchant.this,Choice.class);
                startActivity(i);
                finish();
            }
        });
    }
}