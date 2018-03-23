package com.example.mac.swyhealthmonitoring.patient;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.mac.swyhealthmonitoring.R;
import com.example.mac.swyhealthmonitoring.patient.info.PatientAccount;
import com.example.mac.swyhealthmonitoring.patient.my_health.PatientMyHealth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
public class PatientVideoCall extends AppCompatActivity {


    @BindView(R.id.PatientVideoCallButton)
    Button PatientVideoCallButton;

    @BindView(R.id.PatientHomeHome)
    ImageButton PatientHomeHome;


    @BindView(R.id.PatientHomeAccount)
    ImageButton PatientHomeAccount;

    @BindView(R.id.PatientHomeIconLocation)
    ImageButton PatientHomeIconLocation;

    @BindView(R.id.PatientHomeHeart)
    ImageButton PatientHomeHeart;

    @BindView(R.id.PatientHomeFamily)
    ImageButton PatientHomeFamily;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_video_call);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.PatientHomeHome)
    void onClickPatientHome(){
        startActivity(PatientHome.class," ");
    }

    @OnClick(R.id.PatientHomeAccount)
    void onClickPatientAccount(){
        startActivity(PatientAccount.class," ");
    }

    @OnClick(R.id.PatientHomeIconLocation)
    void onClickPatientHospitalMap(){
        startActivity(PatientHospitalMap.class," ");
    }

    @OnClick(R.id.PatientHomeHeart)
    void onClickPatientMyHealth(){
        startActivity(PatientMyHealth.class," ");
    }

    @OnClick(R.id.PatientHomeFamily)
    void onClickPatientFamily(){
        startActivity(PatientFamily.class," ");
    }

    @OnClick(R.id.PatientVideoCallButton)
    void onClickPatientAddDoctor(){
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(PatientVideoCall.this);
        View mView = getLayoutInflater().inflate(R.layout.patientadddoctor,null);

        final AutoCompleteTextView PatientAddDoctorText = (AutoCompleteTextView) mView.findViewById(R.id.PatientAddDoctorText);
        final Button PatientAddDoctorBotton = (Button) mView.findViewById(R.id.PatientAddDoctorBotton);


        PatientAddDoctorBotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PatientVideoCall.this,"Doctor has been adding",Toast.LENGTH_SHORT).show();
            }
        });
        mBuilder.setView(mView);
        AlertDialog dialog = mBuilder.create();
        dialog.show();
    }



    private void startActivity(Class targetActivity,String data){
        Intent intent =new Intent(this,targetActivity);
        intent.putExtra("data",data);
        startActivity(intent);
    }

}
