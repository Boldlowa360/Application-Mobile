package com.example.retrofitliste;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
     public List<Long> list;

     public static class ViewHolder extends RecyclerView.ViewHolder{
         public TextView tvLong;

         public ViewHolder(View view){
             super(view);

             tvLong= view.findViewById(R.id.tvLong);
         }
     }
     public Adapter(){list = new ArrayList<>();}

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
         View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.affichage_long, viewGroup, false);
         return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

         Long longActuel = list.get(position);
         holder.tvLong.setText(longActuel.toString());
    }



    @Override
    public int getItemCount(){return list.size();}
}
