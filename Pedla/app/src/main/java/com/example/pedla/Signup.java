package com.example.pedla;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class Signup extends AppCompatActivity {
    public static final String TAG = "TAG";
    private Button btnmovetologin;
    private Button btnmovetoCHOICE;
    private EditText Name, Email, Password, Phone,ConfirmPass;
    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    String userId;

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
        fstore = FirebaseFirestore.getInstance();

        if(fAuth.getCurrentUser() != null) {
            Intent intent=new Intent (Signup.this,SideBar.class);
            startActivity(intent);
            finish();
        }
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
                final String email = Email.getText().toString().trim();
                String password = Password.getText().toString().trim();
                final String phoneNumber = Phone.getText().toString().trim();
                final String name = Name.getText().toString().trim();
//                final SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
                if (moveTohomescreen()) {
                    //Signup user in Firebase
                    fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(Signup.this, "Account Created", Toast.LENGTH_SHORT).show();
                                userId = fAuth.getCurrentUser().getUid();
                                DocumentReference documentReference = fstore.collection("Users").document(userId);
                                Map<String, Object> user = new HashMap<>();
                                user.put("Name", name);
                                user.put("Email", email);
                                user.put("PhoneNumber", phoneNumber);
//                                user.put("CreatedAt", formatter);
                                documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Log.d(TAG, "onSuccess: User profile is created for " + userId);
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.d(TAG, "onFailure: " + e.toString());
                                    }
                                });
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
        String name = Name.getText().toString().trim();
        String confirmPass = ConfirmPass.getText().toString().trim();

        if (name.length() > 25) {

            Toast.makeText(getApplicationContext(), "Please enter less than 25 character in user name", Toast.LENGTH_SHORT).show();
            return false;

        }
        if (name.length() == 0 || phoneNumber.length() == 0 || email.length() ==
                0 || password.length() == 0 ||confirmPass.length()==0) {

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
        if(!password.equals(confirmPass)){
            Toast.makeText(getApplicationContext(), "Password not matching", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password.length() < 6) {
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