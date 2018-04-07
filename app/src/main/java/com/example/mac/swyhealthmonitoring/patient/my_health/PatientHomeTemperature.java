package com.example.mac.swyhealthmonitoring.patient.my_health;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mac.swyhealthmonitoring.MyApplication;
import com.example.mac.swyhealthmonitoring.R;
import com.example.mac.swyhealthmonitoring.blutooth.BluetoothCallback;
import com.example.mac.swyhealthmonitoring.blutooth.BluetoothDeviceConnection;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PatientHomeTemperature extends AppCompatActivity implements BluetoothCallback {
    @BindView(R.id.PatientHomeTempButton)
    Button PatientHomeTempButton;

    @BindView(R.id.PatientHomeTempHistory)
    TextView PatientHomeTempHistory;

    @BindView(R.id.PatientHomeTempSetting)
    TextView PatientHomeTempSetting;

    String reading;

    BluetoothDeviceConnection blutoothConnection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home_temperature);
        ButterKnife.bind(this);

        //Can i kill you :D
        //we sorry
        //do your senario again
        //it crash ag
        MyApplication app = (MyApplication)getApplication();
        if(app.getBlutoothConnection() != null){
            blutoothConnection = app.getBlutoothConnection();
            blutoothConnection.addCallback("TEMP",this);
        }
    }

    //is your phone is connected?!
    //yes
    //Make app crash
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(blutoothConnection != null){
            blutoothConnection.removeCallback("TEMP");
        }
    }
    //Do our senario again
    //ok
    //the app did not run

    @OnClick(R.id.PatientHomeTempButton)
    void onClickTempStartReading(){
        if(blutoothConnection.isConnected())
        {  blutoothConnection.sendData("T");}
        else
        {
            Toast.makeText(this,"Socket is not Connected",Toast.LENGTH_SHORT).show();
        }

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(PatientHomeTemperature.this);
        @SuppressLint("InflateParams") View mView = getLayoutInflater().inflate(R.layout.tempstartreading,null);

       final TextView PatientTempReading =  mView.findViewById(R.id.PatientTempReading);
        final Button PatientTempOK =  mView.findViewById(R.id.PatientTempOK);
        PatientTempReading.setText(reading);
        PatientTempOK.setOnClickListener(view -> Toast.makeText(PatientHomeTemperature.this,"Reading has been Saving",Toast.LENGTH_SHORT).show());
        mBuilder.setView(mView);
        AlertDialog dialog = mBuilder.create();
        dialog.show();
    }

    @OnClick(R.id.PatientHomeTempSetting)
    void onClickTempSetting(){
        startActivity(TempSetting.class);
    }

    @OnClick(R.id.PatientHomeTempHistory)
    void onClickTempHistory(){
        startActivity(TempHistory.class);
    }


    private void startActivity(Class targetActivity){
        Intent intent =new Intent(this,targetActivity);
        intent.putExtra("data", " ");
        startActivity(intent);
    }
    @Override
    public void onIncomingData(String message) {
        PatientHomeTempHistory.setText(message);
        reading=message;
    }
}
