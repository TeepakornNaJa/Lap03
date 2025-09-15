package com.example.lap03;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.concurrent.Executors;

public class AddNoteactivity extends AppCompatActivity {

    Button addButton;
    EditText usernameInput, passwordInput;
    TextView display;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_noteactivity);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        // mapping
        addButton = findViewById(R.id.buttonAdd);
        usernameInput = findViewById(R.id.editTextUsername);
        passwordInput = findViewById(R.id.editTextPassword);
        display = findViewById(R.id.textViewDisplay);

        addButton.setOnClickListener(view -> {
            String strUsername = usernameInput.getText().toString();
            String strPassword = passwordInput.getText().toString();

            User user = new User(strUsername, strPassword);

            TextNote note = new TextNote();
            note.setOwner(user);

            display.setText(note.getSummary());

            NoteEntity entity = NoteMapper.toEntity(note);


            Context context = view.getContext();
            Executors.newSingleThreadExecutor().execute(() -> {
                AppDatabase.getInstance(context).noteDao().insert(entity);
            });

        });
    }
}
