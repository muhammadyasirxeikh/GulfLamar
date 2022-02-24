package com.gulflamar.app.controller.fragment.planSlectionScreen;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.gulflamar.app.R;
import com.gulflamar.app.controller.activity.Dashboard;
import com.gulflamar.app.controller.activity.Language_select;
import com.gulflamar.app.controller.adapter.ExtrasServiceSelectedAdapter;
import com.gulflamar.app.controller.adapter.PlanSelectItemAdapter;
import com.gulflamar.app.controller.adapter.TopServicesAdapter;
import com.gulflamar.app.databinding.FragmentHomeBinding;
import com.gulflamar.app.databinding.FragmentPlanSelectionBinding;
import com.skydoves.elasticviews.ElasticButton;
import com.skydoves.elasticviews.ElasticImageView;

import java.util.ArrayList;


public class Plan_selection extends Fragment {

    PlanSelectItemAdapter adapter;
    ExtrasServiceSelectedAdapter extraadapder;
    private FragmentPlanSelectionBinding binding;
    
    AlertDialog.Builder dialogBuilder;
    AlertDialog alertDialog;
    String name;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding= FragmentPlanSelectionBinding.inflate(inflater,container, false);
        Dashboard.hideNav(true);


        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
           name = bundle.getString("service_name");
        }
        binding.selectedServiceName.setText(name);
        binding.confirmbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_plan_selection_to_invoice_Fragment);
            }
        });
        binding.weekly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.weekly.setTextColor(ActivityCompat.getColor(requireContext(), R.color.white));
                binding.weekly.setBackground(ActivityCompat.getDrawable(requireContext(),R.drawable.frequency_select_bg));
                binding.biWeekly.setTextColor(ActivityCompat.getColor(requireContext(), R.color.color_unselect));
                binding.biWeekly.setBackground(ActivityCompat.getDrawable(requireContext(),R.drawable.frequency_unselect_bg));
                binding.monthly.setTextColor(ActivityCompat.getColor(requireContext(), R.color.color_unselect));
                binding.monthly.setBackground(ActivityCompat.getDrawable(requireContext(),R.drawable.frequency_unselect_bg));

            }
        });
        binding.biWeekly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.weekly.setTextColor(ActivityCompat.getColor(requireContext(), R.color.color_unselect));
                binding.weekly.setBackground(ActivityCompat.getDrawable(requireContext(),R.drawable.frequency_unselect_bg));
                binding.biWeekly.setTextColor(ActivityCompat.getColor(requireContext(), R.color.white));
                binding.biWeekly.setBackground(ActivityCompat.getDrawable(requireContext(),R.drawable.frequency_select_bg));
                binding.monthly.setTextColor(ActivityCompat.getColor(requireContext(), R.color.color_unselect));
                binding.monthly.setBackground(ActivityCompat.getDrawable(requireContext(),R.drawable.frequency_unselect_bg));

            }
        });
        binding.monthly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.weekly.setTextColor(ActivityCompat.getColor(requireContext(), R.color.color_unselect));
                binding.weekly.setBackground(ActivityCompat.getDrawable(requireContext(),R.drawable.frequency_unselect_bg));
                binding.biWeekly.setTextColor(ActivityCompat.getColor(requireContext(), R.color.color_unselect));
                binding.biWeekly.setBackground(ActivityCompat.getDrawable(requireContext(),R.drawable.frequency_unselect_bg));
                binding.monthly.setTextColor(ActivityCompat.getColor(requireContext(), R.color.white));
                binding.monthly.setBackground(ActivityCompat.getDrawable(requireContext(),R.drawable.frequency_select_bg));

            }
        });
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_plan_selection_to_homeFragment);
                Dashboard.hideNav(false);

            }
        });
        getplan();
        getextrasplan();

    }



    private void getextrasplan() {

        ArrayList<String> service_names = new ArrayList<>();
        service_names.add("Inside Fridge");
        service_names.add("organizing");
        service_names.add("Small bind");
        service_names.add("Patio");
        service_names.add("Inside Fridge");
        service_names.add("Inside Fridge");

        ArrayList<Integer> service_images = new ArrayList<>();
        service_images.add(R.drawable.ic_fridge);
        service_images.add(R.drawable.ic_organiging);
        service_images.add(R.drawable.ic_smallbind);
        service_images.add(R.drawable.ic_patio);
        service_images.add(R.drawable.ic_fridge);
        service_images.add(R.drawable.ic_fridge);
        ArrayList<Integer> service_count = new ArrayList<>();
        service_count.add(27);
        service_count.add(0);
        service_count.add(1);
        service_count.add(29);
        service_count.add(59);
        service_count.add(9);

        binding.extrasplanlistRv.setLayoutManager(new GridLayoutManager(requireContext(), 3));;
        extraadapder = new ExtrasServiceSelectedAdapter(service_names, requireContext() ,service_images,service_count);
        binding.extrasplanlistRv.setAdapter(extraadapder);

    }

    private void getplan() {

        ArrayList<String> service_names = new ArrayList<>();
        service_names.add("Indoor cleaning");
        service_names.add("Outdoor Cleaning");
        service_names.add("Factory Cleaning");


        ArrayList<Integer> service_images = new ArrayList<>();
        service_images.add(R.drawable.slectedservice1);
        service_images.add(R.drawable.slectedservice2);
        service_images.add(R.drawable.slectedservice1);


        binding.planlistRv.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false));
        adapter = new PlanSelectItemAdapter(service_names, requireContext() ,service_images);
        binding.planlistRv.setAdapter(adapter);

        binding.planlistRv.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });


    }
}