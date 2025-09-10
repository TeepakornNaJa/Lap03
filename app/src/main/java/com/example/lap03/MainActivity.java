package com.example.lap03;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button addButton;
    Button browseButton;
    ProgressBar progressBar;
    


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addButton = findViewById(R.id.button);//event source
        addButton.setOnClickListener(new View.OnClickListener() {//event listener
            @Override
            public void onClick(View view) {//even handler
                System.out.println("Click Me");

                Intent activity2 = new Intent(getApplicationContext(), AddNoteactivity.class);
                startActivity(activity2);
            }

        });

        browseButton = findViewById(R.id.button4);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        browseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //step 1 show progress bar
                progressBar.setVisibility(View.VISIBLE);
                
                //step 2 create thread
                new Thread(() -> {
                    //2.1 delay 2 seconds
                    try {
                        Thread.sleep( 2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    
                    //2.2 load data from DB
                    
                    //2.3 back to main thread
                    runOnUiThread(() -> {
                        progressBar.setVisibility(View.GONE);
                        //2.4 go to browseNote
                        Intent browseNOteAct = new Intent(getApplicationContext(),BrowseNoteActivity.class);
                        startActivity(browseNOteAct);
                        finish();
                    });
                }).start();
                    
                
                System.out.println("Click Me");
                Intent activity2 = new Intent(getApplicationContext(), AddNoteactivity.class);
                startActivity(activity2);
            }

        });
    }
}








