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
        boolean isgas = intent.getBooleanExtra("gas",false);
        boolean isheart = intent.getBooleanExtra("heart",false);
        BluetoothDeviceConnection bluetoothDevice = ((MyApplication)getApplication()).getBlutoothConnection();
        if(isTemp){
            if(bluetoothDevice.isConnected()){
                bluetoothDevice.sendData("T");
                bluetoothDevice.addCallback("temp_service",(message)->{

                    bluetoothDevice.removeCallback("temp_service");
                });
            }
        }

        if(isgas){
            if(bluetoothDevice.isConnected()){
                bluetoothDevice.sendData("G");
                bluetoothDevice.addCallback("gas_service",(message)->{

                    bluetoothDevice.removeCallback("gas_service");
                });
            }
        }


        if(isheart){
            if(bluetoothDevice.isConnected()){
                bluetoothDevice.sendData("H");
                bluetoothDevice.addCallback("heart_service",(message)->{

                    bluetoothDevice.removeCallback("heart_service");
                });
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
