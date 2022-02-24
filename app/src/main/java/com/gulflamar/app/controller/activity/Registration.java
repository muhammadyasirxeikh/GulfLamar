package com.gulflamar.app.controller.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;

import com.gulflamar.app.R;
import com.gulflamar.app.databinding.ActivityRegistrationBinding;
import com.gulflamar.app.util.Constant;

public class Registration extends AppCompatActivity {

    private ActivityRegistrationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= ActivityRegistrationBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        binding.registerNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.userName.getText().toString().trim();
                String email = binding.userEmail.getText().toString().trim();
                String number = binding.phoneNumber.getText().toString().trim();
                String language = binding.language.getText().toString().trim();
                if(TextUtils.isEmpty(name)) {
                    Constant.constant.setError(binding.userName,getString(R.string.entername));
                }else if(TextUtils.isEmpty(email)){
                    Constant.constant.setError(binding.userEmail,getString(R.string.enteremail));
                }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    Constant.constant.setError(binding.userEmail, getString(R.string.validemail));
                }else if(TextUtils.isEmpty(number) && !Patterns.PHONE.matcher(number).matches()) {
                    Constant.constant.setError(binding.phoneNumber,getString(R.string.enterphone));
                }else if(TextUtils.isEmpty(language)){
                    Constant.constant.setError(binding.userEmail,getString(R.string.selectlanguage));
                }else {

                    Intent intent=new Intent(Registration.this,Dashboard.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
}