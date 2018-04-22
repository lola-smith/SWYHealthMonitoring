package com.example.mac.swyhealthmonitoring.patient.my_health;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mac.swyhealthmonitoring.MyApplication;
import com.example.mac.swyhealthmonitoring.R;
import com.example.mac.swyhealthmonitoring.blutooth.BluetoothCallback;
import com.example.mac.swyhealthmonitoring.blutooth.BluetoothDeviceConnection;
import com.example.mac.swyhealthmonitoring.patient.info.PatientAskQuestion;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PatientHomeHeartRate extends AppCompatActivity implements BluetoothCallback {

    @BindView(R.id.PatientHomeHeartReatButton)
    Button PatientHomeHeartReatButton;

    @BindView(R.id.PatientHomeHeartRateSetting)
    TextView PatientHomeHeartRateSetting;

    @BindView(R.id.PatientHomeHeartRateHistory)
    TextView PatientHomeHeartRateHistory;

    @BindView(R.id.PatientHeartReading)
    TextView PatientHeartReading;

    @BindView(R.id.PatientHeartReadingState)
    TextView PatientHeartReadingState;

    BluetoothDeviceConnection blutoothConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home_heart_rate);
        ButterKnife.bind(this);

        MyApplication app = (MyApplication)getApplication();
        if(app.getBlutoothConnection() != null){
            blutoothConnection = app.getBlutoothConnection();
            blutoothConnection.addCallback("Heart",this);

    }}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(blutoothConnection != null){
            blutoothConnection.removeCallback("Heart");
        }
    }

    @OnClick(R.id.PatientHomeHeartReatButton)
    void onClickHeartStartReading(){

        if(blutoothConnection.isConnected())
        {  blutoothConnection.sendData("H");}
        else
        {
            Toast.makeText(this,"Socket is not Connected",Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.PatientHomeHeartRateSetting)
    void onClickHeartRateSetting(){
        startActivity(HeartRateSetting.class," ");
    }

    @OnClick(R.id.PatientHomeHeartRateHistory)
    void onClickHeartRateHistory(){
        startActivity(HeartRateHistory.class," ");
    }


    private void startActivity(Class targetActivity,String data){
        Intent intent =new Intent(this,targetActivity);
        intent.putExtra("data",data);
        startActivity(intent);
    }

    @Override
    public void onIncomingData(String message) {
        PatientHeartReading.setText(message);

        PatientHeartReadingState.setText("normal");
        PatientHeartReadingState.setTextColor(Color.GREEN);

    }

    }



