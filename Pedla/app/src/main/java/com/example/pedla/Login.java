package com.example.pedla;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.WindowManager;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {
    private Button btnmove;
    private Button btnmoveagain;
    private EditText Name,Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        Name=(EditText)findViewById(R.id.editTextTextPersonName);
        Password=(EditText)findViewById(R.id.editTextTextPassword);

        btnmove=findViewById(R.id.btn2);
        btnmove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moveToSignUppage();
            }
        });

        btnmoveagain=findViewById(R.id.btn1);
        btnmoveagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (moveToHomeScreen()) {
                    Intent intent=new Intent (Login.this,SideBar.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    AlertDialog();
                }
            }
        });
    }

    private void moveToSignUppage(){
        Intent intent=new Intent (Login.this,Choice.class);
        startActivity(intent);
        finish();
    }
    private boolean moveToHomeScreen(){
        if (Name.length() > 25) {
            Toast.makeText(getApplicationContext(), "Please enter less than 25 character in user name", Toast.LENGTH_SHORT).show();
            return false;

        } else if (Name.length() == 0 ||  Password.length() == 0 ) {
            Toast.makeText(getApplicationContext(), "Please fill the empty fields", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (Password.length() < 6) {
            Toast.makeText(getApplicationContext(), "Please enter more than 6 characters in password", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    private void AlertDialog()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Login.this);
        alertDialogBuilder.setMessage("Please Ensure all the fields are correct").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener()
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