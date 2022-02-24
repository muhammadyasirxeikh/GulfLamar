package com.gulflamar.app.controller.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

import com.gulflamar.app.R;
import com.gulflamar.app.databinding.ActivityLanguageSelectBinding;
import com.gulflamar.app.util.LocaleHelper;

public class Language_select extends AppCompatActivity {
private ActivityLanguageSelectBinding binding;
    Context context;
    Resources resources;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLanguageSelectBinding.inflate(getLayoutInflater());
        View view =binding.getRoot();
        setContentView(view);
        sharedPreferences= getSharedPreferences("lan", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        binding.arabicLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.arabicLanguage.setTextColor(ActivityCompat.getColor(Language_select.this, R.color.color_select));
                binding.arabicLanguage.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_select_check, 0);
                binding.englishLanguage.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_unselect_check, 0);
                binding.englishLanguage.setTextColor(ActivityCompat.getColor(Language_select.this, R.color.color_unselect));

                LocaleHelper.setLocale(getApplication(),"ar");
                getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("language", "spanish");
                editor.apply();
                recreate();
//                context = LocaleHelper.setLocale(Language_select.this, "en");
//                resources = context.getResources();

                Intent intent =new Intent(Language_select.this,Dashboard.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        binding.englishLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.englishLanguage.setTextColor(ActivityCompat.getColor(Language_select.this, R.color.color_select));
                binding.englishLanguage.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_select_check, 0);
                binding.arabicLanguage.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_unselect_check, 0);

                binding.arabicLanguage.setTextColor(ActivityCompat.getColor(Language_select.this, R.color.color_unselect));

                LocaleHelper.setLocale(getApplication(),"en");
                getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
                editor.putString("language", "english");
                editor.apply();
                recreate();
//                context = LocaleHelper.setLocale(Language_select.this, "ar");
//                resources = context.getResources();
                Intent intent =new Intent(Language_select.this,Dashboard.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}