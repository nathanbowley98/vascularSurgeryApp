package com.example.vascularsurgeryproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
}