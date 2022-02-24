package com.gulflamar.app.controller.fragment.bookings;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gulflamar.app.R;
import com.gulflamar.app.controller.adapter.BookingAdopter;
import com.gulflamar.app.databinding.FragmentBookingsBinding;
import com.gulflamar.app.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;


public class Bookings extends Fragment {

    BookingAdopter adapter;
    private FragmentBookingsBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBookingsBinding.inflate(inflater, container, false);



        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<String> booking_past_status = new ArrayList<String>();
        booking_past_status.add("pending");
        booking_past_status.add("pending");
        booking_past_status.add("Finished");

        ArrayList<String> bill = new ArrayList<>();
        bill.add("2x inside fridge");
        bill.add("1x Oven");
        bill.add("2x Glassed");

        binding.bookingDetailsRv.setHasFixedSize(true);
        binding.bookingDetailsRv.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));
        adapter = new BookingAdopter(booking_past_status,bill, requireContext());
        binding.bookingDetailsRv.setAdapter(adapter);

    }


}