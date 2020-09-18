package com.example.or3a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder> {

    ArrayList<String> list ;

    public myAdapter(ArrayList<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.name_item , parent, false);
        myViewHolder view = new myViewHolder(v);
        return  view;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        String currentItem = list.get(position);
        holder.txtNameItem.setText(currentItem);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class  myViewHolder extends RecyclerView.ViewHolder{

        TextView txtNameItem ;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNameItem = itemView.findViewById(R.id.txtNameItem);
        }
    }
}
