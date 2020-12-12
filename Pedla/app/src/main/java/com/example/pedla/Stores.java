package com.example.pedla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Stores extends AppCompatActivity implements myadapter.OnListItemClicked {
    RecyclerView recview;
    myadapter adapter;
    String time1,time2,date1,date2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        time1=(getIntent().getStringExtra("timeone"));
        time2=(getIntent().getStringExtra("timetwo"));
        date1=(getIntent().getStringExtra("dateone"));
        date2=(getIntent().getStringExtra("datetwo"));

        setContentView(R.layout.activity_stores);
        recview=findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        FirestoreRecyclerOptions<model> options=
                new FirestoreRecyclerOptions.Builder<model>()
                .setQuery(FirebaseFirestore.getInstance().collection("Stores"),model.class)
                .build();

        adapter=new myadapter(options,this);
        recview.setAdapter(adapter);

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
    public void onItemClick(int position, DocumentSnapshot documentSnapshot) {
        model m=documentSnapshot.toObject(model.class);
        String s=m.getName();
        String id=documentSnapshot.getId();
        Toast.makeText(Stores.this, s , Toast.LENGTH_SHORT).show();

        Intent intent=new Intent(Stores.this,Cycles.class);
        intent.putExtra("title",s);
        intent.putExtra("ID",id);
        intent.putExtra("timeone",time1);
        intent.putExtra("timetwo",time2);
        intent.putExtra("dateone",date1);
        intent.putExtra("datetwo",date2);


        startActivity(intent);
        finish();
    }
}