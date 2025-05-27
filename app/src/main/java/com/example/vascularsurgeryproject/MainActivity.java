package com.example.vascularsurgeryproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

import com.example.vascularsurgeryproject.common.ScrollViewButtons;
import com.google.android.material.navigation.NavigationView;

import java.util.Map;

public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the toolbar and set it as the ActionBar
        setupToolbar();
        Map<String, Button> buttonMapping = setupScrollView(ScrollViewButtons.MainActivityButtons.class);
        setupBottomBar();

        // programatically binds the buttons
        for (Map.Entry<String, Button> entry: buttonMapping.entrySet()) {
            String buttonName = entry.getKey();
            Button buttonObj = entry.getValue();

            switch(buttonName) {
                case "Rotations_Essentials":
                    bindButtonListener(buttonObj, new Intent(MainActivity.this, Rotations_Essentials.class));
                    break;
                case "Anatomy":
                    bindButtonListener(buttonObj, new Intent(MainActivity.this, Anatomy.class));
                    break;
                case "Physiology":
                    bindButtonListener(buttonObj, new Intent(MainActivity.this, Physiology.class));
                    break;
                case "Pathophysiology":
                    bindButtonListener(buttonObj, new Intent(MainActivity.this, Pathophysiology.class));
                    break;
                case "Clinical_Reference":
                    bindButtonListener(buttonObj, new Intent(MainActivity.this, Clinical_Reference.class));
                    break;
                case "Diagnostics_and_Imaging":
                    bindButtonListener(buttonObj, new Intent(MainActivity.this, Diagnostics_and_Imaging.class));
                    break;
                case "Exam_and_Skills":
                    bindButtonListener(buttonObj, new Intent(MainActivity.this, Exam_and_Skills.class));
                    break;
                case "3D_Anatomy_Viewer":
                    bindButtonListener(buttonObj, new Intent(MainActivity.this, Anatomy_Viewer.class));
                    break;
                case "New_in_Vascular_Surgery":
                    bindButtonListener(buttonObj, new Intent(MainActivity.this, New_in_Vascular_Surgery.class));
                    break;
            }
        }
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