package com.example.pedla;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

import androidx.preference.CheckBoxPreference;
import androidx.preference.PreferenceManager;

public class Preference extends PreferenceActivity{
    @Override
    protected void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings);
    }

    private void load_setting(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);

        boolean check_night = sp.getBoolean("NIGHT", false);
        if(check_night){
            getListView().setBackgroundColor(Color.parseColor("#222222"));
        } else{
            getListView().setBackgroundColor(Color.parseColor("#ffffff"));
        }

//        CheckBoxPreference check_night_instant = (CheckBoxPreference)findPreference("NIGHT");

    }
}
