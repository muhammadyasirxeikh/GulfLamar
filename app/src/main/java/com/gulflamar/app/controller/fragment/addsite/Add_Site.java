package com.gulflamar.app.controller.fragment.addsite;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gulflamar.app.R;
import com.gulflamar.app.controller.activity.Dashboard;
import com.gulflamar.app.databinding.FragmentAddSiteBinding;
import com.gulflamar.app.databinding.FragmentInvoiceBinding;

public class Add_Site extends Fragment {


private FragmentAddSiteBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentAddSiteBinding.inflate(inflater, container, false);
        Dashboard.hideNav(true);

        binding.successBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_add_Site_to_invoice_Fragment);
            }
        });
        return binding.getRoot();
    }
}