package com.example.pedla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class Choice extends AppCompatActivity {
    private CardView ridercard,merchantcard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_choice);
        ridercard=(CardView) findViewById(R.id.card1);
        merchantcard=(CardView) findViewById(R.id.card2);

        ridercard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (Choice.this,Signup.class);
                startActivity(intent);
                finish();
            }
        });

        merchantcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (Choice.this,Signup.class);
                startActivity(intent);
                finish();
            }
        });
    }
}