package com.example.e_commerce;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;



public class login_activity extends AppCompatActivity {
    EditText editText1,editText2;
    Button button;
    TextView textView;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText1 = findViewById(R.id.edittxt1);
        editText2 = findViewById(R.id.edittxt2);
        textView = findViewById(R.id.txt1);
        button = findViewById(R.id.buton);
        String email = editText1.getText().toString();
        int password = editText2.getText().length();

        sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("email",email);
        editor.putInt("password",123456);
        editor.apply();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);




            }

        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),registration_activity.class);
                startActivity(intent);
            }
        });


        //  passdata:
//        Intent intent = new Intent();
//        intent.putExtra("email",email);
//        intent.putExtra("password",password);

    }
    //email validation
//    boolean isvalidemail(){
//        String emailpattern = "abc@gmail.com";
//        String email = editText1.getText().toString();
//        if (email.matches(emailpattern)){
//            return true;
//        }
//        return false;
//
//    }
    boolean isvalidpass(){
        String password = editText2.getText().toString();
        if (password.length()>5){
            return true;
        }
        return false;

    }

    }

