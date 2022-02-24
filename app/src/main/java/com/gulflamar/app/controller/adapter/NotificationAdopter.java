package com.gulflamar.app.controller.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.gulflamar.app.R;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class NotificationAdopter extends RecyclerView.Adapter<NotificationAdopter.ViewHolder>{

    private ArrayList<String> rider_request;
    private Context context;
    private int lastPosition = -1;


    // RecyclerView recyclerView;
    public NotificationAdopter(ArrayList<String> requests, Context ctx) {
        this.rider_request = requests;
        this.context = ctx;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View car_list= layoutInflater.inflate(R.layout.notification_item_design, parent, false);
        return new ViewHolder(car_list);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String current_ride = rider_request.get(position);
        holder.address.setText(current_ride);

    }


    @Override
    public int getItemCount() {
        return rider_request.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView address;

        public ViewHolder(View itemView) {
            super(itemView);

            address = (itemView).findViewById(R.id.sub_address);

        }
    }

}



