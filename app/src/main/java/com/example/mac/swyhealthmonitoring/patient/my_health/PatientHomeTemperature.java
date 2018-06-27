package com.example.mac.swyhealthmonitoring.patient.my_health;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mac.swyhealthmonitoring.MyApplication;
import com.example.mac.swyhealthmonitoring.R;
import com.example.mac.swyhealthmonitoring.blutooth.BluetoothCallback;
import com.example.mac.swyhealthmonitoring.blutooth.BluetoothDeviceConnection;
import com.example.mac.swyhealthmonitoring.utils.ShareUtils;

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

    @BindView(R.id.PatientTempReading)
    TextView PatientTempReading;

    @BindView(R.id.PatientTempReadingState)
    TextView PatientTempReadingState;


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
        MyApplication app = (MyApplication) getApplication();
        if (app.getBlutoothConnection() != null) {
            blutoothConnection = app.getBlutoothConnection();
            blutoothConnection.addCallback("TEMP", this);
        }
    }

    //is your phone is connected?!
    //yes
    //Make app crash
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (blutoothConnection != null) {
            blutoothConnection.removeCallback("TEMP");
        }
    }
    //Do our senario again
    //ok
    //the app did not run

    @OnClick(R.id.PatientHomeTempButton)
    void onClickTempStartReading() {
        if (blutoothConnection.isConnected()) {
            blutoothConnection.sendData("T");
        } else {
            Toast.makeText(this, "Socket is not Connected", Toast.LENGTH_SHORT).show();
        }


    }

    @OnClick(R.id.PatientHomeTempSetting)
    void onClickTempSetting() {
        startActivity(TempSetting.class);
    }

    @OnClick(R.id.PatientHomeTempHistory)
    void onClickTempHistory() {
        startActivity(TempHistory.class);
    }


    private void startActivity(Class targetActivity) {
        Intent intent = new Intent(this, targetActivity);
        intent.putExtra("data", " ");
        startActivity(intent);
    }

    @Override
    public void onIncomingData(String message) {
        try {
            float temp = Float.valueOf(message);
            if(temp >38 || temp <36){
                PatientTempReading.setText(message);

                PatientTempReadingState.setText("up normal");
                PatientTempReadingState.setTextColor(Color.RED);

                String person1Number = getSharedPreferences("app",MODE_PRIVATE).getString("person1","01122266168");
               // String person2Number = getSharedPreferences("app",MODE_PRIVATE).getString("person2","01122266168");
              //  String person3Number = getSharedPreferences("app",MODE_PRIVATE).getString("person3","01122266168");
                String msg = "Up Normal";
                ShareUtils.shareToWhatsapp(this,person1Number,msg);
              //  ShareUtils.shareToWhatsapp(this,person2Number,msg);
                //ShareUtils.shareToWhatsapp(this,person3Number,msg);
            }
            else{
            PatientTempReading.setText(message);

            PatientTempReadingState.setText("normal");
            PatientTempReadingState.setTextColor(Color.GREEN);}
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
