package com.example.vascularsurgeryproject;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the toolbar and set it as the ActionBar
        setupToolbar();
        setupScrollView();
        setupBottomBar();
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