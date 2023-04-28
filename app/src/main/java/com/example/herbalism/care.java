package com.example.herbalism;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class care extends AppCompatActivity {

    RecyclerView my_rec;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care);

        Data_Model[] my_data=new Data_Model[]{
                new Data_Model("Swastikasn","used in meditation.\n",R.drawable.yo_pose_one),
                new Data_Model("Parvatasn","mountain pose to give peace.\n",R.drawable.yo_pose_two),
                new Data_Model("Namskaarasn","Surya Namaskar pose.\n",R.drawable.yo_pose_three),
                new Data_Model("Trikonasana","To Reduce belly fat.\n",R.drawable.yo_pose_four),
                new Data_Model("Balasana","Better for Digesting.\n",R.drawable.yo_pose_five),

        };

        my_rec=findViewById(R.id.recycle_care);
        Data_Adapter data_adapter=new Data_Adapter(my_data);

        my_rec.setLayoutManager(new LinearLayoutManager(this));
        my_rec.setAdapter(data_adapter);

    };
}