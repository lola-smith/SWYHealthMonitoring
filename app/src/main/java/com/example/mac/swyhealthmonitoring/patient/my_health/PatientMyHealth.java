package com.example.mac.swyhealthmonitoring.patient.my_health;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;

import com.example.mac.swyhealthmonitoring.R;
import com.example.mac.swyhealthmonitoring.patient.PatientFamily;
import com.example.mac.swyhealthmonitoring.patient.PatientHome;
import com.example.mac.swyhealthmonitoring.patient.PatientHospitalMap;
import com.example.mac.swyhealthmonitoring.patient.info.PatientAccount;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PatientMyHealth extends AppCompatActivity {

    @BindView(R.id.PatientMyHealthHome)
    ImageButton PatientMyHealthHome;

    @BindView(R.id.PatientMyHealthHeart)
    ImageButton PatientMyHealthHeart;

    @BindView(R.id.PatientMyHealthAccount)
    ImageButton PatientMyHealthAccount;

    @BindView(R.id.PatientMyHealthFamily)
    ImageButton PatientMyHealthFamily;

    @BindView(R.id.PatientMyHealthIconLocation)
    ImageButton PatientMyHealthIconLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_my_health);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.PatientMyHealthIconLocation)
    void onClickPatientHospitalMap(){
        startActivity(PatientHospitalMap.class," ");
    }

    @OnClick(R.id.PatientMyHealthFamily)
    void onClickPatientFamily(){
        startActivity(PatientFamily.class," ");
    }


    @OnClick(R.id.PatientMyHealthAccount)
    void onClickPatientAccount(){
        startActivity(PatientAccount.class," ");
    }


    @OnClick(R.id.PatientMyHealthHeart)
    void onClickPatientMyHealth(){
        startActivity(PatientMyHealth.class," ");
    }

    @OnClick(R.id.PatientMyHealthHome)
    void onClickPatientHome(){
        startActivity(PatientHome.class," ");
    }


    private void startActivity(Class targetActivity,String data){
        Intent intent =new Intent(this,targetActivity);
        intent.putExtra("data",data);
        startActivity(intent);
    }

}