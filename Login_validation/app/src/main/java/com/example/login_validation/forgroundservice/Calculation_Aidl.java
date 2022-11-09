package com.example.login_validation.forgroundservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login_validation.IAidl_Service;
import com.example.login_validation.R;

public class Calculation_Aidl extends AppCompatActivity {
    public static final String TAG=Calculation_Aidl.class.getName();
    private EditText num1,num2;
    private TextView num3;
    int result;
    int value1;
    int value2;
    IAidl_Service MyAidlService;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate() method called");
        setContentView(R.layout.activity_calculation_aidl);
        num1=findViewById(R.id.textnumber1);
        num2=findViewById(R.id.textnumber2);
        num3=findViewById(R.id.textresulrt);
        Intent intent=new Intent(this,StartService.class);
        bindService(intent,mconnection, Context.BIND_AUTO_CREATE);
    }
    public void addtionButton(View v) throws RemoteException {
        Log.d(TAG,"addtionButton() clicked");
        value1=Integer.parseInt(num1.getText().toString());
        value2=Integer.parseInt(num2.getText().toString());
        result=MyAidlService.add(value1,value2);
        num3.setText(String.valueOf(result));

    }
    public void backToServices(View view){
        Log.d(TAG,"back button clicked ");
        finish();
    }
    public void multipButton(View v) throws RemoteException {
        Log.d(TAG,"multiplication Button clicked");
        value1=Integer.parseInt(num1.getText().toString());
        value2=Integer.parseInt(num2.getText().toString());
        result=MyAidlService.multi(value1,value2);
        num3.setText(String.valueOf(result));

    }
    private ServiceConnection mconnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder iBinder) {
            Log.d(TAG,"onServiceConnection() method called");
            MyAidlService = IAidl_Service.Stub.asInterface(iBinder);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

            Log.d(TAG,"onServicesDisconnected() method called");

        }
    };

}
