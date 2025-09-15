package com.example.lap03;

import android.os.Bundle;
import android.os.Handler; // เพิ่ม import นี้
import android.os.Looper;  // เพิ่ม import นี้
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

        // ซ่อน ProgressBar และ TextResult ในตอนเริ่มต้น
        progressBar.setVisibility(View.GONE);
        textResult.setVisibility(View.GONE);

        SearchButton.setOnClickListener(v -> startSearch());
    }

    public void startSearch() {
        // ซ่อนผลลัพธ์เก่า (ถ้ามี) และแสดง ProgressBar
        textResult.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        // ใช้ Handler เพื่อหน่วงเวลาการทำงาน
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            // ซ่อน ProgressBar
            progressBar.setVisibility(View.GONE);

            // แสดงข้อความ "ไม่พบข้อมูล"
            textResult.setText("ไม่พบข้อมูล"); // แก้ไขข้อความตรงนี้
            textResult.setVisibility(View.VISIBLE);
        }, 2000); // หน่วงเวลา 2000 มิลลิวินาที (2 วินาที)
    }
}
