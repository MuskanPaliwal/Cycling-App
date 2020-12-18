package com.example.pedla;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pedla.ui.home.HomeFragment;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Cycles extends AppCompatActivity implements myadapterone.OnItemClicked{
    RecyclerView recviewone;
    myadapterone adapter;
    String storename,storeid;
    String time1,time2,date1,date2;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cycles);
        storename = (getIntent().getStringExtra("title"));
        storeid = (getIntent().getStringExtra("ID"));

        time1=(getIntent().getStringExtra("timeone"));
        time2=(getIntent().getStringExtra("timetwo"));
        date1=(getIntent().getStringExtra("dateone"));
        date2=(getIntent().getStringExtra("datetwo"));
        back=findViewById(R.id.backbuttoncycles);

        recviewone=findViewById(R.id.recviewcycle);
        recviewone.setLayoutManager(new LinearLayoutManager(this));

        FirestoreRecyclerOptions<modelone> options=
                new FirestoreRecyclerOptions.Builder<modelone>()
                        .setQuery(FirebaseFirestore.getInstance().collection("Stores").document(storeid).collection("Cycles"),modelone.class)
                        .build();

        adapter=new myadapterone(options,this);
        recviewone.setAdapter(adapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Cycles.this, Stores.class);
                startActivity(intent);
                finish();
            }
        });
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

    @Override
    public void onItemGetClick(int position, DocumentSnapshot documentSnapshot) {
        modelone m=documentSnapshot.toObject(modelone.class);
        String s=m.getCycle_Name();
        String j=m.getAmount();
        String cycleid=documentSnapshot.getId();
        String cyclepicurl=m.getCycle_Image();

        if(timedateselected()) {
            Toast.makeText(Cycles.this, s , Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Cycles.this, Accessories.class);
            intent.putExtra("title", s);
            intent.putExtra("amount", j);
            intent.putExtra("Storename", storename);
            intent.putExtra("timeone", time1);
            intent.putExtra("timetwo", time2);
            intent.putExtra("dateone", date1);
            intent.putExtra("datetwo", date2);
            intent.putExtra("cycleimage", cyclepicurl);
            intent.putExtra("CYLEID", cycleid);
            intent.putExtra("STOREID", storeid);


            startActivity(intent);
            finish();
        }

        else{
            AlertDialog();
        }
    }

    public  boolean timedateselected(){


        if(time1.length()==0 || time2.length()==0 || date1.length()==0 || date2.length()==0){
            return false;
        }

        return true;
    }

    private void AlertDialog()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Cycles.this,R.style.AlertDialogue);
        alertDialogBuilder.setMessage("Please Select Date and Time on Home Screen for booking and in correct format").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                dialog.cancel();
            }
        });

        AlertDialog alert = alertDialogBuilder.create();
        alert.show();

    }
}