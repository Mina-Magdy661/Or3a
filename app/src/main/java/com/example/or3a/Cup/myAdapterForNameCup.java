package com.example.or3a.Cup;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.or3a.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class myAdapterForNameCup extends RecyclerView.Adapter<myAdapterForNameCup.myViewHolder> {

    ArrayList<String> list ;
    Context context;


    public myAdapterForNameCup(ArrayList<String> list, Context context ) {
        this.list = list;
        this.context =context;

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_item , parent, false);
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

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, holder.txtNameItem.getText().toString(), Toast.LENGTH_SHORT).show();
                Intent goToShowCupNumper = new Intent(context , ShowCupNumper.class);
                goToShowCupNumper.putExtra("teamName" ,holder.txtNameItem.getText().toString() );
                context.startActivity(goToShowCupNumper);
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
        CardView cardView ;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNameItem = itemView.findViewById(R.id.txtNameItem);
            deleteItem = itemView.findViewById(R.id.delete_item);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }
}
