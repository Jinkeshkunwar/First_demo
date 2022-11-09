package com.example.login_validation.boundedService;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.login_validation.R;

import java.util.Date;

public class BoundService extends AppCompatActivity {
    public static final String TAG=BoundService.class.getName();
    Button bindbtn,unbindbtn;
    static TextView textView;
    boolean bound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_service);
        Log.d(TAG,"onCreate() method called");
        /**
         * initializing the variables
         */
        textView=findViewById(R.id.date);
        bindbtn=findViewById(R.id.bindservices);
        unbindbtn=findViewById(R.id.unbindService);
        textView.setText("current date"+new Date());

        /**
         * bindServices button setting
         */
        bindbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(BoundService.this,MyService.class);
                bindService(intent,connection,BIND_AUTO_CREATE);
                Toast.makeText(BoundService.this,"BindServices started ",Toast.LENGTH_LONG).show();
                Log.d(TAG,"Binder Services Button clicked ");


            }
        });
        /**
         * unbindServices button setting
         */
        unbindbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bound) {
                    unbindService(connection);
                    bound=false;
                    Toast.makeText(BoundService.this, "BindServices ended ", Toast.LENGTH_LONG).show();
                    Log.d(TAG, "unBinder Services Button clicked ");
                }
            }
        });


    }
    public void backButton(View view) {
        /** Intent i = new Intent(this, StartServices.class);
         startActivity(i);*/
        finish();
        Log.d(TAG, "Back to services Activity");
    }
    private ServiceConnection connection= new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            bound=true;
            Log.d(TAG,"onServiceconnected called");

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            bound=false;
            Log.d(TAG,"onServiceDisconnected called");

        }
    };
}
