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
import com.example.mac.swyhealthmonitoring.utils.ShareUtils;

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
        try {
            float heart = Float.valueOf(message);
            if(heart >100){
                PatientHeartReading.setText(message);
                String person1Number = getSharedPreferences("app",MODE_PRIVATE).getString("person1","01122266168");
                String person2Number = getSharedPreferences("app",MODE_PRIVATE).getString("person2","01122266168");
                String person3Number = getSharedPreferences("app",MODE_PRIVATE).getString("person3","01122266168");
                String msg = "high heart rate level";
                ShareUtils.shareToWhatsapp(this,person1Number,msg);
                ShareUtils.shareToWhatsapp(this,person2Number,msg);
                ShareUtils.shareToWhatsapp(this,person3Number,msg);
                PatientHeartReadingState.setText("UP Normal");
                PatientHeartReadingState.setTextColor(Color.RED);
            }

            if(heart < 60){
                PatientHeartReading.setText(message);
                String person1Number = getSharedPreferences("app",MODE_PRIVATE).getString("person1","01122266168");
                String person2Number = getSharedPreferences("app",MODE_PRIVATE).getString("person2","01122266168");
                String person3Number = getSharedPreferences("app",MODE_PRIVATE).getString("person3","01122266168");
                String msg = "low heart rate level ";
                ShareUtils.shareToWhatsapp(this,person1Number,msg);
                ShareUtils.shareToWhatsapp(this,person2Number,msg);
                ShareUtils.shareToWhatsapp(this,person3Number,msg);
                PatientHeartReadingState.setText("UP Normal");
                PatientHeartReadingState.setTextColor(Color.RED);
            }
            PatientHeartReading.setText(message);

            PatientHeartReadingState.setText("normal");
            PatientHeartReadingState.setTextColor(Color.GREEN);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    }



