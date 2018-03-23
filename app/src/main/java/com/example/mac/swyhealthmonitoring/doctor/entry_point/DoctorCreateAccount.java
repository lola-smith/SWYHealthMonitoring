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

public class DoctorCreateAccount extends AppCompatActivity {

    @BindView(R.id.DoctorCreateAccountLogin)
    TextView DoctorCreateAccountLogin ;

    @BindView(R.id.DoctorCreateAccountNext)
    Button  DoctorCreateAccountNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_create_account);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.DoctorCreateAccountLogin)
    void onClickDoctorLogin(){
        startActivity(DoctorLogin.class," ");
    }



    @OnClick(R.id. DoctorCreateAccountNext)
    void  onClickDoctorCreateAccount2(){
        startActivity(DoctorCreateAccount2.class," ");
    }

    private void startActivity(Class targetActivity,String data){
        Intent intent =new Intent(this,targetActivity);
        intent.putExtra("data",data);
        startActivity(intent);
    }
}
