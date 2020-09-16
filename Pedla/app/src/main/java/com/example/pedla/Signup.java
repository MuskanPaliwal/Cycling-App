package com.example.pedla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class Signup extends AppCompatActivity {
    private Button btnmovetologin;
    private Button btnmovetoCHOICE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup);

        btnmovetologin=findViewById(R.id.btn3);
        btnmovetologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moveToSignInpage();
            }
        });

        btnmovetoCHOICE=findViewById(R.id.btn4);
        btnmovetoCHOICE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moveTohomescreen();
            }
        });
    }

    private void moveToSignInpage(){
        Intent intent=new Intent (Signup.this,Login.class);
        startActivity(intent);
        finish();
    }

    private void moveTohomescreen(){
        Intent intent=new Intent (Signup.this,HS.class);
        startActivity(intent);
        finish();
    }
}