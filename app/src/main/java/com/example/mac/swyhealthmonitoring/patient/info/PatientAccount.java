package com.example.mac.swyhealthmonitoring.patient.info;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mac.swyhealthmonitoring.R;
import com.example.mac.swyhealthmonitoring.patient.PatientFamily;
import com.example.mac.swyhealthmonitoring.patient.PatientHome;
import com.example.mac.swyhealthmonitoring.patient.PatientHospitalMap;
import com.example.mac.swyhealthmonitoring.patient.entry_point.PatientLogin;
import com.example.mac.swyhealthmonitoring.patient.my_health.PatientMyHealth;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PatientAccount extends AppCompatActivity {

    @BindView(R.id.PatientAccountHome)
    ImageButton PatientAccountHome;

    @BindView(R.id.PatientAccountAccount)
    ImageButton PatientAccountAccount;

    @BindView(R.id.PatientAccountIconLocation)
    ImageButton PatientAccountIconLocation;

    @BindView(R.id.PatientAccountFamily)
    ImageButton PatientAccountFamily;


    @BindView(R.id.PatientAccountHeart)
    ImageButton PatientAccountHeart;

    @BindView(R.id.PatientAccountPAtientInfoText)
    TextView PatientAccountPAtientInfoText;

    @BindView(R.id.PatientAccountPAtientEmailAndpassText)
    TextView PatientAccountPAtientEmailAndpassText;

    @BindView(R.id.PatientAccountCustomerSupportText)
    TextView PatientAccountCustomerSupportText;

    @BindView(R.id.PatientAccountAboutUsText)
    TextView PatientAccountAboutUsText;

    @BindView(R.id.PatientAccountLogout)
    TextView PatientAccountLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_account);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.PatientAccountHome)
    void onClickPatientHome(){
        startActivity(PatientHome.class," ");
    }

    @OnClick(R.id.PatientAccountAccount)
    void onClickPatientAccount(){
        startActivity(PatientAccount.class," ");
    }

    @OnClick(R.id.PatientAccountIconLocation)
    void onClickPatientHospitalMap(){
        startActivity(PatientHospitalMap.class," ");
    }


    @OnClick(R.id.PatientAccountFamily)
    void onClickPatientFamily(){
        startActivity(PatientFamily.class," ");
    }

    @OnClick(R.id.PatientAccountHeart)
    void onClickPatientMyHealth(){
        startActivity(PatientMyHealth.class," ");
    }


    @OnClick(R.id.PatientAccountPAtientInfoText)
    void onClickPatientAccountInformation(){
        startActivity(PatientAccountInformation.class," ");
    }


    @OnClick(R.id.PatientAccountPAtientEmailAndpassText)
    void onClickPatientAccountEmailAndPass(){
        startActivity(PatientAccountEmailAndPass.class," ");
    }

    @OnClick(R.id.PatientAccountCustomerSupportText)
    void onClickPatientSupport(){
        startActivity(PatientSupport.class," ");
    }

    @OnClick(R.id.PatientAccountAboutUsText)
    void onClickPatientAboutUs(){
        startActivity(PatientAboutUs.class," ");
    }

    @OnClick(R.id.PatientAccountLogout)
    void onClickPatientLogin(){
        FirebaseAuth.getInstance().signOut();
        finish();

        startActivity(PatientLogin.class," ");
    }


    private void startActivity(Class targetActivity,String data){
        Intent intent =new Intent(this,targetActivity);
        intent.putExtra("data",data);
        startActivity(intent);
    }

}
