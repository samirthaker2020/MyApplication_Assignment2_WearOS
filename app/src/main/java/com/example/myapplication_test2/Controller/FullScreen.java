package com.example.myapplication_test2.Controller;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.widget.TextView;

import com.example.myapplication_test2.R;

public class FullScreen extends WearableActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);


        // Enables Always-on
        setAmbientEnabled();
    }
}
