package com.example.myapplication_test2.Controller;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.preference.SwitchPreference;

import androidx.fragment.app.FragmentActivity;
import androidx.wear.ambient.AmbientModeSupport;

import com.example.myapplication_test2.Modal.CircledImageViewPreference;
import com.example.myapplication_test2.Modal.ProgressBarPreference;
import com.example.myapplication_test2.R;

public class InLine extends FragmentActivity implements AmbientModeSupport.AmbientCallbackProvider {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_line);

        AmbientModeSupport.attach(this);

        getFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content, new ProgressFragment())
                .commit();
    }

        // Enables Always-on
        //setAmbientEnabled();
        public static class ProgressFragment extends PreferenceFragment {
            private SwitchPreference mDeterminantSwitchPref;
            private CircledImageViewPreference mCircledImageViewPref;
            private ProgressBarPreference mProgressBarPreference;
            private PreferenceScreen mPreferenceScreen;
            @SuppressLint("ResourceType")
            @Override
            public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                // Load the preferences from an XML resource
                addPreferencesFromResource(R.layout.prefs_in_line_progress);

                mDeterminantSwitchPref =
                        (SwitchPreference)
                                findPreference(getString(R.string.key_pref_determinant_switch));
                mDeterminantSwitchPref.setChecked(true);

                mCircledImageViewPref =
                        (CircledImageViewPreference)
                                findPreference(getString(R.string.key_pref_circled_image_view));

                mPreferenceScreen =
                        (PreferenceScreen) findPreference(getString(R.string.key_pref_progress_screen));

                mProgressBarPreference = new ProgressBarPreference(getContext());
                mProgressBarPreference.setTitle("@string/indeterminant_progress");

                mDeterminantSwitchPref.setOnPreferenceChangeListener(
                        new Preference.OnPreferenceChangeListener() {
                            @Override
                            public boolean onPreferenceChange(Preference preference, Object newValue) {
                                mDeterminantSwitchPref.setChecked(!mDeterminantSwitchPref.isChecked());
                                if (mDeterminantSwitchPref.isChecked()) {
                                    mCircledImageViewPref.cancelCountDownTimer();
                                    mCircledImageViewPref.setStartCircledImageView();
                                    mPreferenceScreen.removePreference(mProgressBarPreference);
                                    mPreferenceScreen.addPreference(mCircledImageViewPref);
                                } else {
                                    mPreferenceScreen.removePreference(mCircledImageViewPref);
                                    mPreferenceScreen.addPreference(mProgressBarPreference);
                                }
                                return true;
                            }
                        });
            }
    }




    @Override
    public AmbientModeSupport.AmbientCallback getAmbientCallback() {
        return null;
    }
}
