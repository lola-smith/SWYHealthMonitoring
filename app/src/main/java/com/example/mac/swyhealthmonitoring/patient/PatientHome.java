package com.example.mac.swyhealthmonitoring.patient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mac.swyhealthmonitoring.R;
import com.example.mac.swyhealthmonitoring.patient.info.PatientAccount;
import com.example.mac.swyhealthmonitoring.patient.my_health.PatientHomeHeartRate;
import com.example.mac.swyhealthmonitoring.patient.my_health.PatientHomePressure;
import com.example.mac.swyhealthmonitoring.patient.my_health.PatientHomeSuger;
import com.example.mac.swyhealthmonitoring.patient.my_health.PatientHomeTemperature;
import com.example.mac.swyhealthmonitoring.patient.my_health.PatientMyHealth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PatientHome extends AppCompatActivity {

    @BindView(R.id.PatientHomeVideoCall)
    Button PatientHomeVideoCall;

    @BindView(R.id.PatientHomeHome)
    ImageButton PatientHomeHome;

    @BindView(R.id.PatientHomeAccount)
    ImageButton PatientHomeAccount;

    @BindView(R.id.PatientHomeIconLocation)
    ImageButton PatientHomeIconLocation;

    @BindView(R.id.PatientHomeHeart)
    ImageButton PatientHomeHeart;

    @BindView(R.id.PatientHomeFamily)
    ImageButton PatientHomeFamily;

    @BindView(R.id.PatientHomeTempImage)
    ImageButton PatientHomeTempImage;

    @BindView(R.id.PatientHomeglocImage)
    ImageButton PatientHomeglocImage;

    @BindView(R.id.PatientHomeHeartImage)
    ImageButton PatientHomeHeartImage;

    @BindView(R.id.PatientHomePreImage)
    ImageButton PatientHomePreImage;

    @BindView(R.id.PatientHomeTempText)
    TextView PatientHomeTempText;

    @BindView(R.id.PatientHomeglocText)
    TextView PatientHomeglocText;

    @BindView(R.id.PatientHomeHeartText)
    TextView PatientHomeHeartText;

    @BindView(R.id.PatientHomePreText)
    TextView PatientHomePreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home);

        ButterKnife.bind(this);
        }

    @OnClick(R.id.PatientHomeHome)
    void onClickPatientHome(){
        startActivity(PatientHome.class," ");
    }


    @OnClick(R.id.PatientHomeAccount)
    void onClickPatientAccount(){
        startActivity(PatientAccount.class," ");
    }

    @OnClick(R.id.PatientHomeVideoCall)
    void onClickPatientVideoCall(){
        startActivity(PatientVideoCall.class," ");
    }

    @OnClick(R.id.PatientHomeIconLocation)
    void onClickPatientHospitalMap(){
        startActivity(PatientHospitalMap.class," ");
    }

    @OnClick(R.id.PatientHomeFamily)
    void onClickPatientFamily(){
        startActivity(PatientFamily.class," ");
    }

    @OnClick(R.id.PatientHomeHeart)
    void onClickPatientMyHealth(){
        startActivity(PatientMyHealth.class," ");
    }

    @OnClick(R.id.PatientHomeTempImage)
    void onClickPatientHomeTemperatureImg(){
        startActivity(PatientHomeTemperature.class," ");
    }

    @OnClick(R.id.PatientHomeglocImage)
    void onClickPatientHomeSugerImg(){
        startActivity(PatientHomeSuger.class," ");
    }

    @OnClick(R.id.PatientHomeHeartImage)
    void onClickPatientHomeHeartRateImg(){
        startActivity(PatientHomeHeartRate.class," ");
    }

    @OnClick(R.id.PatientHomePreImage)
    void onClickPatientHomePressureImg(){
        startActivity(PatientHomePressure.class," ");
    }

    @OnClick(R.id.PatientHomeTempText)
    void onClickPatientHomeTemperature(){
        startActivity(PatientHomeTemperature.class," ");
    }

    @OnClick(R.id.PatientHomeglocText)
    void onClickPatientHomeSuger(){
        startActivity(PatientHomeSuger.class," ");
    }

    @OnClick(R.id.PatientHomeHeartText)
    void onClickPatientHomeHeartRate(){
        startActivity(PatientHomeHeartRate.class," ");
    }

    @OnClick(R.id.PatientHomePreText)
    void onClickPatientHomePressure(){
        startActivity(PatientHomePressure.class," ");
    }


    private void startActivity(Class targetActivity,String data){
        Intent intent =new Intent(this,targetActivity);
        intent.putExtra("data",data);
        startActivity(intent);
    }

}
