package com.gulflamar.app.controller.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.NavHostFragment;

import android.media.Image;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.gulflamar.app.R;
import com.gulflamar.app.controller.fragment.Invoices.Invoice_Fragment;
import com.gulflamar.app.controller.fragment.addsite.Add_Site;
import com.gulflamar.app.controller.fragment.bookings.Bookings;
import com.gulflamar.app.controller.fragment.editprofile.EditProfile;
import com.gulflamar.app.controller.fragment.home.Home;
import com.gulflamar.app.controller.fragment.planSlectionScreen.Plan_selection;
import com.gulflamar.app.controller.fragment.profile.Profile;
import com.gulflamar.app.databinding.ActivityDashboardBinding;
import com.gulflamar.app.databinding.ActivityVerificationBinding;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class Dashboard extends AppCompatActivity {


    private ActivityDashboardBinding binding;
    NavController mNavController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.bottomNavBar.setItemSelected(R.id.nav_home, true);


        NavHostFragment finalHost = NavHostFragment.create(R.navigation.nav_graph);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.nav_host_fragment, finalHost)
                .setPrimaryNavigationFragment(finalHost) // equivalent to app:defaultNavHost="true"
                .commit();

        binding.bottomNavBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch (i) {
                    case R.id.nav_home:
                        fragment = new Home();
                        break;
                    case R.id.nav_profile:
                        fragment = new Profile();
                        break;
                    case R.id.nav_notification:
                        fragment = new Add_Site();
                        break;

                    case R.id.nav_wallet:
                        fragment = new Bookings();
                        break;
                }
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment,
                                fragment).commit();
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
}