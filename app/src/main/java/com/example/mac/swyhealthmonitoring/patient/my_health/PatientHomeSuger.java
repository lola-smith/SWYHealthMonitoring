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


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PatientHomeSuger extends AppCompatActivity implements BluetoothCallback {

    @BindView(R.id.PatientHomeSugerButton)
    Button PatientHomeSugerButton;

    @BindView(R.id.PatientHomeSugerSetting)
    TextView PatientHomeSugerSetting;

    @BindView(R.id.PatientHomeSugerHistory)
    TextView PatientHomeSugerHistory;

    @BindView(R.id.PatientSugerReading)
    TextView PatientSugerReading;

    @BindView(R.id.PatientSugerReadingState)
    TextView PatientSugerReadingState;

    BluetoothDeviceConnection blutoothConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home_suger);
        ButterKnife.bind(this);

        MyApplication app = (MyApplication)getApplication();
       if(app.getBlutoothConnection() != null){
           blutoothConnection = app.getBlutoothConnection();
            blutoothConnection.addCallback("Suger",this);
   }
}

       @Override
       protected void onDestroy() {
            super.onDestroy();
            if(blutoothConnection != null){
                blutoothConnection.removeCallback("Suger");
           }
       }

   @OnClick(R.id.PatientHomeSugerButton)
   void onClickSugerStartReading(){
       if(blutoothConnection.isConnected())
       {  blutoothConnection.sendData("G");}
      else
       {
          Toast.makeText(this,"Socket is not Connected",Toast.LENGTH_SHORT).show();
        }


    }

    @OnClick(R.id.PatientHomeSugerSetting)
    void onClickSugerSetting(){
        startActivity(SugerSetting.class," ");
    }

    @OnClick(R.id.PatientHomeSugerHistory)
    void onClickSugerHistory(){
        startActivity(SugerHistory.class," ");
    }


    private void startActivity(Class targetActivity,String data){
        Intent intent =new Intent(this,targetActivity);
        intent.putExtra("data",data);
        startActivity(intent);
    }

    @Override
   public void onIncomingData(String message) {
       PatientSugerReading.setText(message);

       PatientSugerReadingState.setText("normal");
        PatientSugerReadingState.setTextColor(Color.GREEN);

    }


}

