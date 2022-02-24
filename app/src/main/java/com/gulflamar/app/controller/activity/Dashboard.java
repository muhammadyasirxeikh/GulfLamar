package com.gulflamar.app.controller.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
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


    private static ActivityDashboardBinding binding;
    NavController mNavController;
    NavOptions navOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.bottomNavBar.setItemSelected(R.id.nav_home, true);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);

        if (navHostFragment != null) {
            mNavController = navHostFragment.getNavController();
        }


        navOptions = new NavOptions.Builder()
                .setLaunchSingleTop(true)
                .setPopUpTo(mNavController.getGraph().getStartDestination(), false)
                .setEnterAnim(R.anim.slide_in_right)
                .setExitAnim(R.anim.slide_out_left)
                .setPopEnterAnim(R.anim.slide_in_right)
                .setPopExitAnim(R.anim.slide_out_left)
                .build();


        binding.bottomNavBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {

                switch (i) {
                    case R.id.nav_home:

                        mNavController.navigate(R.id.homeFragment, null, navOptions);
                        break;
                    case R.id.nav_profile:

                        mNavController.navigate(R.id.profile, null, navOptions);

                        break;
                    case R.id.nav_notification:

                        mNavController.navigate(R.id.notification_nav, null, navOptions);

                        break;

                    case R.id.nav_wallet:

                        mNavController.navigate(R.id.wallet, null, navOptions);

                        break;
                }

            }
        });


    }

    public static void hideNav(boolean hideStatus) {
        if (hideStatus) {
            binding.bottomNavBar.setVisibility(View.GONE);
        } else {
            binding.bottomNavBar.setVisibility(View.VISIBLE);

        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        hideNav(false);
        binding.bottomNavBar.setItemSelected(R.id.nav_home, true);
        mNavController.navigate(R.id.homeFragment, null, navOptions);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
}