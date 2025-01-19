package com.example.vascularsurgeryproject;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.example.vascularsurgeryproject.rotationsEssentials.Article;

public class Rotations_Essentials extends AppCompatActivity {
    private final ArrayList<Article> ARTICLES = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rotations_essentials);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        try {
            populatePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void populatePage() throws IOException {
        // This is the main code of the function, it creates buttons and adds them
        // to the xml file. Currently, the data is stored in a csv but this can easily
        // be changed later on.
        InputStream inputStream = getResources().openRawResource(R.raw.dummy_data);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;

        try {
            GridLayout rootLayout = findViewById(R.id.articleButtons);

            // Iterates over data in csv file
            while ((line = reader.readLine()) != null) {
                createButton(line, rootLayout);
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("FileError", "Error reading file: ");
        }
    }

    private void createButton(String line, GridLayout rootLayout) {
        String[] values = line.split(",");
        // Since the CSV file has a space after the comma, we need the
        // substring method to remove that space, otherwise the url won't work
        Article article = new Article(values[0], values[2].substring(1));
        ARTICLES.add(article);

        // Create and add a button
        Button button = new Button(this);
        button.setText(article.getTitle());
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.width = GridLayout.LayoutParams.WRAP_CONTENT;
        params.height = GridLayout.LayoutParams.WRAP_CONTENT;
        params.setMargins(8, 8, 8, 8);
        // Set margins if needed
        // button.setLayoutParams(params);

        // Set an OnClickListener to open the URL
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = article.getUrl();

                if (!url.startsWith("http://") && !url.startsWith("https://")) {
                    url = "http://" + url;
                }

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "No application can handle this request. Please install a web browser.", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });

        rootLayout.addView(button);
    }
}
