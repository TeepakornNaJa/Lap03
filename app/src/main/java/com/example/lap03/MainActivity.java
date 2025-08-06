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
        TextNote textNote1 = new TextNote();
        textNote1.title = "Lap01";
        textNote1.context = "info Lap01";
        textNote1.createdDate= "17.07.2025";
        textNote1.getSummary();

        User user1 = new User();
        user1.Gmail = "NongPlam@gmail.com";
        user1.Password = "123321";
        user1.UserName = "Palm";
        user1.view_profile();

    }
}