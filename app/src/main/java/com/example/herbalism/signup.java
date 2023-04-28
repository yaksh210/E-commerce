package com.example.herbalism;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class signup extends AppCompatActivity {

    EditText ef,el,em,ep;
    Button bs;
    FirebaseAuth sAuth;
    FirebaseUser sUser;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ef=findViewById(R.id.f_name);
        el=findViewById(R.id.l_name);
        em=findViewById(R.id.sig_email);
        ep=findViewById(R.id.sig_pass);
        bs=findViewById(R.id.btn_sig);

        progressDialog=new ProgressDialog(this);
        sAuth=FirebaseAuth.getInstance();
        sUser=sAuth.getCurrentUser();


        bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fname=ef.getText().toString();
                String lname=el.getText().toString();
                String Email=em.getText().toString().trim();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                String Password=ep.getText().toString().trim();


                if(TextUtils.isEmpty(fname))
                {
                    ef.setError("please enter firstname");
                    Toast.makeText(signup.this,"enter proper name",Toast.LENGTH_SHORT).show();
                }
                else if(!fname.matches("[a-zA-Z ]+"))
                {
                    ef.setError("ENTER ONLY ALPHABETICAL CHARACTER");
                    Toast.makeText(signup.this,"enter proper name",Toast.LENGTH_SHORT).show();
                    return;
                }

                else if(TextUtils.isEmpty(lname))
                {
                    el.setError("please enter lastname");
                    Toast.makeText(signup.this,"enter proper Lastname",Toast.LENGTH_SHORT).show();
                }
                else if(!lname.matches("[a-zA-Z ]+"))
                {
                    el.setError("ENTER ONLY ALPHABETICAL CHARACTER");
                    Toast.makeText(signup.this,"enter proper lastname",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(TextUtils.isEmpty(Email))
                {
                    em.setError("please enter email");
                    Toast.makeText(signup.this,"enter proper email",Toast.LENGTH_SHORT).show();
                }

                else if(!Email.matches(emailPattern))
                {
                    em.setError("invalid email");
                    Toast.makeText(signup.this,"check mail format",Toast.LENGTH_SHORT).show();
                }

                else if(TextUtils.isEmpty(Password))
                {
                    ep.setError("Please enter Password");
                    Toast.makeText(signup.this,"enter password",Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {
                    progressDialog.setMessage("waiting for Registration...");
                    progressDialog.setTitle("Register");
                    progressDialog.setCanceledOnTouchOutside(false);
                    progressDialog.show();

                    sAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                progressDialog.dismiss();
                                sendUserToNext();
                                Toast.makeText(signup.this,"Register successfuly",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                progressDialog.dismiss();
                                Toast.makeText(signup.this,""+task.getException(),Toast.LENGTH_SHORT).show();
                            }
                        }

                        private void sendUserToNext() {

                            Intent intent=new Intent(signup.this,home_screen.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

                        }
                    });

                }



            }
        });


    }

}