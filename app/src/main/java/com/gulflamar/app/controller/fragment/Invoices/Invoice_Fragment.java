package com.gulflamar.app.controller.fragment.Invoices;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gulflamar.app.R;
import com.gulflamar.app.controller.activity.Dashboard;
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
        Dashboard.hideNav(true);
        binding.confirmbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_invoice_Fragment_to_add_Site);
            }
        });
        binding.backFromReceipt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_invoice_Fragment_to_plan_selection);

            }
        });


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