package com.gulflamar.app.controller.fragment.editprofile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.gulflamar.app.R;
import com.gulflamar.app.databinding.FragmentEditProfileBinding;
import com.gulflamar.app.databinding.FragmentHomeBinding;

public class EditProfile extends Fragment {

    private FragmentEditProfileBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentEditProfileBinding.inflate(inflater,container, false);
        String[] languages = new String[]{"Select Language","Arabic", "English"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_dropdown_item, languages);
//set the spinners adapter to the previously created one.
        binding.languageSpinner.setAdapter(adapter);

        return binding.getRoot();
    }
}