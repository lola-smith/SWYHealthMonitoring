package com.example.mac.swyhealthmonitoring.doctor.info;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.mac.swyhealthmonitoring.R;
import com.example.mac.swyhealthmonitoring.doctor.DoctorHome;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DoctorAccountInfo extends AppCompatActivity {

    @BindView(R.id.DoctorAccountInfoConfirm)
    Button DoctorAccountInfoConfirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_account_info);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.DoctorAccountInfoConfirm)
    void onClickDoctorAccount(){
        startActivity(DoctorAccount.class," ");
    }

    private void startActivity(Class targetActivity,String data){
        Intent intent =new Intent(this,targetActivity);
        intent.putExtra("data",data);
        startActivity(intent);
    }


}
