package com.example.herbalism;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class book extends AppCompatActivity {

    RecyclerView my_rec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        Data_Model[] my_data=new Data_Model[]{
                new Data_Model("Best Skin care","Ayurveda skin-care.\n",R.drawable.ay_book_one),
                new Data_Model("Ayurveda health","Ayurveda health.",R.drawable.ay_book_two),
                new Data_Model("Marma Points","Meditation Book.\n",R.drawable.ay_book_three),

        };


        my_rec=findViewById(R.id.rec_book);
        Data_Adapter data_adapter=new Data_Adapter(my_data);

        my_rec.setLayoutManager(new LinearLayoutManager(this));
        my_rec.setAdapter(data_adapter);

    };
}