package com.gulflamar.app.controller.fragment.Invoices;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gulflamar.app.R;
import com.gulflamar.app.controller.adapter.BillAdapter;
import com.gulflamar.app.databinding.FragmentInvoiceBinding;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;


public class Invoice_Fragment extends Fragment {
    String language;
    SharedPreferences preferences;
    private FragmentInvoiceBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInvoiceBinding.inflate(inflater, container, false);
        preferences = getActivity().getSharedPreferences("lan", MODE_PRIVATE);
        language=preferences.getString("language","");


        ArrayList<String> bill = new ArrayList<>();
        bill.add("Subtotal");
        bill.add("Offer discounts");
        bill.add("fees");
        bill.add("total tax");

        binding.BillList.setHasFixedSize(true);
        binding.BillList.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));
        BillAdapter billAdapter = new BillAdapter(bill,requireContext());
        binding.BillList.setAdapter(billAdapter);
        return binding.getRoot();
    }
}