package com.example.pedla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Payment extends AppCompatActivity {
    private Button btn;
    String getcycle, getcycleamounnt, getstorename, getaccessories;
    String time1,time2,date1,date2;
    String amountaccessory,totalpayment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        getcycle=(getIntent().getStringExtra("cyclename"));
        getcycleamounnt=(getIntent().getStringExtra("cycleamount"));
        getstorename=(getIntent().getStringExtra("storename"));
        getaccessories=(getIntent().getStringExtra("accessories"));
        time1=(getIntent().getStringExtra("timeone"));
        time2=(getIntent().getStringExtra("timetwo"));
        date1=(getIntent().getStringExtra("dateone"));
        date2=(getIntent().getStringExtra("datetwo"));
        amountaccessory=(getIntent().getStringExtra("accessoriesamount"));
        totalpayment=(getIntent().getStringExtra("totalpayment"));



        btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToBookSuccessfull();
            }
        });
    }
    public void moveToBookSuccessfull(){
        Intent intent=new Intent (Payment.this,BookingSuccessfull.class);

        intent.putExtra("cyclename",getcycle);
        intent.putExtra("cycleamount",getcycleamounnt);
        intent.putExtra("storename",getstorename);
        intent.putExtra("timeone",time1);
        intent.putExtra("timetwo",time2);
        intent.putExtra("dateone",date1);
        intent.putExtra("datetwo",date2);
        intent.putExtra("accessoriesamount",amountaccessory);
        intent.putExtra("totalpayment",totalpayment);
        intent.putExtra("accessories",getaccessories);



        startActivity(intent);
        finish();
    }
}