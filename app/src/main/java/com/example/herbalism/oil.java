package com.example.herbalism;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class oil extends AppCompatActivity {

    RecyclerView my_rec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oil);
        Data_Model[] my_data=new Data_Model[]{
                new Data_Model("Navratna","Good Hair Growth.\n",R.drawable.ay_oil_one),
                new Data_Model("Kama Ayurveda","Body Massage oil.\n",R.drawable.ay_oil_two),
                new Data_Model("Fortune oil","Ayurveda Cooking oil.\n",R.drawable.ay_oil_three),

        };

        my_rec=findViewById(R.id.recycle_oil);
        Data_Adapter data_adapter=new Data_Adapter(my_data);

        my_rec.setLayoutManager(new LinearLayoutManager(this));
        my_rec.setAdapter(data_adapter);

    };
}