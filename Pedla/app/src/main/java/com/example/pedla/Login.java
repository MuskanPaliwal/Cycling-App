package com.example.pedla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {
    private Button btnmove;
    private Button btnmoveagain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        btnmove=findViewById(R.id.btn2);
        btnmove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moveToSignUppage();
            }
        });

        btnmoveagain=findViewById(R.id.btn1);
        btnmoveagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moveToHomeScreen();
            }
        });
    }

    private void moveToSignUppage(){
        Intent intent=new Intent (Login.this,Choice.class);
        startActivity(intent);
        finish();
    }
    private void moveToHomeScreen(){
        Intent intent=new Intent (Login.this,HS.class);
        startActivity(intent);
        finish();
    }

}