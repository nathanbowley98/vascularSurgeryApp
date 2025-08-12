package com.example.vascularsurgeryproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Rotations_Essentials extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotations_essentials);

        LinearLayout buttonContainer = findViewById(R.id.mainPageButtons);
        LayoutInflater inflater = LayoutInflater.from(this);
        String[] btnNames = {"ABI Scores", "Peripheral Exam B", "Common Blood Work Int"};

        for (String btnName : btnNames) {
            // Inflate the subpage button layout
            View buttonLayout = inflater.inflate(R.layout.activity_subpage_button, buttonContainer, false);
            Button button = buttonLayout.findViewById(R.id.pageBtn);
            button.setText(btnName);

            switch (btnName) {
                case "ABI Scores":
                    bindButtonListener(button, new Intent(Rotations_Essentials.this, ABI_Scores.class));
                    break;
                case "Peripheral Exam B":
                    bindButtonListener(button, new Intent(Rotations_Essentials.this, Peripheral_Exam_B.class));
                    break;
                case "Common Blood Work Int":
                    bindButtonListener(button, new Intent(Rotations_Essentials.this, Common_Bloodwork.class));
                    break;
            }

            // Add to parent layout
            buttonContainer.addView(buttonLayout);
        }
    }
}