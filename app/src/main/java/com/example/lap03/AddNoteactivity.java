package com.example.lap03;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddNoteactivity extends AppCompatActivity {

    Button BackButton;
    Button addButton;
    EditText titile,textContent;
    TextView display;
    EditText editName;

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


        BackButton = findViewById(R.id.button3);//event source
        BackButton.setOnClickListener(new View.OnClickListener() {//event listener
            @Override
            public void onClick(View view) {//even handler
                System.out.println("Click Me");

                Intent back = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(back);
            }
        });



        addButton = findViewById(R.id.button2);
        titile = findViewById(R.id.editTextName);
        textContent = findViewById(R.id.editText3);
        display = findViewById(R.id.textView2);
       editName = findViewById(R.id.editTextName);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("added");
                //get data from user (EditText)
                String strOfTitile  = titile.getText().toString();
                String strOfContent = textContent.getText().toString();
                //String strOfData = new Date().toString();
                String strOfName = editName.getText().toString();


                //set data to textNote class
                TextNote note1 = new TextNote();

                note1.setTitle(strOfTitile);

                note1.setTextContent(strOfContent);

//                note1.createdDate = strOfData;




                //show note on TextView
                display.setText(note1.getSummary());

            }

        });















    }


}