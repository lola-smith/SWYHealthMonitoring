package com.example.mac.swyhealthmonitoring.doctor.entry_point;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import com.example.mac.swyhealthmonitoring.R;
import com.example.mac.swyhealthmonitoring.doctor.DoctorHome;

public class DoctorCreateAccount2 extends AppCompatActivity {

    @BindView(R.id.DoctorCreateAccount2CreateAccount)
    Button DoctorCreateAccount2CreateAccount ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_create_account2);
        ButterKnife.bind(this);

    }

    @OnClick(R.id. DoctorCreateAccount2CreateAccount)
    void  onClickDoctorHome(){
        startActivity(DoctorHome.class," ");
    }

    private void startActivity(Class targetActivity,String data){
        Intent intent =new Intent(this,targetActivity);
        intent.putExtra("data",data);
        startActivity(intent);
    }
}
