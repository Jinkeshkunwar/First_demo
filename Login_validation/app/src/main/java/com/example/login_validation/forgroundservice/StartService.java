package com.example.login_validation.forgroundservice;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.example.login_validation.IAidl_Service;
import com.example.login_validation.R;


import static com.example.login_validation.App.CHANNEL_ID;

public class StartService extends Service {
    public static final String TAG=StartService.class.getName();
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate() method called");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"onStartCommand() method called");

        String input = intent.getStringExtra("inputExtra");

        Intent notificationIntent = new Intent(this, ForgroundService.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                0, notificationIntent,PendingIntent.FLAG_IMMUTABLE);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Example Service")
                .setContentText(input)
                .setSmallIcon(R.drawable.ic_bas)
                .setContentIntent(pendingIntent)
                .build();

        startForeground(1, notification);
        Log.d(TAG,"startForeground() method called");
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy() method called");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        Log.d(TAG,"onBind() method return the ibinder object");
        return ibinder;
    }

    IAidl_Service.Stub ibinder= new IAidl_Service.Stub() {
        @Override
        public int add(int x, int y) throws RemoteException {
            Log.d(TAG,"add() method executed");
            return x+y;
        }

        @Override
        public int multi(int x, int y) throws RemoteException {
            Log.d(TAG,"multi() method executed");
            return x*y;
        }
    };
}
