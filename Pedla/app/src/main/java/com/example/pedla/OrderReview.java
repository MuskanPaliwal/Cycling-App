package com.example.pedla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OrderReview extends AppCompatActivity {
    private Button btnToPayAmount;
    TextView t1,t2,t3,t4,t5;
    TextView t6,t7;
    String getcycle, getcycleamounnt, getstorename, getaccessories;
    String time1,time2,date1,date2;
    int acctotalamount;
    int totalamount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_review);

        t1=(TextView) findViewById(R.id.cycle);
        t2=findViewById(R.id.cycleamount);
        t3=findViewById(R.id.accessoryname);
        t4=findViewById(R.id.amountaccessories);
        t5=findViewById(R.id.totalPay);
        t6=findViewById(R.id.startdate);
        t7=findViewById(R.id.timings);

        getcycle=getIntent().getStringExtra("cyclename");
        getcycleamounnt=getIntent().getStringExtra("cycleamount");
        getstorename=getIntent().getStringExtra("storename");
        getaccessories=getIntent().getStringExtra("accessories");
        String []accessories=getaccessories.split(" ");
        int acclength=accessories.length;

        acctotalamount=acclength*50;

        totalamount=acctotalamount+(Integer.parseInt(getcycleamounnt));

        time1=(getIntent().getStringExtra("timeone"));
        time2=(getIntent().getStringExtra("timetwo"));
        date1=(getIntent().getStringExtra("dateone"));
        date2=(getIntent().getStringExtra("datetwo"));


        t1.setText(getcycle);
        t2.setText("Amount per hour: "+getcycleamounnt);
        t3.setText(getaccessories);
        t4.setText("Amount of accessories: "+ acctotalamount);
        t5.setText("Total Pay: "+ totalamount);
        t6.setText("Your Booking starts from "+date1+" to "+date2);
        t7.setText("Timings are: "+time1+" to "+time2);



        btnToPayAmount=findViewById(R.id.buttonPay);
        btnToPayAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToPaymentPage();
            }
        });
    }
    private void goToPaymentPage(){
        Intent intent=new Intent (OrderReview.this,Payment.class);
        intent.putExtra("timeone",time1);
        intent.putExtra("timetwo",time2);
        intent.putExtra("dateone",date1);
        intent.putExtra("datetwo",date2);
        intent.putExtra("cyclename",getcycle);
        intent.putExtra("cycleamount",getcycleamounnt);
        intent.putExtra("storename",getstorename);
        intent.putExtra("accessories",getaccessories);
        intent.putExtra("accessoriesamount",Integer.toString(acctotalamount));
        intent.putExtra("totalpayment",Integer.toString(totalamount));


        startActivity(intent);
        finish();
    }
}