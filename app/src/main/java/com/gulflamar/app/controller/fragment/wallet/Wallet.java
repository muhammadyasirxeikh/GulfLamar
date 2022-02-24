package com.gulflamar.app.controller.fragment.wallet;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gulflamar.app.R;
import com.gulflamar.app.controller.activity.Dashboard;
import com.gulflamar.app.databinding.FragmentPlanSelectionBinding;
import com.gulflamar.app.databinding.FragmentWalletBinding;


public class Wallet extends Fragment {

    private FragmentWalletBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentWalletBinding.inflate(inflater,container, false);


      return binding.getRoot();
    }
}