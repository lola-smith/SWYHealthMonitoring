package com.example.mac.swyhealthmonitoring.patient.info;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.mac.swyhealthmonitoring.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PatientSupport extends AppCompatActivity {

    @BindView(R.id.PatientSupportAskQuestion)
    Button PatientSupportAskQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_support);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.PatientSupportAskQuestion)
    void onClickPatientAskQuestion(){
        startActivity(PatientAskQuestion.class," ");
    }


    private void startActivity(Class targetActivity,String data){
        Intent intent =new Intent(this,targetActivity);
        intent.putExtra("data",data);
        startActivity(intent);
    }
}
