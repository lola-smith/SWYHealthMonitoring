package com.example.mac.swyhealthmonitoring.patient.my_health;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.mac.swyhealthmonitoring.R;
import com.example.mac.swyhealthmonitoring.patient.info.PatientAccount;
import com.example.mac.swyhealthmonitoring.patient.PatientFamily;
import com.example.mac.swyhealthmonitoring.patient.PatientHome;
import com.example.mac.swyhealthmonitoring.patient.PatientHospitalMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PatientMyHealth extends AppCompatActivity {

    @BindView(R.id.PatientHomeHome)
    ImageButton PatientHomeHome;

    @BindView(R.id.PatientHomeHeart)
    ImageButton PatientHomeHeart;

    @BindView(R.id.PatientHomeAccount)
    ImageButton PatientHomeAccount;

    @BindView(R.id.PatientHomeFamily)
    ImageButton PatientHomeFamily;

    @BindView(R.id.PatientHomeIconLocation)
    ImageButton PatientHomeIconLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_my_health);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.PatientHomeIconLocation)
    void onClickPatientHospitalMap(){
        startActivity(PatientHospitalMap.class," ");
    }

    @OnClick(R.id.PatientHomeFamily)
    void onClickPatientFamily(){
        startActivity(PatientFamily.class," ");
    }


    @OnClick(R.id.PatientHomeAccount)
    void onClickPatientAccount(){
        startActivity(PatientAccount.class," ");
    }


    @OnClick(R.id.PatientHomeHeart)
    void onClickPatientMyHealth(){
        startActivity(PatientMyHealth.class," ");
    }

    @OnClick(R.id.PatientHomeHome)
    void onClickPatientHome(){
        startActivity(PatientHome.class," ");
    }


    private void startActivity(Class targetActivity,String data){
        Intent intent =new Intent(this,targetActivity);
        intent.putExtra("data",data);
        startActivity(intent);
    }

}

