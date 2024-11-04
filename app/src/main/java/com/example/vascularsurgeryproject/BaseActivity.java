package com.example.vascularsurgeryproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Objects;

/**
 * BaseActivity Class that can be implemented and cherry picked by any page on the
 * Application.
 *
 */
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

    // Creates the bottom app bar
    protected void setupBottomBar() {
        Toolbar toolbar = findViewById(R.id.bottom_bar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        }

        // Find the buttons in the toolbar layout
        ImageButton btnBack = findViewById(R.id.btn_back);
        ImageButton btnStar = findViewById(R.id.btn_star);
        ImageButton btnShare = findViewById(R.id.btn_share);

        // Set a click listener for the left button
        btnBack.setOnClickListener(v -> {
            // Show a toast message when the left button is pressed
            Toast.makeText(this, "Left button pressed!", Toast.LENGTH_SHORT).show();
        });

        // Set a click listener for the middle button
        btnStar.setOnClickListener(v -> {
            // Show a toast message when the middle button is pressed
            Toast.makeText(this, "Middle button pressed!", Toast.LENGTH_SHORT).show();
        });

        // Set a click listener for the right button
        btnShare.setOnClickListener(v -> {
            // Show a toast message when the right button is pressed
            Toast.makeText(this, "Right button pressed!", Toast.LENGTH_SHORT).show();
        });
    }

    /**
     * Gets the scrollview where buttons are going to be inserted
     * Remove the placeholder buttons in scrollview_layout.xml,
     * make sure you are in code mode not design!
     * @see res/layout/scrollview_layout.xml
     */
    protected void setupScrollView() {
        LinearLayout linearLayout = findViewById(R.id.scrollview_container);
        //linearlayout container which is the container inside
        //scrollview and holds the buttons
    }
}

