package com.gulflamar.app.controller.fragment.profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gulflamar.app.R;
import com.gulflamar.app.controller.fragment.bookings.Bookings;
import com.gulflamar.app.databinding.FragmentProfileBinding;


public class Profile extends Fragment {


    private FragmentProfileBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentProfileBinding.inflate(inflater, container, false);

        binding.tvBookings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_profile_to_booking);

            }
        });
        binding.tvPersonalDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_profile_to_editprofile);
            }
        });
        binding.tvNotifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_profile_to_notification);
            }
        });

        return binding.getRoot();


    }
}