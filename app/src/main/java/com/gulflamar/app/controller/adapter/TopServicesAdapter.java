package com.gulflamar.app.controller.adapter;

import android.content.Context;
import android.hardware.usb.UsbInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gulflamar.app.R;
import com.gulflamar.app.model.SingleServiceData;
import com.gulflamar.app.model.TopServicesData;
import com.skydoves.elasticviews.ElasticButton;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TopServicesAdapter extends RecyclerView.Adapter<TopServicesAdapter.ViewHolder> {

    private final ArrayList<String> Data;
    private final ArrayList<String> Datarecycler;
    private final ArrayList<Integer> Datarecycler_images;
    private final Context context;
    TopServicesInnerAdapter adapter;

    public TopServicesAdapter(ArrayList<String> data, Context ctx, ArrayList<String> recyclerdata, ArrayList<Integer> images) {
        this.Data = data;
        this.context = ctx;
        this.Datarecycler = recyclerdata;
        this.Datarecycler_images=images;
    }


    @NonNull
    @Override
    public TopServicesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View list = layoutInflater.inflate(R.layout.home_top_services_list_design, parent, false);
        return new ViewHolder(list);
    }

    @Override
    public void onBindViewHolder(TopServicesAdapter.ViewHolder holder, int position) {
        String name = Data.get(position);
        holder.name_tv.setText(name);
        holder.singleitemlist_rv.setLayoutManager(new LinearLayoutManager(context.getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        adapter = new TopServicesInnerAdapter(Datarecycler, context,Datarecycler_images);
        holder.singleitemlist_rv.setAdapter(adapter);

    }


    @Override
    public int getItemCount() {
        return Data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name_tv;
        RecyclerView singleitemlist_rv;


        public ViewHolder(View itemView) {
            super(itemView);

            name_tv = (itemView).findViewById(R.id.serviceName);
            singleitemlist_rv = (itemView).findViewById(R.id.singleserviceList);


        }
    }
}


