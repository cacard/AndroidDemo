/**
 * Setting Demo
 * 1 
 */

package com.cacard.androiddemo.activity.ui;

import com.cacard.androiddemo.R;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;


public class SettingDemo extends PreferenceActivity implements OnPreferenceChangeListener, OnPreferenceClickListener {

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        this.addPreferencesFromResource(R.xml.setting_demo);
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        return true;
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        return true;
    }

}
