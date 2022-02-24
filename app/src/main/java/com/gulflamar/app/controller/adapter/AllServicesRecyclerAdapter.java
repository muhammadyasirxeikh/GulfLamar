package com.gulflamar.app.controller.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gulflamar.app.R;
import com.gulflamar.app.controller.fragment.planSlectionScreen.Plan_selection;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

public class AllServicesRecyclerAdapter extends RecyclerView.Adapter<AllServicesRecyclerAdapter.ViewHolder>{

    private final ArrayList<String> Data;
    private final ArrayList<Integer> images;
    List<List> list;

    private final Context context;

    public AllServicesRecyclerAdapter(ArrayList<String> data, Context ctx,ArrayList<Integer> images) {
        this.Data = data;
        this.context = ctx;
        this.images=images;

    }


    @NonNull
    @Override
    public AllServicesRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View list= layoutInflater.inflate(R.layout.all_service_rvitem_design, parent, false);
        return new AllServicesRecyclerAdapter.ViewHolder(list);
    }

    @Override
    public void onBindViewHolder(AllServicesRecyclerAdapter.ViewHolder holder, int position) {
        String name=Data.get(position);
        holder.service_name_tv.setText(name);
        holder.service_imageView.setImageResource(images.get(position));

        holder.service_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Bundle bundle = new Bundle();
                bundle.putString("service_name",name);
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_planselection,bundle);
//                Fragment fragment=new Plan_selection();
//                fragment.setArguments(bundle);
//                ((FragmentActivity)view.getContext()).getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.fragment_main,
//                                fragment).commit();
            }
        });




    }


    @Override
    public int getItemCount() {
        return Data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView service_name_tv;
        ImageView service_imageView;


        public ViewHolder(View itemView) {
            super(itemView);

            service_name_tv = (itemView).findViewById(R.id.allservices_item_name);

            service_imageView = (itemView).findViewById(R.id.allservices_item_img);

        }
    }
}