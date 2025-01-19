package com.example.vascularsurgeryproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.vascularsurgeryproject.common.ScrollViewButtons;

import java.util.Map;

public class Rotations_Essentials extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotations_essentials);

        setupToolbar();
        Map<String, Button> buttonMapping = setupScrollView(ScrollViewButtons.RotationEssentialsButtons.class);
        setupBottomBar();

        for (Map.Entry<String, Button> entry: buttonMapping.entrySet()) {
            String buttonName = entry.getKey();
            Button buttonObj = entry.getValue();

            switch(buttonName) {
                case "ABI_Scores":
                    bindButtonListener(buttonObj, new Intent(Rotations_Essentials.this, ABI_Scores.class));
                break;
                case "Peripheral_Exam_B":
                    bindButtonListener(buttonObj, new Intent(Rotations_Essentials.this, Peripheral_Exam_B.class));
                break;
                case "Common_Blood_Work_Int":
                    bindButtonListener(buttonObj, new Intent(Rotations_Essentials.this, Common_Bloodwork.class));
                break;
            }
        }
    }
}