package com.example.retrofitliste;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitliste.transfert.Truc;

import java.util.ArrayList;
import java.util.List;

public class TrucAdapter extends RecyclerView.Adapter<TrucAdapter.ViewHolder> {


   public List<Truc> list;

   public static class ViewHolder extends RecyclerView.ViewHolder{
       public TextView tvA;
       public TextView tvB;
       public TextView tvC;

       public ViewHolder(View view){
           super(view);

           tvA = view.findViewById(R.id.tvLongA);
           tvB = view.findViewById(R.id.tvStringB);
           tvC = view.findViewById(R.id.tvListSize);
       }
   }

    public TrucAdapter(){list = new ArrayList<>();}


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
       View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.affichage_truc, viewGroup,false);

       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Truc trucActuel = list.get(position);
        holder.tvA.setText(trucActuel.a+"");
        holder.tvB.setText(trucActuel.b);
        holder.tvC.setText(trucActuel.c.size()+"");
    }

    @Override
    public int getItemCount() { return list.size();}
}
