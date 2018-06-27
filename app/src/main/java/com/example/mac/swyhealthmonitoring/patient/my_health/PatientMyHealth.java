package com.example.mac.swyhealthmonitoring.patient.my_health;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mac.swyhealthmonitoring.MyApplication;
import com.example.mac.swyhealthmonitoring.R;
import com.example.mac.swyhealthmonitoring.blutooth.BluetoothCallback;
import com.example.mac.swyhealthmonitoring.blutooth.BluetoothDeviceConnection;
import com.example.mac.swyhealthmonitoring.patient.PatientFamily;
import com.example.mac.swyhealthmonitoring.patient.PatientHome;
import com.example.mac.swyhealthmonitoring.patient.PatientHospitalMap;
import com.example.mac.swyhealthmonitoring.patient.info.PatientAccount;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PatientMyHealth extends AppCompatActivity {

    @BindView(R.id.PatientMyHealthTempReadText)
    TextView tempTxt;
    @BindView(R.id.PatientMyHealthGlucoseReadText)
    TextView glucoseTxt;
    @BindView(R.id.PatientMyHealthHeartRateReadText)
    TextView heartTxt;

    private BluetoothDeviceConnection bluetoothDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_my_health);
        ButterKnife.bind(this);

        bluetoothDevice = getBluetoothConnection();
    }

    private BluetoothDeviceConnection getBluetoothConnection() {
        return ((MyApplication) getApplication()).getBlutoothConnection();
    }

    @OnClick(R.id.PatientMyHealthIconLocation)
    void onClickPatientHospitalMap() {
        startActivity(PatientHospitalMap.class, " ");
    }

    @OnClick(R.id.PatientMyHealthFamily)
    void onClickPatientFamily() {
        startActivity(PatientFamily.class, " ");
    }


    @OnClick(R.id.PatientMyHealthAccount)
    void onClickPatientAccount() {
        startActivity(PatientAccount.class, " ");
    }


    @OnClick(R.id.PatientMyHealthHeart)
    void onClickPatientMyHealth() {
        startActivity(PatientMyHealth.class, " ");
    }

    @OnClick(R.id.PatientMyHealthHome)
    void onClickPatientHome() {
        startActivity(PatientHome.class, " ");
    }

    @OnClick(R.id.PatientMyHealthStartReading)
    void startReading() {
        if (bluetoothDevice.isConnected()) {
            bluetoothDevice.sendData("A");
            bluetoothDevice.addCallback("PatientMyHealth", message -> {
                //temp,heart,glucose
                try {
                    String[] readings = message.trim().split("&");
                    tempTxt.setText(readings[0]);
                    heartTxt.setText(readings[1]);

                    glucoseTxt.setText(readings[2]);
                } catch (Exception ex) {
                    Toast.makeText(this, "Please Check Your arduino code", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        bluetoothDevice.removeCallback("PatientMyHealth");
    }

    private void startActivity(Class targetActivity, String data) {
        Intent intent = new Intent(this, targetActivity);
        intent.putExtra("data", data);
        startActivity(intent);
    }

}