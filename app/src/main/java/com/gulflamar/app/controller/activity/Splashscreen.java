package com.gulflamar.app.controller.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.gulflamar.app.R;
import com.gulflamar.app.databinding.ActivitySplashBinding;

import java.util.zip.Inflater;

public class Splashscreen extends AppCompatActivity {

    private ActivitySplashBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivitySplashBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.removeCallbacks(this);
                startActivity( new Intent(Splashscreen.this, Language_select.class));;
                finish();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        }, 3000);
    }

}