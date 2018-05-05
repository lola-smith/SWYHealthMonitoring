package com.example.mac.swyhealthmonitoring.blutooth;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

//Iam here !
//Connect your phone!
//done
public class BlutoothConnection extends AsyncTask<Void, String, Void> implements BluetoothDeviceConnection {

    private BluetoothSocket socket;
    private BluetoothDevice device;
    private OutputStream outputStream;
    private InputStream inputStream;
    private static final UUID MY_UUID = UUID.fromString("000001101-0000-1000-8000-00805f9b34fb");

    private Map<String, BluetoothCallback> callbackList = new HashMap<>();

    public BlutoothConnection(BluetoothDevice device) {
        this.device = device;
        try {
            socket = this.device.createRfcommSocketToServiceRecord(MY_UUID);
            socket.connect();
        } catch (IOException e) {
            this.cancel(true);
            e.printStackTrace();
        }
        this.execute();

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();


    }

    @Override
    protected Void doInBackground(Void... device) {

        try {
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(inputStream);
        while (socket.isConnected()) {
            if (scanner.hasNextLine())
                publishProgress(scanner.nextLine());
        }
        return null;
    }


    @Override
    public boolean isConnected() {
        if (socket == null)
            return false;
        return socket.isConnected();
    }

    public boolean sendData(String messageToSend) {
        if (socket.isConnected()) {
            try {
                outputStream.write(messageToSend.getBytes());
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

        }
        return false;
    }

    @Override
    public boolean disconnect() {
        if (socket.isConnected()) {
            try {
                socket.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return true;
        }
    }

    @Override
    public void addCallback(String key, BluetoothCallback callback) {
        if (!callbackList.containsKey(key))
            callbackList.put(key, callback);
    }

    @Override
    public void removeCallback(String key) {
        callbackList.remove(key);
    }


    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);

        for (BluetoothCallback callback : callbackList.values()) {
            callback.onIncomingData(values[0]);
        }
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
