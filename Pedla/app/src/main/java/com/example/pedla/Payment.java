package com.example.pedla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Payment extends AppCompatActivity {
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToBookSuccessfull();
            }
        });
    }
    public void moveToBookSuccessfull(){
        Intent intent=new Intent (Payment.this,BookSuccessfull.class);
        startActivity(intent);
        finish();
    }
}