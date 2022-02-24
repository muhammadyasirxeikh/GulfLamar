package com.gulflamar.app.controller.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gulflamar.app.R;
import com.skydoves.elasticviews.ElasticButton;
import com.skydoves.elasticviews.ElasticImageView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import ru.nikartm.support.ImageBadgeView;

public class ExtrasServiceSelectedAdapter extends RecyclerView.Adapter<ExtrasServiceSelectedAdapter.ViewHolder>{

    private final ArrayList<String> Data;
    private final ArrayList<Integer> Data_images;
    private final ArrayList<Integer> Data_count;
    AlertDialog.Builder dialogBuilder;
    AlertDialog alertDialog;
    String amount;

    private final Context context;

    public ExtrasServiceSelectedAdapter(ArrayList<String> data, Context ctx, ArrayList<Integer> datarecycler_images,ArrayList<Integer> data_count) {
        this.Data = data;
        this.context = ctx;
        this.Data_images=datarecycler_images;
        this.Data_count=data_count;

    }


    @NonNull
    @Override
    public ExtrasServiceSelectedAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View list= layoutInflater.inflate(R.layout.selected_extras_rv_item, parent, false);
        return new ExtrasServiceSelectedAdapter.ViewHolder(list);
    }

    @Override
    public void onBindViewHolder(ExtrasServiceSelectedAdapter.ViewHolder holder, int position) {
        String name=Data.get(position);
        holder.name.setText(name);
        holder.imageView.setImageResource(Data_images.get(position));
        holder.imageView.setBadgeValue(Data_count.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opendialog();


            }
        });

    }
    private void opendialog() {
        dialogBuilder = new AlertDialog.Builder(context);
        View layoutView = LayoutInflater.from(context).inflate(R.layout.add_quantity_dialog, null);



        ElasticButton confirm = (ElasticButton) layoutView.findViewById(R.id.confirmbutton);
        TextView cancel = (TextView) layoutView.findViewById(R.id.cancel_credit);
        ElasticImageView Add = (ElasticImageView) layoutView.findViewById(R.id.add_money);
        ElasticImageView Deduct = (ElasticImageView) layoutView.findViewById(R.id.deduct_money);
        TextView fare_amount = (TextView) layoutView.findViewById(R.id.RideFare);
        TextView fare_amount_option1 = (TextView) layoutView.findViewById(R.id.FareOption1);
        TextView fare_amount_option2 = (TextView) layoutView.findViewById(R.id.FareOption2);
        TextView fare_amount_option3 = (TextView) layoutView.findViewById(R.id.FareOption3);


        dialogBuilder.setView(layoutView);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimations;
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();

        //onclick start

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                amount=fare_amount.getText().toString().trim();
                Toast.makeText(context, "Added", Toast.LENGTH_SHORT).show();
            }
        });

        fare_amount_option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amount = fare_amount_option1.getText().toString().trim();
                fare_amount.setText(amount);
            }
        });

        fare_amount_option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amount = fare_amount_option2.getText().toString().trim();
                fare_amount.setText(amount);
            }
        });

        fare_amount_option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amount = fare_amount_option3.getText().toString().trim();
                fare_amount.setText(amount);
            }
        });

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amount = fare_amount.getText().toString().trim();
                if (!amount.isEmpty() && !amount.equalsIgnoreCase("0")){

                    int value = Integer.parseInt(amount);
                    int updated_value = value+1;
                    fare_amount.setText(String.valueOf(updated_value));
                }
            }
        });

        Deduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amount = fare_amount.getText().toString().trim();
                if (!amount.isEmpty()){

                    int value = Integer.parseInt(amount);
                    int updated_value = value-1;
                    fare_amount.setText(String.valueOf(updated_value));
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });



        //onclick end
    }


    @Override
    public int getItemCount() {
        return Data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageBadgeView imageView;



        public ViewHolder(View itemView) {
            super(itemView);

            name = (itemView).findViewById(R.id.extra_service_name);

            imageView = (itemView).findViewById(R.id.ibv_icon2);

        }
    }
}


