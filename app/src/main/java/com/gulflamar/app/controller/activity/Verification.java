package com.gulflamar.app.controller.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.gulflamar.app.R;
import com.gulflamar.app.databinding.ActivityVerificationBinding;

import java.util.ArrayList;
import java.util.HashMap;

public class Verification extends AppCompatActivity {

    private ActivityVerificationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityVerificationBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);






        Intent intent = getIntent();
        String getValue = intent.getStringExtra("number_");
        binding.number.setText(getValue);



        binding.confirmbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Verification.this,SuccessScreen.class);
                startActivity(intent);
//                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });

    }




    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

//        overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
    }
}