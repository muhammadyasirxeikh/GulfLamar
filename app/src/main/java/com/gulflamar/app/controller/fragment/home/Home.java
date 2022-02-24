package com.gulflamar.app.controller.fragment.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gulflamar.app.R;
import com.gulflamar.app.controller.adapter.AllServicesRecyclerAdapter;
import com.gulflamar.app.controller.adapter.SliderAdapter;
import com.gulflamar.app.controller.adapter.TopServicesAdapter;
import com.gulflamar.app.databinding.FragmentHomeBinding;
import com.gulflamar.app.model.SingleServiceData;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;


public class Home extends Fragment {

    private FragmentHomeBinding binding;
    TopServicesAdapter adapter;
    AllServicesRecyclerAdapter servicesadapter;
    List<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
    List<SingleServiceData> sub_list = new ArrayList<>();

    SliderAdapter sliderAdapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);


        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //TODO: data

        binding.searchEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        getallservices();
        gettopservices();
        getsliderimages();

    }

    private void getsliderimages() {

//        int[] images={R.drawable.pic1,R.drawable.samplepic,R.drawable.pic1};
        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.pic1);
        images.add(R.drawable.samplepic);
        images.add(R.drawable.nanyservices);
//        mViewPagerAdapter = new ViewPagerAdapter(requireContext(), images);
        sliderAdapter = new SliderAdapter(requireContext(), images);
//start
//        SliderAdapter adapter = new SliderAdapter(this, sliderDataArrayList);

        // below method is used to set auto cycle direction in left to
        // right direction you can change according to requirement.
        binding.imageSlider.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

        // below method is used to
        // setadapter to sliderview.
        binding.imageSlider.setSliderAdapter(sliderAdapter);

        // below method is use to set
        // scroll time in seconds.
        binding.imageSlider.setScrollTimeInSec(3);

        // to set it scrollable automatically
        // we use below method.
        binding.imageSlider.setAutoCycle(true);

        // to start autocycle below method is used.
        binding.imageSlider.startAutoCycle();

//end
    }

    private void getallservices() {

        ArrayList<String> service_names = new ArrayList<>();
        service_names.add("cleaning");
        service_names.add("Man power support");
        service_names.add("Recruitment");
        service_names.add("Labor Housing");
        service_names.add("Pets Control");

        ArrayList<Integer> service_images = new ArrayList<>();
        service_images.add(R.drawable.cleaning);
        service_images.add(R.drawable.laborers);
        service_images.add(R.drawable.recruitment);
        service_images.add(R.drawable.house);
        service_images.add(R.drawable.veterinary);


        binding.servicesList.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false));
        servicesadapter = new AllServicesRecyclerAdapter(service_names, requireContext(), service_images);
        binding.servicesList.setAdapter(servicesadapter);
    }

    private void gettopservices() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Home cleaning");
        names.add("Specialty cleaning");
        names.add("Nanny Services");

        ArrayList<String> type = new ArrayList<>();
        type.add("Single visit");
        type.add("second visit");
        type.add("third visit");

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.samplepic);
        images.add(R.drawable.nanyservices);
        images.add(R.drawable.specialitycleaning);

        binding.TopServicesList.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false));
        adapter = new TopServicesAdapter(names, requireContext(), type, images);
        binding.TopServicesList.setAdapter(adapter);
    }


    @Override
    public void onStart() {
        super.onStart();
        //TODO: dynamic tasks
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
    }

}