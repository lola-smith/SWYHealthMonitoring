package com.example.mac.swyhealthmonitoring;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

import com.example.mac.swyhealthmonitoring.blutooth.BluetoothDeviceConnection;
import com.example.mac.swyhealthmonitoring.blutooth.BlutoothConnection;

import java.util.Set;

public class MyApplication extends Application {

  //  String DEVICE_ADDRESS = "00:21:13:00:5F:96";
    String DEVICE_NAME="HC-05";
    BluetoothAdapter bluetoothAdapter;
    BlutoothConnection blutoothConnection;
    @Override
    public void onCreate() {
        super.onCreate();

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(!bluetoothAdapter.isEnabled()){
            bluetoothAdapter.enable();
        }

        Set<BluetoothDevice> devices = bluetoothAdapter.getBondedDevices();
        for (BluetoothDevice device : devices){
            if(device.getName().equals(DEVICE_NAME)){
                blutoothConnection = new BlutoothConnection(device);
                break;
            }
//            if(device.getAddress().equals(DEVICE_ADDRESS)){
//                blutoothConnection = new BlutoothConnection(device);
//                break;
//            }
        }
    }

    public BluetoothDeviceConnection getBlutoothConnection(){
        return blutoothConnection;
    }
}
