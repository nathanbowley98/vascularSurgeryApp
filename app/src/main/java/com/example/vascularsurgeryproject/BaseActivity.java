package com.example.vascularsurgeryproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Objects;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.vascular_toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        }

        // Find the buttons in the toolbar layout
        ImageButton btnMenu = findViewById(R.id.btn_menu);
        ImageButton btnUser = findViewById(R.id.btn_user);

        // Set a click listener for the left button
        btnMenu.setOnClickListener(v -> {
            // Show a toast message when the left button is pressed
            Toast.makeText(this, "Left button pressed!", Toast.LENGTH_SHORT).show();
        });

        // Set a click listener for the right button
        btnUser.setOnClickListener(v -> {
            // Show a toast message when the right button is pressed
            Toast.makeText(this, "Right button pressed!", Toast.LENGTH_SHORT).show();
        });
    }
}

