package com.example.pedla;

import androidx.annotation.NonNull;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private Button btnmove;
    private Button btnmoveagain;
    private EditText Email,Password;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fAuth = FirebaseAuth.getInstance();

        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(Login.this, SideBar.class));
            finish();
        }
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        Email=(EditText)findViewById(R.id.editTextTextPersonName);
        Password=(EditText)findViewById(R.id.editTextTextPassword);
        fAuth = FirebaseAuth.getInstance();

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
                String email = Email.getText().toString().trim();
                String password = Password.getText().toString().trim();

                if (moveToHomeScreen()) {
                    //Authenticate user
                    fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(Login.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent (Login.this,SideBar.class);
                                startActivity(intent);
                                finish();
                            } else{
                                Toast.makeText(Login.this, "Error!" + task.getException(), Toast.LENGTH_SHORT).show();
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

    private void moveToSignUppage(){
        Intent intent=new Intent (Login.this,Choice.class);
        startActivity(intent);
        finish();
    }
    private boolean moveToHomeScreen(){
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String email = Email.getText().toString().trim();
        String password = Password.getText().toString().trim();
        if (password.length() < 6) {
            Toast.makeText(getApplicationContext(), "Please enter more than 6 characters in password", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(!email.matches(emailPattern)) {
            Toast.makeText(getApplicationContext(),"Please Enter Valid Email Address",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    private void AlertDialog()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Login.this,R.style.AlertDialogue);
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