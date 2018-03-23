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

public class PatientForgetPassword extends AppCompatActivity {

    @BindView(R.id.PatientForgetPasswordSubmit)
    Button PatientForgetPasswordSubmit;

    @BindView(R.id.PatientForgetPasswordHint)
    TextView PatientForgetPasswordHint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_forget_password);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.PatientForgetPasswordSubmit)
    void onClickPatientLogin(){
        PatientForgetPasswordHint.setText(getString(R.string.PatientForgetPasswordHint1));
        startActivity(PatientLogin.class," ");
    }


    private void startActivity(Class targetActivity,String data){
        Intent intent =new Intent(this,targetActivity);
        intent.putExtra("data",data);
        startActivity(intent);
    }
}
