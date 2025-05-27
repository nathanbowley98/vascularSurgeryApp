package com.example.vascularsurgeryproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Aortic_Dissection extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aortic_dissection);

//        LinearLayout buttonContainer = findViewById(R.id.mainPageButtons);
//        LayoutInflater inflater = LayoutInflater.from(this);
//
//        for (int i = 0; i < 5; i++) {
//            // Inflate the subpage button layout
//            View buttonLayout = inflater.inflate(R.layout.activity_subpage_button, buttonContainer, false);
//
//            Button button = buttonLayout.findViewById(R.id.pageBtn);
//            bindButtonListener(button, new Intent(com.example.vascularsurgeryproject.Pathophysiology.this, .class));
//            button.setText("Button " + (i + 1));
//
//            // Add to parent layout
//            buttonContainer.addView(buttonLayout);
//        }
    }
}
