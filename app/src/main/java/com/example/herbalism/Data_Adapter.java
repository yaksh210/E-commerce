package com.example.herbalism;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Data_Adapter extends RecyclerView.Adapter<Data_Adapter.View_holder> {

    public Data_Adapter(Data_Model[] data_list) {
        this.data_list = data_list;
    }

    Data_Model[] data_list;

    @NonNull
    @Override
    public View_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View care_item=layoutInflater.inflate(R.layout.list_care,null);

        View_holder view_holder=new View_holder(care_item);


        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull View_holder holder, int position) {

        Data_Model data_model=data_list[position];
        holder.imageView.setImageResource(data_model.getImage());
        holder.text_title.setText(data_model.getTitle());
        holder.text_des.setText(data_model.getDescription());

    }

    @Override
    public int getItemCount() {
        return data_list.length;
    }

    public class View_holder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView text_title, text_des;

        public View_holder(@NonNull View itemView) {
            super(itemView);

            text_title=itemView.findViewById(R.id.txt_tit);
            text_des=itemView.findViewById(R.id.txt_des);
            imageView=itemView.findViewById(R.id.im);


        }
    }
}
