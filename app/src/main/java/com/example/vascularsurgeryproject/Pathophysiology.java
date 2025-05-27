package com.example.vascularsurgeryproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.vascularsurgeryproject.common.ScrollViewButtons;

import java.util.Map;

public class Pathophysiology extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pathophysiology);

        LinearLayout buttonContainer = findViewById(R.id.mainPageButtons);
        LayoutInflater inflater = LayoutInflater.from(this);
        String[] btnNames = {"Aortic Dissection"};

        for (int i = 0; i < btnNames.length; i++) {
            // Inflate the subpage button layout
            View buttonLayout = inflater.inflate(R.layout.activity_subpage_button, buttonContainer, false);
            Button button = buttonLayout.findViewById(R.id.pageBtn);
            button.setText(btnNames[i]);

            switch(btnNames[i]) {
                case "Aortic Dissection":
                    bindButtonListener(button, new Intent(Pathophysiology.this, Aortic_Dissection.class));
                    break;
            }

            // Add to parent layout
            buttonContainer.addView(buttonLayout);
        }
    }
}
