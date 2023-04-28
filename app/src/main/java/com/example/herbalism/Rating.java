package com.example.herbalism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class Rating extends AppCompatActivity {

    RatingBar ratingBar;
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        ratingBar=findViewById(R.id.rate_bar);
        b1=findViewById(R.id.btn_rate);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data=String.valueOf(ratingBar.getRating());
                Toast.makeText(getApplicationContext(),data+"star thanks",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Rating.this,home_screen.class);
                startActivity(intent);
                finish();
            }
        });

    }
}