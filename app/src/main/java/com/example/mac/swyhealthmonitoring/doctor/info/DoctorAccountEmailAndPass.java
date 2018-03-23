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

public class DoctorAccountEmailAndPass extends AppCompatActivity {

    @BindView(R.id.DoctorAccountEmailAndPassConfirmChange)
    Button DoctorAccountEmailAndPassConfirmChange;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_account_email_and_pass);
        ButterKnife.bind(this);

    }


    @OnClick(R.id.DoctorAccountEmailAndPassConfirmChange)
    void onClickDoctorAccount(){
        startActivity(DoctorAccount.class," ");
    }

    private void startActivity(Class targetActivity,String data){
        Intent intent =new Intent(this,targetActivity);
        intent.putExtra("data",data);
        startActivity(intent);
    }

}
