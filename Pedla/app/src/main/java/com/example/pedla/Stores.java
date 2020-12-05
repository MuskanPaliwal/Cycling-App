package com.example.pedla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Stores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stores);
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyStoreData[] myStoreData=new MyStoreData[]{
          new MyStoreData("Sharada Cycle Store","Available Cycles 12","Distance From You: 2 km",R.drawable.csone),
                new MyStoreData("Punjab Cycle Store","Available Cycles 10","Distance From You: 1 km",R.drawable.cstwo),
                new MyStoreData("Rex Cycle Store","Available Cycles 20","Distance From You: 2 km",R.drawable.csthree),
                new MyStoreData("Pooja Cycle Store","Available Cycles 12","Distance From You: 2.5 km",R.drawable.csfour),
                new MyStoreData("Paragon Cycle Store","Available Cycles 15","Distance From You: 1.5 km",R.drawable.csfive),
                new MyStoreData("Honda Cycle Store","Available Cycles 30","Distance From You: 1 km",R.drawable.cssix),
                new MyStoreData("Faiz Cycle Store","Available Cycles 7","Distance From You: 0.6 km",R.drawable.csseven),
                new MyStoreData("Choudhary Cycle Store","Available Cycles 25","Distance From You: 0.8 km",R.drawable.cseight),


        };

        MyStoreAdapter myStoreAdapter=new MyStoreAdapter(myStoreData,Stores.this);
        recyclerView.setAdapter(myStoreAdapter);

    }
}