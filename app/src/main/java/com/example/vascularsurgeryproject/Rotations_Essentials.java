package com.example.vascularsurgeryproject;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.vascularsurgeryproject.common.ScrollViewButtons;

import java.util.Map;

public class Rotations_Essentials extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotations_essentials);

        setupToolbar();
        Map<String, Button> buttonMapping = setupScrollView(ScrollViewButtons.RotationEssentialsButtons.class);
        setupBottomBar();
    }
}