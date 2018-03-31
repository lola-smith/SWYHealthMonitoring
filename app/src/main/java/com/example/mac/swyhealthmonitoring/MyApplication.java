package com.example.mac.swyhealthmonitoring;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

import com.example.mac.swyhealthmonitoring.blutooth.BluetoothDeviceConnection;
import com.example.mac.swyhealthmonitoring.blutooth.BlutoothConnection;

import java.util.Set;

/**
 * Created by sondos on 30/03/18.
 */

public class MyApplication extends Application {

    String DEVICE_ADDRESS = "";
    String DEVICE_NAME="";
    BluetoothAdapter bluetoothAdapter;
    BlutoothConnection blutoothConnection;
    @Override
    public void onCreate() {
        super.onCreate();

        if(!bluetoothAdapter.isEnabled()){
            bluetoothAdapter.enable();
        }

        Set<BluetoothDevice> devices = bluetoothAdapter.getBondedDevices();
        for (BluetoothDevice device : devices){
//            if(device.getName().equals(DEVICE_NAME)){
//
//            }
            if(device.getAddress().equals(DEVICE_ADDRESS)){
                blutoothConnection = new BlutoothConnection(device);
                break;
            }
        }
    }

    public BluetoothDeviceConnection getBlutoothConnection(){
        return blutoothConnection;
    }
}
