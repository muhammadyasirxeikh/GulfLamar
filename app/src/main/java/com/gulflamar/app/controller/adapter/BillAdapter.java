package com.gulflamar.app.controller.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.gulflamar.app.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BillAdapter extends RecyclerView.Adapter<BillAdapter.ViewHolder>{

    private final ArrayList<String> BillList;
    private Context context;


    public BillAdapter(ArrayList<String> bill, Context ctx) {
        this.BillList = bill;
        this.context = ctx;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View list= layoutInflater.inflate(R.layout.billing_item_design, parent, false);
        return new ViewHolder(list);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String value = BillList.get(position);
        holder.fare.setText(value);

    }


    @Override
    public int getItemCount() {
        return BillList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView fare;

        public ViewHolder(View itemView) {
            super(itemView);

            fare = (itemView).findViewById(R.id.BasicFare);

        }
    }
}



