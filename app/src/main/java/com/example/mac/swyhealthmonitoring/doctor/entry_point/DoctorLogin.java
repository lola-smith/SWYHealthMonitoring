package com.example.mac.swyhealthmonitoring.doctor.entry_point;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.mac.swyhealthmonitoring.R;
import com.example.mac.swyhealthmonitoring.doctor.DoctorHome;
import com.example.mac.swyhealthmonitoring.doctor.entry_point.DoctorCreateAccount;
import com.example.mac.swyhealthmonitoring.doctor.entry_point.DoctorForgetPassword;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DoctorLogin extends AppCompatActivity {

    @BindView(R.id.DoctorLoginForgetPassword)
    TextView DoctorLoginForgetPassword;

    @BindView(R.id.DoctorLogincreataccount)
    TextView DoctorLogincreataccount;

    @BindView(R.id.DoctorLoginButtonLogin)
    Button  DoctorLoginButtonLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_login);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.DoctorLoginForgetPassword)
    void onClickDoctorForgetPassword(){
        startActivity(DoctorForgetPassword.class," ");
    }
    @OnClick(R.id.DoctorLogincreataccount)
    void onClickDoctorCreataccount(){
        startActivity(DoctorCreateAccount.class," ");
    }
    @OnClick(R.id.DoctorLoginButtonLogin)
    void onClickDoctorHome(){
        startActivity(DoctorHome.class," ");
    }

    private void startActivity(Class targetActivity,String data){
        Intent intent =new Intent(this,targetActivity);
        intent.putExtra("data",data);
        startActivity(intent);
    }
}
