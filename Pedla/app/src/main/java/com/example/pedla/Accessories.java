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

    String getstorename,getcyclename, getcycleamount;
    ArrayList<String> selectedItems;
    String time1,time2,date1,date2;
    String cycleimageurl, cycleid,storeid;


    ListView listView;
    String[] festivals = {
            "Helmet",
            "Puncture-Repair-Kit.",
            "Cycling-Shorts",
            "Bike-Lock",
            "Water-Bottle",
            "Pollution-Mask"
    };
    private Button btntoReviewOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accessories);
        btntoReviewOrder=findViewById(R.id.button);

        getstorename = (getIntent().getStringExtra("Storename"));
        getcyclename=(getIntent().getStringExtra("title"));
        getcycleamount=(getIntent().getStringExtra("amount"));
        time1=(getIntent().getStringExtra("timeone"));
        time2=(getIntent().getStringExtra("timetwo"));
        date1=(getIntent().getStringExtra("dateone"));
        date2=(getIntent().getStringExtra("datetwo"));
        cycleimageurl=(getIntent().getStringExtra("cycleimage"));
        cycleid=(getIntent().getStringExtra("CYCLEID"));
        storeid=(getIntent().getStringExtra("STOREID"));


        selectedItems=new ArrayList<String>();

        btntoReviewOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToReviewOrder(v);
            }
        });

        listView = (ListView)findViewById(R.id.checkable_list);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.txt_lan, festivals);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                String selectedItem=((TextView)view).getText().toString();

                if(selectedItems.contains(selectedItem)){
                    selectedItems.remove(selectedItem);
                }
                else{
                    selectedItems.add(selectedItem);
                }

                /*// appending Happy with festival name
                String value = "You have selected " + adapter.getItem(position);
                // Display the Toast
                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();*/
            }
        });
    }


    private void goToReviewOrder(View view){
        String selItems="";
        for(String item:selectedItems){
            if(selItems== ""){
                selItems=item;
            }
            else{
                selItems=selItems+" "+item;
            }
        }
        Toast.makeText(this,selItems,Toast.LENGTH_LONG).show();

        Intent intent=new Intent (Accessories.this,OrderReview.class);
        intent.putExtra("cyclename",getcyclename);
        intent.putExtra("storename",getstorename);
        intent.putExtra("cycleamount",getcycleamount);
        intent.putExtra("accessories",selItems);
        intent.putExtra("timeone",time1);
        intent.putExtra("timetwo",time2);
        intent.putExtra("dateone",date1);
        intent.putExtra("datetwo",date2);
        intent.putExtra("cycleimage",cycleimageurl);
        intent.putExtra("CYCLEID",cycleid);
        intent.putExtra("STOREID",storeid);

        startActivity(intent);
        finish();
    }
}