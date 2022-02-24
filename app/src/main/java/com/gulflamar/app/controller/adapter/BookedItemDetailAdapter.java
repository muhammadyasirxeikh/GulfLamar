package com.gulflamar.app.controller.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gulflamar.app.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BookedItemDetailAdapter extends RecyclerView.Adapter<BookedItemDetailAdapter.ViewHolder> {

    private final ArrayList<String> Data;


    private final Context context;

    public BookedItemDetailAdapter(ArrayList<String> data, Context ctx) {
        this.Data = data;
        this.context = ctx;


    }


    @NonNull
    @Override
    public BookedItemDetailAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View list = layoutInflater.inflate(R.layout.booked_items_detail_rv_item, parent, false);
        return new BookedItemDetailAdapter.ViewHolder(list);
    }

    @Override
    public void onBindViewHolder(BookedItemDetailAdapter.ViewHolder holder, int position) {
        String name = Data.get(position);
        holder.name_tv.setText(name);
    }


    @Override
    public int getItemCount() {
        return Data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name_tv;


        public ViewHolder(View itemView) {
            super(itemView);

            name_tv = (itemView).findViewById(R.id.bookeditems_tv);


        }
    }
}
