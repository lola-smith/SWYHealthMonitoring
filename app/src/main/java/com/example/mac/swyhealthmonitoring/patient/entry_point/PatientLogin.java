package com.example.mac.swyhealthmonitoring.patient.entry_point;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mac.swyhealthmonitoring.R;
import com.example.mac.swyhealthmonitoring.patient.PatientHome;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class PatientLogin extends AppCompatActivity {

    @BindView(R.id.PatientLoginButtonLogin)
    Button PatientLoginButtonLogin;

    @BindView(R.id.PatientLogincreataccount)
    TextView PatientLogincreataccount;

    @BindView(R.id.PatientLoginForgetPassword)
    TextView PatientLoginForgetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_login);
        ButterKnife.bind(this);

    }


    @OnClick(R.id.PatientLoginButtonLogin)
    void onClickPatientHome(){
        startActivity(PatientHome.class," ");
    }

    @OnClick(R.id.PatientLoginForgetPassword)
    void onClickPatientForgetPassword(){
        startActivity(PatientForgetPassword.class," ");
    }

    @OnClick(R.id.PatientLogincreataccount)
    void onClickPatientCreateAccount(){
        startActivity(PatientCreateAccount.class," ");
    }


    private void startActivity(Class targetActivity,String data){
        Intent intent =new Intent(this,targetActivity);
        intent.putExtra("data",data);
        startActivity(intent);
    }
}
