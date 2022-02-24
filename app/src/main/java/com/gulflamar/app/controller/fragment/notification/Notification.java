package com.gulflamar.app.controller.fragment.notification;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.gulflamar.app.controller.activity.Dashboard;
import com.gulflamar.app.controller.adapter.NotificationAdopter;
import com.gulflamar.app.databinding.FragmentNotificationBinding;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;


public class Notification extends Fragment {

    private FragmentNotificationBinding binding;
    NotificationAdopter notificationAdopter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentNotificationBinding.inflate(inflater, container, false);

        ArrayList<String> dummy = new ArrayList<String>();
        dummy.add("Sub-address");
        dummy.add("Sub-address");
        dummy.add("Sub-address");
        dummy.add("Sub-address");

        binding.notificationsList.setHasFixedSize(true);
        binding.notificationsList.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));
        notificationAdopter = new NotificationAdopter(dummy,requireContext());
        binding.notificationsList.setAdapter(notificationAdopter);

        return binding.getRoot();
    }
}