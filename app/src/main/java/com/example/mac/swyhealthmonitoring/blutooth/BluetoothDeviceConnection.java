package com.example.mac.swyhealthmonitoring.blutooth;

/**
 * Created by sondos on 30/03/18.
 */

public interface BluetoothDeviceConnection{
    boolean isConnected();
    boolean sendData(String messageToSend);
    boolean disconnect();
    void addCallback(String key ,BluetoothCallback callback);
    void removeCallback(String key);
}
