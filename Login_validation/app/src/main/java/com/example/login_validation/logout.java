package com.example.login_validation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login_validation.forgroundservice.StartService;

public class logout extends AppCompatActivity {
    TextView textViewA,textViewB,textViewC;
    Button btn1;
    Button start_service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitysecond);

        textViewA= findViewById(R.id.textview1);
        textViewB= findViewById(R.id.textView2);
        textViewC= findViewById(R.id.textView3);
        btn1 = findViewById(R.id.logout);
        start_service = findViewById(R.id.Start_Service);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(logout.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

        });
        start_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(logout.this, Service.class);
                startActivity(intent);

            }
        });
    }
}