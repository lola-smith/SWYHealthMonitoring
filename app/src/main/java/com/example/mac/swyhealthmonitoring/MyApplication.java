package com.example.mac.swyhealthmonitoring;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.util.Log;

import com.example.mac.swyhealthmonitoring.blutooth.BluetoothCallback;
import com.example.mac.swyhealthmonitoring.blutooth.BluetoothDeviceConnection;
import com.example.mac.swyhealthmonitoring.blutooth.BlutoothConnection;
import com.example.mac.swyhealthmonitoring.database.DatabaseManager;
import com.example.mac.swyhealthmonitoring.entities.User;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class MyApplication extends Application {

  //  String DEVICE_ADDRESS = "00:21:13:00:5F:96";
    String DEVICE_NAME="HC-05";
    BluetoothAdapter bluetoothAdapter;
    BluetoothDeviceConnection blutoothConnection;
    @Override
    public void onCreate() {
        super.onCreate();

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        Set<BluetoothDevice> devices = null;
        if(bluetoothAdapter!=null) {
            if (!bluetoothAdapter.isEnabled()) {
                bluetoothAdapter.enable();
            }

            //Do you make a pair with your bt device ?
            //yes
            //You not make a pair with bt!
            devices = bluetoothAdapter.getBondedDevices();
        }
        if(devices== null){
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

//        User dummyUser = new User();
//
//        dummyUser.setEmail("test@test");
//        dummyUser.setBirthDate("20-11");
//        dummyUser.setGender("mail");
//        dummyUser.setPhoneNumber("010");
//        ArrayList<Integer> sugar = new ArrayList<>();
//        sugar.add(1);
//        sugar.add(2);
//        dummyUser.setSugar(sugar);
//
//        Map<String,String> family = new HashMap<>();
//        family.put("Eslam","010");
//        family.put("Ahmad","010");
//
//        dummyUser.setFamilyNameAndPhoneNumbers(family);
//        DatabaseManager.getInstance()
//                .insertUser(dummyUser)
//                .subscribeOn(Schedulers.io())
//        .subscribe(()-> Log.i("Eslam...","Data inserted"));
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
