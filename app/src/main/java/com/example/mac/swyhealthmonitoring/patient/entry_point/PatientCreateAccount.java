package com.example.mac.swyhealthmonitoring.patient.entry_point;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mac.swyhealthmonitoring.R;
import com.example.mac.swyhealthmonitoring.doctor.entry_point.DoctorLogin;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PatientCreateAccount extends AppCompatActivity {

    @BindView(R.id.PatientCreateAccountNext)
    Button PatientCreateAccountNext;

    @BindView(R.id.PatientCreateAccountLogin)
    TextView PatientCreateAccountLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_create_account);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.PatientCreateAccountLogin)
    void onClickPatientLogin(){
        startActivity(PatientLogin.class," ");
    }

    @OnClick(R.id.PatientCreateAccountNext)
    void onClickPatientCreateAccount2(){
        startActivity(PatientCreateAccount2.class," ");
    }

    private void startActivity(Class targetActivity,String data){
        Intent intent =new Intent(this,targetActivity);
        intent.putExtra("data",data);
        startActivity(intent);
    }
}
