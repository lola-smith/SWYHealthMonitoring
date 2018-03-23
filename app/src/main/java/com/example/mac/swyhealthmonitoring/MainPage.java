package com.example.mac.swyhealthmonitoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mac.swyhealthmonitoring.doctor.entry_point.DoctorLogin;
import com.example.mac.swyhealthmonitoring.doctor.info.DoctorAskQuestion;
import com.example.mac.swyhealthmonitoring.patient.entry_point.PatientLogin;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainPage extends AppCompatActivity {

    @BindView(R.id.MainPatientButton)
    Button MainPatientButton;

    @BindView(R.id.MainDoctorButton)
    Button MainDoctorButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        ButterKnife.bind(this);

        Bt x = Bt.getInstance();

    }

    @OnClick(R.id.MainPatientButton)
    void onClickPatientLogin(){
        startActivity(PatientLogin.class," ");
    }

    @OnClick(R.id.MainDoctorButton)
    void onClickDoctorLogin(){
        startActivity(DoctorLogin.class," ");
    }

    private void startActivity(Class targetActivity,String data){
        Intent intent =new Intent(this,targetActivity);
        intent.putExtra("data",data);
        startActivity(intent);
    }
}
