package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SecretAdapter extends RecyclerView.Adapter<SecretAdapter.ViewHolder> {

    public List<Secret> list;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView VName;
        public TextView VDate;
        public TextView VNbGrand;

        public ViewHolder(View view) {
            super(view);

            VName = (TextView) view.findViewById(R.id.Nom);
            VDate = (TextView) view.findViewById(R.id.date);
            VNbGrand = (TextView) view.findViewById(R.id.nbGrand);
        }
    }

    public SecretAdapter() {
        list = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.secret_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        Secret secretCourant = list.get(position);
        viewHolder.VName.setText(secretCourant.nom);
        viewHolder.VDate.setText(secretCourant.date.toString());
        viewHolder.VNbGrand.setText(secretCourant.nbGrand.toString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

