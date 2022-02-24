package com.gulflamar.app.controller.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.gulflamar.app.R;
import com.gulflamar.app.databinding.ActivityOnBoardScreenBinding;
import com.gulflamar.app.databinding.SecondOnboardscreenBinding;

public class Second_onboardscreen extends AppCompatActivity {
    String language;
    SharedPreferences preferences;
    private SecondOnboardscreenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= SecondOnboardscreenBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        preferences = getSharedPreferences("lan", MODE_PRIVATE);
        language=preferences.getString("language","");

        binding.getstarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Second_onboardscreen.this,Signin.class);
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