package com.gulflamar.app.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.view.View;


import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import androidx.core.content.ContextCompat;

public class Constant {

    public static Constant constant = new Constant();


    public String GetLocationAddress(double lat, double lng, Context context) {
        Geocoder geocoder;
        List<Address> addresses;
        geocoder = new Geocoder(context, Locale.getDefault());

        try {
            addresses = geocoder.getFromLocation(lat, lng, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
            String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
            String localAddress = addresses.get(0).getSubLocality();
            String city = addresses.get(0).getLocality();
            String state = addresses.get(0).getAdminArea();
            String country = addresses.get(0).getCountryName();
            String postalCode = addresses.get(0).getPostalCode();
            String knownName = addresses.get(0).getFeatureName();

            return localAddress + "," + city;
            //binding.locationAddress.setText(address+","+city);

        } catch (IOException e) {

            e.printStackTrace();
            return e.getMessage();
        }

    }


    public void setError(View view, String data) {
        Snackbar.make(view, data, Snackbar.LENGTH_SHORT)
                .setBackgroundTint(Color.parseColor("#000000"))
                .setTextColor(Color.parseColor("#ffffff"))
                .show();
    }
}




