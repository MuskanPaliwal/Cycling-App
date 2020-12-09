package com.example.pedla;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {
    private Button btnmovetologin;
    private Button btnmovetoCHOICE;
    private EditText Name, Email, Password, Phone,ConfirmPass;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup);

        Name=(EditText)findViewById(R.id.editTextTextPerson);
        Email=(EditText)findViewById(R.id.editTextTextEmail);
        Password=(EditText)findViewById(R.id.editTextTextPassword);
        Phone=(EditText)findViewById(R.id.editTextTextPersonName);
        ConfirmPass=(EditText)findViewById(R.id.editTextTextPasswordType) ;
        fAuth = FirebaseAuth.getInstance();


        btnmovetologin=findViewById(R.id.btn3);
        btnmovetologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moveToSignInpage();
            }
        });

        btnmovetoCHOICE=findViewById(R.id.btn4);
        btnmovetoCHOICE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email.getText().toString().trim();
                String password = Password.getText().toString().trim();
                if (moveTohomescreen()) {
                    //Signup user in Firebase
                    fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(Signup.this, "Account Created", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent (Signup.this,SideBar.class);
                                startActivity(intent);
                                finish();
                            } else{
                                Toast.makeText(Signup.this, "Error!" + task.getException(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else{
                    AlertDialog();
                }
            }
        });


    }

    private void moveToSignInpage(){
        Intent intent=new Intent (Signup.this,Login.class);
        startActivity(intent);
        finish();
    }

    private boolean moveTohomescreen()
    {
        String MobilePattern = "[0-9]{10}";
        //String email1 = email.getText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String email = Email.getText().toString().trim();
        String password = Password.getText().toString().trim();
        String phoneNumber = Phone.getText().toString().trim();

        if (Name.length() > 25) {

            Toast.makeText(getApplicationContext(), "Please enter less than 25 character in user name", Toast.LENGTH_SHORT).show();
            return false;

        }
        if (Name.length() == 0 || Phone.length() == 0 || Email.length() ==
                0 || Password.length() == 0 ||ConfirmPass.length()==0) {

            Toast.makeText(getApplicationContext(), "Please fill the empty fields", Toast.LENGTH_SHORT).show();
            return false;

        }
        if(!email.matches(emailPattern)) {

            Toast.makeText(getApplicationContext(),"Please Enter Valid Email Address",Toast.LENGTH_SHORT).show();
            return false;

        }
        if(!phoneNumber.matches(MobilePattern)) {

            Toast.makeText(getApplicationContext(), "Phone number is invalid", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(!password.equals(ConfirmPass.getText().toString())){
            Toast.makeText(getApplicationContext(), "Password not matching", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (Password.length() < 6) {
            Toast.makeText(getApplicationContext(), "Please enter more than 6 characters in password", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    private void AlertDialog()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Signup.this,R.style.AlertDialogue);
        alertDialogBuilder.setMessage("Please ensure All The Fields Are Correct").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener()
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