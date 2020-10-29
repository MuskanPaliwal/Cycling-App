package com.example.pedla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Accessories extends AppCompatActivity {
    ListView listView;
    TextView textView;
    String[] festivals = {
            "Helmet",
            "Puncture Repair Kit.",
            "Cycling Shorts",
            "Bike Lock",
            "Water Bottle",
            "Pollution Mask"
    };
    private Button btntoReviewOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accessories);
        btntoReviewOrder=findViewById(R.id.button);
        btntoReviewOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToReviewOrder();
            }
        });

        listView = (ListView)findViewById(R.id.list);
        textView = (TextView)findViewById(R.id.textView);
        final ArrayAdapter adapter = new ArrayAdapter(this,
                R.layout.list_item, R.id.textView, festivals);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub

                /* appending Happy with festival name */
                String value = "You have selected " + adapter.getItem(position);
                /* Display the Toast */
                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void goToReviewOrder(){
        Intent intent=new Intent (Accessories.this,OrderReview.class);
        startActivity(intent);
        finish();
    }
}