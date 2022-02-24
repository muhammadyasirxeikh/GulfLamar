package com.gulflamar.app.controller.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.gulflamar.app.R;
import com.gulflamar.app.databinding.ActivityOnBoardScreenBinding;
import com.gulflamar.app.databinding.ActivitySigninBinding;
import com.gulflamar.app.util.Constant;
import com.hbb20.CountryCodePicker;

public class Signin extends AppCompatActivity {

    private ActivitySigninBinding binding;
    String phone_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivitySigninBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        binding.ccp.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
            @Override
            public void onCountrySelected() {
                Toast.makeText(Signin.this,  binding.ccp.getSelectedCountryName(), Toast.LENGTH_SHORT).show();
            }
        });
//        binding.ccp.setDefaultCountryUsingNameCode("pk");

        binding.signinback.setOnClickListener(v -> {
            Intent intent = new Intent(Signin.this, Splashscreen.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        });
        binding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone_number= binding.phoneNumber.getText().toString();
                if(TextUtils.isEmpty(phone_number)) {
                    Constant.constant.setError(binding.phoneNumber,"Enter Phone Number");
                }else {
                    Intent intent = new Intent(Signin.this, Verification.class);
                    intent.putExtra("number_","+" +binding.ccp.getSelectedCountryCode()+phone_number);
                    startActivity(intent);
//
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


                }
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

//
    }
}
