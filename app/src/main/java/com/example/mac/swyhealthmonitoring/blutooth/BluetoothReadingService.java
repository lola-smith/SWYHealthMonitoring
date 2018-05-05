package com.example.mac.swyhealthmonitoring.blutooth;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.mac.swyhealthmonitoring.MyApplication;

public class BluetoothReadingService extends Service{
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        boolean isTemp = intent.getBooleanExtra("temp",false);
        boolean isX = intent.getBooleanExtra("x",false);
        boolean isY = intent.getBooleanExtra("y",false);
        BluetoothDeviceConnection bluetoothDevice = ((MyApplication)getApplication()).getBlutoothConnection();
        if(isTemp){
            if(bluetoothDevice.isConnected()){
                bluetoothDevice.sendData("T");
                bluetoothDevice.addCallback("temp_service",(message)->{

                    bluetoothDevice.removeCallback("temp_service");
                });
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
