package com.example.pedla;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class HS extends AppCompatActivity {
    private Button btnbacktologin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_h_s);


        btnbacktologin=findViewById(R.id.btn5);
        btnbacktologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                backToSignInpage();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.setp:
                Intent i = new Intent(HS.this, Preference.class);
                startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
    private void backToSignInpage(){
        Intent intent=new Intent (HS.this,Login.class);
        startActivity(intent);
        finish();
    }

}