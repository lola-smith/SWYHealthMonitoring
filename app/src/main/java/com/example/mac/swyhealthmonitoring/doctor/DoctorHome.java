package com.example.mac.swyhealthmonitoring.doctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mac.swyhealthmonitoring.R;
import com.example.mac.swyhealthmonitoring.doctor.entry_point.DoctorForgetPassword;
import com.example.mac.swyhealthmonitoring.doctor.info.DoctorAccount;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DoctorHome extends AppCompatActivity {


    @BindView(R.id.DoctorHomeHomeImage)
    ImageButton DoctorHomeHomeImage;

    @BindView(R.id.DoctorHomeAccountImage)
    ImageButton DoctorHomeAccountImage;

    @BindView(R.id.DoctorHomeStartVideo)
    Button DoctorHomeStartVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_home);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.DoctorHomeAccountImage)
    void onClickDoctorAccount(){
        startActivity(DoctorAccount.class," ");
    }

    @OnClick(R.id.DoctorHomeStartVideo)
    void onClickDoctorVideoCall(){
        startActivity(DoctorVideoCall.class," ");
    }

    @OnClick(R.id.DoctorHomeHomeImage)
    void onClickDoctorHome(){
        startActivity(DoctorHome.class," ");
    }

    private void startActivity(Class targetActivity,String data){
        Intent intent =new Intent(this,targetActivity);
        intent.putExtra("data",data);
        startActivity(intent);
    }
}
