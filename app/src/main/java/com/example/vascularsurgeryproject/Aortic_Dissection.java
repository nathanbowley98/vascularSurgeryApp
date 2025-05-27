package com.example.vascularsurgeryproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Aortic_Dissection extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aortic_dissection);

        try {
            populatePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void populatePage() throws IOException {
        // Reads the data in the txt file and displays them on the page
        InputStream inputStream = getResources().openRawResource(R.raw.aortic_dissection);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String contentTitle = "";
        StringBuilder content = new StringBuilder();
        String line;

        LinearLayout textContainer = findViewById(R.id.scrollview_container);
        LayoutInflater inflater = LayoutInflater.from(this);

        // Iterates over data in csv file
        while ((line = reader.readLine()) != null) {
            if (line.equals("<end>")) {
                // End of text section, create paragraph on page and reset variables
                View textBlockLayout = inflater.inflate(R.layout.activity_text_block, textContainer, false);

                // Add title
                TextView titleView = textBlockLayout.findViewById(R.id.title);
                titleView.setText(contentTitle);

                // Add content
                TextView contentView = textBlockLayout.findViewById(R.id.content);
                contentView.setText(content.toString());

                // Add to parent layout
                textContainer.addView(textBlockLayout);

                // Reset saved text
                contentTitle = "";
                content = new StringBuilder();
            } else if (content.toString().equals("<start>")) {
                // If this condition is met, then the last line was <start>, so now we are at
                // the title of a new text section
                contentTitle = line;
                content = new StringBuilder();
            } else {
                // In the middle of a text section, simply add the current line to our saved
                // content
                content.append(line);
            }
        }
    }
}
