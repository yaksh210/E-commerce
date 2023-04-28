package com.example.herbalism;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class med extends AppCompatActivity {

    RecyclerView my_rec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med);

        Data_Model[] my_data=new Data_Model[]{
                new Data_Model("Trifala","Protact against cancer.\n",R.drawable.ay_med_one),
                new Data_Model("Honey","anti-inflammatory, antioxidant and antibacterial agent.\n",R.drawable.ay_med_two),
                new Data_Model("Turmeric","Surya Namaskar pose.\n",R.drawable.ay_med_three),
                new Data_Model("Tulsi","neutralizing free radicals and shielding the cells from damage.\n",R.drawable.ay_med_four),
                new Data_Model("Ashwgandha","May reduce blood sugar levels.\n",R.drawable.ay_med_five),

        };

        my_rec=findViewById(R.id.recycle_med);
        Data_Adapter data_adapter=new Data_Adapter(my_data);

        my_rec.setLayoutManager(new LinearLayoutManager(this));
        my_rec.setAdapter(data_adapter);

    };
}