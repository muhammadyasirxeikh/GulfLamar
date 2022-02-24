package com.gulflamar.app.controller.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.gulflamar.app.R;
import com.skydoves.elasticviews.ElasticButton;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BookingAdopter extends RecyclerView.Adapter<BookingAdopter.ViewHolder>{

    private final ArrayList<String> booking_status;
    private final ArrayList<String> booked_items;
    private Context context;
    BookedItemDetailAdapter adapter;

    // RecyclerView recyclerView;
    public BookingAdopter(ArrayList<String> status,ArrayList<String> items, Context ctx) {
        this.booking_status = status;
        this.context = ctx;
        this.booked_items=items;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View car_list= layoutInflater.inflate(R.layout.booking_rv_item_design, parent, false);
        return new ViewHolder(car_list);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String current_booking = booking_status.get(position);
        holder.status.setText(current_booking);



        holder.rv_booked_items.setLayoutManager(new LinearLayoutManager(context.getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        adapter = new BookedItemDetailAdapter(booked_items, context);
        holder.rv_booked_items.setAdapter(adapter);
        if (current_booking.equalsIgnoreCase("Finished")){
            holder.reshedule.setVisibility(View.GONE);
            holder.cancel.setVisibility(View.GONE);
        }

    }


    @Override
    public int getItemCount() {
        return booking_status.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView status;
        ElasticButton cancel,reshedule;
        RecyclerView rv_booked_items;

        public ViewHolder(View itemView) {
            super(itemView);

            status = (itemView).findViewById(R.id.booking_status);
            cancel = (itemView).findViewById(R.id.cancel_booking);
            reshedule = (itemView).findViewById(R.id.reschedule_booking);
            rv_booked_items=(itemView).findViewById(R.id.booking_items_details_rv);


            itemView.setOnClickListener(view -> {
//                Navigation.findNavController(view).navigate(R.id.action_myBooking2_to_invoice);
            });

        }
    }
}


