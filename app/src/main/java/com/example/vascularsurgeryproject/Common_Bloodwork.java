package com.example.vascularsurgeryproject;

import android.os.Bundle;

public class Common_Bloodwork extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_bloodwork_int);

        setupToolbar();
        setupBottomBar();
    }
}
