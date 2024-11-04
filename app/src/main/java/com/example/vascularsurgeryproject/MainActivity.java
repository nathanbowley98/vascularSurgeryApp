package com.example.vascularsurgeryproject;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends BaseActivity {

    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the DrawerLayout and NavigationView
        NavigationView navView = findViewById(R.id.navView);
        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        // Find the toolbar and set it as the ActionBar
        setupToolbar();
        setupScrollView();
        setupBottomBar();

        // Initialize the ActionBarDrawerToggle and add it to the DrawerLayout
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Set up the navigation item selected listener
        navView.setNavigationItemSelectedListener(item -> {
            // Handle navigation item clicks
            if (item.getItemId() == R.id.settings) {
                Toast.makeText(getApplicationContext(), "Clicked Settings", Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.favorites) {
                Toast.makeText(getApplicationContext(), "Clicked Favorites", Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.logout) {
                Toast.makeText(getApplicationContext(), "Clicked Log Out", Toast.LENGTH_SHORT).show();
            } else {
                // handle unknown items if necessary
                return false;
            }
            // Close the drawer after selection
            drawerLayout.closeDrawers();
            return true;
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Check if the ActionBarDrawerToggle handles the selected menu item
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        // If not, let the superclass handle it
        return super.onOptionsItemSelected(item);
    }
}