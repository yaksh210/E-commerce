package com.example.herbalism;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.Firebase;


public class Feedback extends AppCompatActivity {

    private Firebase ref;
    private EditText username,form;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        username=findViewById(R.id.feed_user);
        form=findViewById(R.id.feedback);
        Firebase.setAndroidContext(this);
        ref=new Firebase("https://herbalism-4df0e-default-rtdb.firebaseio.com/");



    }


    public void feedbacksent(View view)
    {
        String usernameinput=username.getText().toString();
        String feedbackinput=form.getText().toString();
        Firebase resuername=ref.child("username");
        resuername.setValue(usernameinput);
        Firebase refeedback=ref.child("Feedback");
        refeedback.setValue(feedbackinput);

    }
}