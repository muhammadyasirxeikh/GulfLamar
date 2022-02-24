package com.gulflamar.app.controller.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gulflamar.app.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TopServicesInnerAdapter extends RecyclerView.Adapter<TopServicesInnerAdapter.ViewHolder>{

    private final ArrayList<String> Data;
    private final ArrayList<Integer> Data_images;

    private final Context context;

    public TopServicesInnerAdapter(ArrayList<String> data, Context ctx, ArrayList<Integer> datarecycler_images) {
        this.Data = data;
        this.context = ctx;
        this.Data_images=datarecycler_images;

    }


    @NonNull
    @Override
    public TopServicesInnerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View list= layoutInflater.inflate(R.layout.single_service_item_design, parent, false);
        return new TopServicesInnerAdapter.ViewHolder(list);
    }

    @Override
    public void onBindViewHolder(TopServicesInnerAdapter.ViewHolder holder, int position) {
        String name=Data.get(position);
        holder.name.setText(name);
        holder.imageView.setImageResource(Data_images.get(position));

    }


    @Override
    public int getItemCount() {
        return Data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView imageView;


        public ViewHolder(View itemView) {
            super(itemView);

            name = (itemView).findViewById(R.id.visittype);

            imageView = (itemView).findViewById(R.id.serviceImg);

        }
    }
}

