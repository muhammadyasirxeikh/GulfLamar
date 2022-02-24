package com.gulflamar.app.controller.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.gulflamar.app.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PlanSelectItemAdapter extends RecyclerView.Adapter<PlanSelectItemAdapter.ViewHolder>{

    private final ArrayList<String> Data;
    private final ArrayList<Integer> Data_images;

    private final Context context;

    public PlanSelectItemAdapter(ArrayList<String> data, Context ctx, ArrayList<Integer> datarecycler_images) {
        this.Data = data;
        this.context = ctx;
        this.Data_images=datarecycler_images;

    }


    @NonNull
    @Override
    public PlanSelectItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View list= layoutInflater.inflate(R.layout.plan_slected_rv_item, parent, false);
        return new PlanSelectItemAdapter.ViewHolder(list);
    }

    @Override
    public void onBindViewHolder(PlanSelectItemAdapter.ViewHolder holder, int position) {
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
        RadioButton radioButton;


        public ViewHolder(View itemView) {
            super(itemView);

            name = (itemView).findViewById(R.id.visittype);

            imageView = (itemView).findViewById(R.id.serviceImg);
            radioButton = (itemView).findViewById(R.id.ischecked);

        }
    }
}

