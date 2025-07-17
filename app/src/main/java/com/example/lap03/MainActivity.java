package com.example.lap03;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
    }

    public static void main(String[] args) {
        Note note1 = new Note();
        Note note2 = new Note();
        Note note3 = new Note();

        User user1 = new User();
        User user2 = new User();
        User user3 = new User();

        note1.title = "Lap01";
        note1.context = "info Lap01";
        note1.createdDate= "17.07.2025";

        note2.title = "Lap02";
        note2.context = "info Lap02";
        note2.createdDate = "18.07.2025";

        note3.title = "Lap03";
        note3.context = "info Lap03";
        note3.createdDate = "19.07.2025";

        user1.gmail = "NongPlam@gmail.com";
        user1.password = "123321";
        user1.userName = "Palm";

        user2.gmail = "songsang@gmail.com";
        user2.password = "456654a";
        user2.userName = "EiEi";

        user3.gmail = "hghg41@gmail.com";
        user3.password = "789987p";
        user3.userName = "WuW";
    }
}