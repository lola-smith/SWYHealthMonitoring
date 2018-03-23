package com.example.mac.swyhealthmonitoring.doctor.info;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mac.swyhealthmonitoring.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DoctorSupport extends AppCompatActivity {

    @BindView(R.id.DoctorSupportAskQuestion)
    Button DoctorSupportAskQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_support);

        ButterKnife.bind(this);

    }
    @OnClick(R.id.DoctorSupportAskQuestion)
    void onClickDoctorAskQuestion(){
        startActivity(DoctorAskQuestion.class," ");
    }

    private void startActivity(Class targetActivity,String data){
        Intent intent =new Intent(this,targetActivity);
        intent.putExtra("data",data);
        startActivity(intent);
    }
}
