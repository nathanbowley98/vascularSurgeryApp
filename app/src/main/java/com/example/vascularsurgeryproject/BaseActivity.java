package com.example.vascularsurgeryproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.vascularsurgeryproject.common.ScrollViewButtons;
import com.example.vascularsurgeryproject.fragments.AboutFragment;
import com.example.vascularsurgeryproject.fragments.HomeFragment;
import com.example.vascularsurgeryproject.fragments.SettingsFragment;
import com.example.vascularsurgeryproject.fragments.ShareFragment;
import com.google.android.material.navigation.NavigationView;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * BaseActivity Class that can be implemented and cherry picked by any page on the
 * Application.
 *
 */
public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    protected DrawerLayout drawerLayout;

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
        setSupportActionBar(toolbar);
        //toolbar.setNavigationIcon(R.drawable.ic_menu);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                toolbar,
                R.string.open_nav,
                R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //optionally do stuff with fragments here... see https://www.youtube.com/watch?v=6mgTJdy_di4&ab_channel=AndroidKnowledge

        // Find the buttons in the toolbar layout
        ImageButton btnMenu = findViewById(R.id.btn_menu);
        ImageButton btnUser = findViewById(R.id.btn_user);

        // Set a click listener for the left button
        btnMenu.setOnClickListener(v -> {
            // Show a toast message when the left button is pressed
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                drawerLayout.openDrawer(GravityCompat.START);
            }
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
            Toast.makeText(this, "Favorites view", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Favorites.class);
            startActivity(intent);
        });

        // Set a click listener for the right button
        btnShare.setOnClickListener(v -> {
            // Show a toast message when the right button is pressed
            Toast.makeText(this, "Right button pressed!", Toast.LENGTH_SHORT).show();
        });
    }

    /**
     * Gets the scrollview where buttons are going to be inserted
     *
     * @see res/layout/scrollview_layout.xml
     */
    protected <T extends Enum<T>> Map<String, Button> setupScrollView(Class<T> buttonNames) {
        Map<String, Button> buttonMapping = new HashMap<>();

        int layoutHeight = LinearLayout.LayoutParams.WRAP_CONTENT;
        int layoutWidth = LinearLayout.LayoutParams.MATCH_PARENT;
        float density = getResources().getDisplayMetrics().density;

        int hexBackgroundColor = Color.parseColor("#AE94E2");
        int hexTextColor = Color.parseColor("#FFFFFF");

        LinearLayout linearLayout = findViewById(R.id.scrollview_container);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(layoutWidth, layoutHeight);
        params.setMargins(0,0,0,(int) (10 * density));
        params.height = (int) (80 * density);

        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE);
        drawable.setCornerRadius(16 * density);
        drawable.setColor(hexBackgroundColor);

        for (Object value: Objects.requireNonNull(buttonNames.getEnumConstants())) {
            String buttonName = value.toString();
            Button button = new Button(this);

            //Setting test
            button.setText(buttonName);
            button.setTransformationMethod(null);

            int buttonId = View.generateViewId();
            button.setId(buttonId); // Assign the generated ID

            //Setting tag so we can call it
            String buttonTag = buttonName.replace(" ", "_");
            button.setTag(buttonTag);

            //Setting Color
            button.setBackgroundColor(hexBackgroundColor);
            button.setTextColor(hexTextColor);

            //Give rounded edge to match the design
            button.setBackground(drawable);

            buttonMapping.put(buttonTag, button);

            //Create the button
            button.setLayoutParams(params);
            linearLayout.addView(button);
        }

        return buttonMapping;
    }

    public void bindButtonListener (Button buttonObj, Intent intentObj) {
        buttonObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentObj);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu); // Highlighted: Inflating the search menu
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setQueryHint("Search...");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                onSearchQuerySubmit(query); // Highlighted: Search query submit callback
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                onSearchQueryChange(newText); // Highlighted: Search query change callback
                return true;
            }
        });
        return true;
    }

    // Highlighted: Method for handling query submission
    protected void onSearchQuerySubmit(String query) {
        // To be overridden in subclasses if needed
    }

    // Highlighted: Method for handling query text changes
    protected void onSearchQueryChange(String newText) {
        // To be overridden in subclasses if needed
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.nav_home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        } else if (itemId == R.id.nav_settings) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsFragment()).commit();
        } else if (itemId == R.id.nav_favorites) {
            startActivity(new Intent(BaseActivity.this, Favorites.class));
        } else if (itemId == R.id.nav_share) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ShareFragment()).commit();
        } else if (itemId == R.id.nav_about) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutFragment()).commit();
        } else if (itemId == R.id.nav_logout) {
            Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


}
