package com.example.mac.swyhealthmonitoring.patient.entry_point;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mac.swyhealthmonitoring.R;
import com.example.mac.swyhealthmonitoring.doctor.DoctorHome;
import com.example.mac.swyhealthmonitoring.patient.PatientHome;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PatientCreateAccount2 extends AppCompatActivity {
    @BindView(R.id.PatientCreateAccount2CreateAccount)
    Button PatientCreateAccount2CreateAccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_create_account2);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.PatientCreateAccount2CreateAccount)
    void onClickPatientHome(){
        startActivity(PatientHome.class," ");
    }

    private void startActivity(Class targetActivity,String data){
        Intent intent =new Intent(this,targetActivity);
        intent.putExtra("data",data);
        startActivity(intent);
    }
}
