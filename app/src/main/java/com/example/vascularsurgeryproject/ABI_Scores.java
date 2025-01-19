package com.example.vascularsurgeryproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.vascularsurgeryproject.common.ScrollViewButtons;

import java.util.Map;

public class ABI_Scores extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abi_scores);

        setupToolbar();
        setupBottomBar();
    }
}
