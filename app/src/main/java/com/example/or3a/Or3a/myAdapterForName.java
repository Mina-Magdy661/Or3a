package com.example.or3a.Or3a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.or3a.R;

import java.util.ArrayList;

public class myAdapterForName extends RecyclerView.Adapter<myAdapterForName.myViewHolder> {

    ArrayList<String> list ;
    Context context;


    public myAdapterForName(ArrayList<String> list, Context context) {
        this.list = list;
        this.context =context;

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.name_item , parent, false);
        myViewHolder view = new myViewHolder(v);
        return  view;
    }

    @Override
    public void onBindViewHolder(@NonNull final myViewHolder holder, final int position) {

        String currentItem = list.get(position);
        holder.txtNameItem.setText(currentItem);
        holder.deleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class  myViewHolder extends RecyclerView.ViewHolder{

        TextView txtNameItem ;
        LinearLayout deleteItem;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNameItem = itemView.findViewById(R.id.txtNameItem);
            deleteItem = itemView.findViewById(R.id.delete_item);
        }
    }
}
