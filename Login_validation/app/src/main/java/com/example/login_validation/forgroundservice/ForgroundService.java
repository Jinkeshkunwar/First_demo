package com.example.login_validation.forgroundservice;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import com.example.login_validation.R;
import com.example.login_validation.Service;


public class ForgroundService extends AppCompatActivity {
    public static final String TAG=ForgroundService.class.getName();
    private EditText editTextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate() method called");
        setContentView(R.layout.activityforgroundservice);
        editTextInput = findViewById(R.id.edit_text_input);
    }

    public void startForgroundService(View v) {
        String input = editTextInput.getText().toString();

        Intent serviceIntent = new Intent(this,StartService.class);
        serviceIntent.putExtra("inputExtra", input);

        ContextCompat.startForegroundService(this, serviceIntent);
        Log.d(TAG,"startServices()  method called");
        Toast.makeText(this,"Foreground Services Started",Toast.LENGTH_LONG).show();
    }

    public void stopForgroundService(View v) {
        Intent serviceIntent = new Intent(this,StartService.class);
        stopService(serviceIntent);
        Log.d(TAG,"stopService() method called");
        Toast.makeText(this,"Foreground Services Stopped",Toast.LENGTH_LONG).show();

    }
    public void backButton(View view){
        finish();
        Log.d(TAG,"stop the foregroundServices Activity");
    }



}
