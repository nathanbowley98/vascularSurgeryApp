package com.example.vascularsurgeryproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends BaseActivity {
    private Button goPageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the toolbar and set it as the ActionBar
        setupToolbar();
        setupScrollView();
        setupBottomBar();

        goPageButton = findViewById(R.id.Rotations_Essentials);
        goPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Rotations_Essentials.class));
            }
        });

        goPageButton = findViewById(R.id.Anatomy);
        goPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Anatomy.class));
            }
        });

        goPageButton = findViewById(R.id.Physiology);
        goPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Physiology.class));
            }
        });

        goPageButton = findViewById(R.id.Pathophysiology);
        goPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Pathophysiology.class));
            }
        });

        goPageButton = findViewById(R.id.Clinical_Reference);
        goPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Clinical_Reference.class));
            }
        });

        goPageButton = findViewById(R.id.Diagnostics_and_Imaging);
        goPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Diagnostics_and_Imaging.class));
            }
        });
    }

    @Override
    protected void onSearchQuerySubmit(String query) {
        super.onSearchQuerySubmit(query);
        // Handle the search query submission specific to MainActivity
        Toast.makeText(this, "Search submitted: " + query, Toast.LENGTH_SHORT).show();
        // Add more logic here, such as filtering a list or updating UI
    }

    @Override
    protected void onSearchQueryChange(String newText) {
        super.onSearchQueryChange(newText);
        // Handle the live search query text change specific to MainActivity
        Toast.makeText(this, "Search text: " + newText, Toast.LENGTH_SHORT).show();
        // Add logic for live filtering or suggestions here
    }
}