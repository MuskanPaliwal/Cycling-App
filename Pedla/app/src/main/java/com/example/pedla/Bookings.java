package com.example.pedla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class Bookings extends AppCompatActivity {

    RecyclerView recviewbooking;
    bookingadapter adapter;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String Userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings);


        fAuth=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();
        Userid=fAuth.getCurrentUser().getUid();

        recviewbooking=findViewById(R.id.recviewbookings);
        recviewbooking.setLayoutManager(new LinearLayoutManager(this));

        FirestoreRecyclerOptions<bookingmodel> options=
                new FirestoreRecyclerOptions.Builder<bookingmodel>()
                        .setQuery(FirebaseFirestore.getInstance().collection("Users").document(Userid).collection("Bookings").orderBy("Date", Query.Direction.DESCENDING),bookingmodel.class)
                        .build();

        adapter=new bookingadapter(options);
        recviewbooking.setAdapter(adapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}