package com.example.pedla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BookingSuccessfull extends AppCompatActivity {
    private Button btn6;
    String getcycle, getcycleamounnt, getstorename, getaccessories;
    String time1,time2,date1,date2;
    String amountaccessory,totalpayment;

    TextView t1,t2,t3,t4,t5,t6,t7,t8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_successfull);

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


        t1=findViewById(R.id.store);
        t2=findViewById(R.id.startdate1);
        t3=findViewById(R.id.timings1);
        t4=findViewById(R.id.cycle1);
        t5=findViewById(R.id.cycleamount1);
        t6=findViewById(R.id.accessoriesname1);
        t7=findViewById(R.id.amountaccessories1);
        t8=findViewById(R.id.totalPay1);


        t1.setText(getstorename);
        t2.setText("Your Booking starts from "+date1+" to "+date2);
        t3.setText("Timings are: "+time1+" to "+time2);
        t4.setText(getcycle);
        t5.setText("Amount paid per hour: "+getcycleamounnt);
        t6.setText(getaccessories);
        t7.setText("Amount paid for accessories: "+amountaccessory);
        t8.setText("Total amount paid: "+totalpayment);




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