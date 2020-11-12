package com.example.pedla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OrderReview extends AppCompatActivity {
    private Button btnToPayAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_review);
        btnToPayAmount=findViewById(R.id.buttonPay);
        btnToPayAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToPaymentPage();
            }
        });
    }
    private void goToPaymentPage(){
        Intent intent=new Intent (OrderReview.this,HS.class);
        startActivity(intent);
        finish();
    }
}