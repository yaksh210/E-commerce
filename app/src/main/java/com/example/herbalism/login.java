package com.example.herbalism;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {


    EditText e1,e2;
    Button b1,b2;
    TextView t1;
    FirebaseAuth sAuth;
    FirebaseUser sUser;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        e1=findViewById(R.id.log_mail);
        e2=findViewById(R.id.log_pass);
        b1=findViewById(R.id.btn_log);
        b2=findViewById(R.id.button);
        t1=findViewById(R.id.for_pass);

        progressDialog=new ProgressDialog(this);
        sAuth=FirebaseAuth.getInstance();
        sUser=sAuth.getCurrentUser();




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String Email=e1.getText().toString().trim();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                final String Password=e2.getText().toString().trim();

                if(TextUtils.isEmpty(Email))
                {
                    e1.setError("Please enter E-Mail");
                    Toast.makeText(login.this,"enter proper email",Toast.LENGTH_SHORT).show();
                    return;
                }

                else if(!Email.matches(emailPattern))
                {
                    e1.setError("invalid email");
                    Toast.makeText(login.this,"enter proper email",Toast.LENGTH_SHORT).show();

                }

                else if(TextUtils.isEmpty(Password))
                {
                    e2.setError("Please enter Password");
                    Toast.makeText(login.this,"enter password",Toast.LENGTH_SHORT).show();

                    return;
                }
                else if(Password.length() < 6)
                {
                    e2.setError("password must be > 6 characters");
                    Toast.makeText(login.this,"enter proper password",Toast.LENGTH_SHORT).show();

                    return;
                }
                else
                {
                    progressDialog.setMessage("waiting for Login...");
                    progressDialog.setTitle("Login");
                    progressDialog.setCanceledOnTouchOutside(false);
                    progressDialog.show();

                sAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful())
                        {
                            progressDialog.dismiss();
                            sendUserToNext();
                            Toast.makeText(login.this,"Login Successfully",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {

                            progressDialog.dismiss();
                            Toast.makeText(login.this,""+task.getException(),Toast.LENGTH_SHORT).show();

                        }
                    }

                    private void sendUserToNext()
                    {
                        Intent intent=new Intent(login.this,home_screen.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);

                    }
                });


                }

//                if (Email.equals("yaksh@gmail.com") && Password.equals("user123")) {
//                    Toast.makeText(login.this, "login Successfully", Toast.LENGTH_SHORT).show();
//
//                    Intent i=new Intent(login.this,home_screen.class);
//                    startActivity(i);
//                }

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(login.this,signup.class);
                startActivity(i);
            }
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(login.this,forget_pass.class);
                startActivity(i);

            }
        });


    }
}