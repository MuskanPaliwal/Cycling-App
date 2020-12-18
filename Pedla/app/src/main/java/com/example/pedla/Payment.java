package com.example.pedla;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Payment extends AppCompatActivity {
    private static final String TAG = "TAG";
    private Button btn;
    String getcycle, getcycleamounnt, getstorename, getaccessories;
    String time1,time2,date1,date2;
    String amountaccessory,totalpayment;
    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    String userId;
    String cycleimageurl, cycleid,storeid;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        fAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        userId = fAuth.getCurrentUser().getUid();

        getcycle=(getIntent().getStringExtra("" + "cyclename"));
        getcycleamounnt=(getIntent().getStringExtra("cycleamount"));
        getstorename=(getIntent().getStringExtra("storename"));
        getaccessories=(getIntent().getStringExtra("accessories"));
        time1=(getIntent().getStringExtra("timeone"));
        time2=(getIntent().getStringExtra("timetwo"));
        date1=(getIntent().getStringExtra("dateone"));
        date2=(getIntent().getStringExtra("datetwo"));
        amountaccessory=(getIntent().getStringExtra("accessoriesamount"));
        totalpayment=(getIntent().getStringExtra("totalpayment"));

        cycleid=(getIntent().getStringExtra("CYCLEID"));
        storeid=(getIntent().getStringExtra("STOREID"));
        cycleimageurl=(getIntent().getStringExtra("cycleimage"));



        btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToBookSuccessfull();
            }
        });

    }
    public void moveToBookSuccessfull(){
        Map<String, Object> Booking = new HashMap<>();
        Booking.put("Cycle", getcycle);
        Booking.put("Accessory", getaccessories);
        Booking.put("Amount", totalpayment);
        Booking.put("Date", date1);
        Booking.put("Time", time1);
        Booking.put("End_Time",time2);
        Booking.put("Store", getstorename);
        Booking.put("Cycle_Image",cycleimageurl);

        CollectionReference collectionReference = fstore.collection("Users").document(userId).collection("Bookings");
        collectionReference.add(Booking).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.d(TAG, "onSuccess: Booking is created for " + userId);
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
                intent.putExtra("STOREID",storeid);
                intent.putExtra("CYCLEID",cycleid);
                intent.putExtra("cycleimage",cycleimageurl);

                startActivity(intent);
                finish();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, "onFailure: " + e.toString());
            }
        });

    }
}