package com.myAgeEducation.cbseClass4;

import android.os.Bundle;

//import PreferenceActivity;

public class SettingsActivity extends android.preference.PreferenceActivity {
	@SuppressWarnings("deprecation")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
