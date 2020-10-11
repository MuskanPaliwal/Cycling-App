package com.example.pedla;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

public class HS extends AppCompatActivity {
    private Button btnbacktologin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.nav_activity_h_s);


        btnbacktologin=findViewById(R.id.btn5);
        btnbacktologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                backToSignInpage();
            }
        });

        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            public boolean onNavigationItemSelected(MenuItem item){
                if(item.getItemId()==R.id.nav_home){
                    Intent intent=new Intent(HS.this,SideBar.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.nav_settings){
                    Intent intent=new Intent(HS.this,HS.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.nav_aboutus){

                }
                DrawerLayout drawerLayout=findViewById(R.id.drawer_layout);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;

            }
        });

    }

    private void backToSignInpage(){
        Intent intent=new Intent (HS.this,Login.class);
        startActivity(intent);
        finish();
    }



}