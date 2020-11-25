package com.example.pedla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BookingSuccessfull extends AppCompatActivity {
    private Button btn6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_successfull);
        btn6=findViewById(R.id.buttonPay);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToHome();
            }
        });
    }
    public void moveToHome(){
        Intent intent=new Intent (BookingSuccessfull.this,SideBar.class);
        startActivity(intent);
        finish();
    }
}