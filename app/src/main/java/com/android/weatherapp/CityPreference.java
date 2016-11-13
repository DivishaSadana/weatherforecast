package com.android.weatherapp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by admin on 03-11-2016.
 */
public class CityPreference {

    SharedPreferences prefs;
    private String TAG=getClass().getSimpleName();

    public CityPreference(Activity activity){
        prefs = activity.getPreferences(Activity.MODE_PRIVATE);
    }
    String getCity (){
        Log.d(TAG, "getCity: "+prefs.getString("city", "Sydney, AU"));
        return prefs.getString("city", "Sydney, AU");

    }
    void setCity(String city){
        Log.d(TAG, "setCity: "+city);
        prefs.edit().putString("city", city).commit();
    }
}
