package com.example.login_validation;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.login_validation.boundedService.BoundService;
import com.example.login_validation.forgroundservice.Calculation_Aidl;
import com.example.login_validation.forgroundservice.ForgroundService;

public class Service extends AppCompatActivity {
    Button forground,aidl,back,bound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityservice);
        forground = findViewById(R.id.forground);
        aidl = findViewById(R.id.aidl);
        back = findViewById(R.id.back);
        bound = findViewById(R.id.bound);

        forground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Service.this, ForgroundService.class);
                startActivity(intent);
            }
        });
        bound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Service.this, BoundService.class);
                startActivity(intent);

            }
        });
        aidl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Service.this, Calculation_Aidl.class);
                startActivity(intent);

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Service.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
