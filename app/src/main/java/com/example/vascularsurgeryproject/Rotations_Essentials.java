package com.example.vascularsurgeryproject;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

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

//        populateArticles();
        createArticles();
    }

    private void populateArticles() {
//        This method will automate the creation of articles
//        Data will be read and its according button created and displayed
        
//        goPageButton = findViewById(R.id.Clinical_Reference);
//        goPageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(Rotations_Essentials.this, Clinical_Reference.class));
//            }
//        });
        loadData();
        createArticleButtons();
    }
    private void loadData() {
        String filePath = "com.example.vascularsurgeryproject.rotationsEssentials.dummyData.csv";
        String line = "";
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(csvSplitBy);
                System.out.println(Arrays.toString(values));
                ARTICLES.add(new Article(values[0], values[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createArticleButtons() {
        for (Article article: ARTICLES) {
//            Element Button
        }
    }

    public void createArticles() {
        File file = new File("rotationsEssentials/dummyData.csv");

        // The file can't be found - why?
        // Log.e displays text in the logcat tool (View -> Tool Windows -> Logcat)
        if (!file.exists()) {
            Log.e("FileError", "File does not exist");
        }

        // This is the main code of the function, it creates buttons and adds them
        // to the xml file. Currently, the data is stored in a csv but this can easily
        // be changed later on.
//        try {
//            BufferedReader br = new BufferedReader(new FileReader(file));
//            String line;
//            String csvSplitBy = ",";
//
//            LinearLayout rootLayout = findViewById(R.id.rootLayout);
//
//        Iterates over data in csv file
//            while ((line = br.readLine()) != null) {
//                String[] values = line.split(csvSplitBy);
//
//                // Create and add a button
//                Button button = new Button(this);
//                button.setLayoutParams(new LinearLayout.LayoutParams(
//                        LinearLayout.LayoutParams.WRAP_CONTENT,
//                        LinearLayout.LayoutParams.WRAP_CONTENT
//                ));
//                button.setText(values[0]); // The first value is the button title
//                rootLayout.addView(button);
//
//                Log.d("ButtonCreation", "Button created with text: " + values[0]);
//            }
//
//            br.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//            Log.e("FileError", "Error reading file: ");
//        }
    }
}
