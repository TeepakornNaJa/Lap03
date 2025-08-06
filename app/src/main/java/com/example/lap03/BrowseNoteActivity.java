package com.example.lap03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BrowseNoteActivity extends AppCompatActivity {
    Button SearchButton;
    EditText editSearch;
    TextView textResult;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_browse_note);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editSearch = findViewById(R.id.editTextText3);
        textResult = findViewById(R.id.textView4);
        progressBar = findViewById(R.id.progressBar2);
        SearchButton = findViewById(R.id.button7);//event source
        SearchButton.setOnClickListener(v -> startSearch());

    }
    public void  startSearch() {
        //step 1 show progress bar
        progressBar.setVisibility(View.VISIBLE);

        //step 2 create thread
        new Thread(() -> {
            //2.1 delay 2 seconds
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //2.2 load data from DB

            //2.3 back to main thread
            runOnUiThread(() -> {
                progressBar.setVisibility(View.GONE);
                //2.4 go to browseNote
                textResult.setText("ไม่พบข้อมูล");
                textResult.setVisibility(View.VISIBLE);

            });
        }).start();
    }
}
