package com.example.e_commerce;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class registration_activity extends AppCompatActivity {
    EditText editText1,editText2,editText3;
    Button button;
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        editText1 = findViewById(R.id.edittxt11);
        editText2 = findViewById(R.id.edittxt12);
        editText3 = findViewById(R.id.edittxt13);
        textView1 = findViewById(R.id.txt2);
        button =findViewById(R.id.buton1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),login_activity.class);
                startActivity(intent);
            }
        });

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),login_activity.class);
                startActivity(intent);
            }
        });


    }
}