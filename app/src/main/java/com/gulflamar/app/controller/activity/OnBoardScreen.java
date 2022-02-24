package com.gulflamar.app.controller.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

import com.gulflamar.app.R;
import com.gulflamar.app.databinding.ActivityOnBoardScreenBinding;
import com.gulflamar.app.util.LocaleHelper;


public class OnBoardScreen extends AppCompatActivity {

    private ActivityOnBoardScreenBinding binding;
    String language;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= ActivityOnBoardScreenBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        preferences = getSharedPreferences("lan", MODE_PRIVATE);
        language=preferences.getString("language","");
        binding.skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(OnBoardScreen.this,Signin.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        binding.moveNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(OnBoardScreen.this,Second_onboardscreen.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
}