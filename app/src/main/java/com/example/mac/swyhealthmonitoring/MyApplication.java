package com.example.mac.swyhealthmonitoring;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

import com.example.mac.swyhealthmonitoring.blutooth.BluetoothCallback;
import com.example.mac.swyhealthmonitoring.blutooth.BluetoothDeviceConnection;
import com.example.mac.swyhealthmonitoring.blutooth.BlutoothConnection;

import java.util.Set;

public class MyApplication extends Application {

  //  String DEVICE_ADDRESS = "00:21:13:00:5F:96";
    String DEVICE_NAME="HC-05";
    BluetoothAdapter bluetoothAdapter;
    BluetoothDeviceConnection blutoothConnection;
    @Override
    public void onCreate() {
        super.onCreate();

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(!bluetoothAdapter.isEnabled()){
            bluetoothAdapter.enable();
        }

        //Do you make a pair with your bt device ?
        //yes
        //You not make a pair with bt!
        Set<BluetoothDevice> devices = bluetoothAdapter.getBondedDevices();
        if(devices.size() ==0){
            blutoothConnection = new BluetoothDeviceConnection() {
                @Override
                public boolean isConnected() {
                    return false;
                }

                @Override
                public boolean sendData(String messageToSend) {
                    return false;
                }

                @Override
                public boolean disconnect() {
                    return false;
                }

                @Override
                public void addCallback(String key, BluetoothCallback callback) {
                }

                @Override
                public void removeCallback(String key) {
                }
            };
        }else {
            for (BluetoothDevice device : devices) {
                if (device.getName().equals(DEVICE_NAME)) {
                    blutoothConnection = new BlutoothConnection(device);
                    break;
                }
//            if(device.getAddress().equals(DEVICE_ADDRESS)){
//                blutoothConnection = new BlutoothConnection(device);
//                break;
//            }
            }
        }
    }

    public BluetoothDeviceConnection getBlutoothConnection(){
        return blutoothConnection;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        if(blutoothConnection != null)
            blutoothConnection.disconnect();
    }
}
