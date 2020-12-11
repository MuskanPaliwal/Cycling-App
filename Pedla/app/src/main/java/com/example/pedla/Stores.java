package com.example.pedla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Stores extends AppCompatActivity implements myadapter.OnListItemClicked {


    RecyclerView recview;
    myadapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        Intent intent=new Intent(Stores.this,Trynna.class);
        intent.putExtra("title",s);
        startActivity(intent);
    }
}