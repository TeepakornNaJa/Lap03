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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BrowseNoteActivity extends AppCompatActivity {
    Button SearchButton;
    EditText editSearch;
    TextView textResult;
    ProgressBar progressBar;
    TextView showNote, showNoteFromAPI;

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

        showNote = findViewById(R.id.textView2);
        showNoteFromAPI = findViewById(R.id.textView3);

        Executors.newSingleThreadExecutor().execute(() -> {
            List<NoteEntity> entities = AppDatabase.getInstance(this).noteDao().getAll();
            List<TextNote> notes = new ArrayList<>();
            for (NoteEntity e : entities) {
                notes.add(NoteMapper.fromEntity(e));
            }
            runOnUiThread(() -> {
                StringBuilder sb = new StringBuilder();
                for (TextNote n : notes) {
                    sb.append(n.getSummary()).append("\n"); // ใช้ getSummary() แทน
                }
                showNote.setText(sb.toString());
            });
        });
        //load from API
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<TextNote>> call = apiService.getTextNote();

        call.enqueue(new Callback<List<TextNote>>() {
            @Override
            public void onResponse(Call<List<TextNote>> call, Response<List<TextNote>> response) {
                if (!response.isSuccessful()) {
                    showNoteFromAPI.setText("Error Code: " + response.code());
                    return;
                }

                List<TextNote> notes = response.body();
                StringBuilder builder = new StringBuilder();
                for (TextNote n : notes) {
                    builder.append("Title: ").append(n.getTitle()).append("\n")
                            .append("Body: ").append(n.getTextContent()).append("\n\n");
                }
                showNoteFromAPI.setText(builder.toString());
            }

            @Override
            public void onFailure(Call<List<TextNote>> call, Throwable t) {
                showNoteFromAPI.setText("Failed: " + t.getMessage());
            }
        });



    }

    public void startSearch() {

        textResult.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);


        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            // ซ่อน ProgressBar
            progressBar.setVisibility(View.GONE);


            textResult.setText("ไม่พบข้อมูล");
            textResult.setVisibility(View.VISIBLE);
        }, 2000);
    }

    private class list<T> {
    }
}
