package com.example.mac.swyhealthmonitoring.patient;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class PatientFamily extends AppCompatActivity {

    @BindView(R.id.PatientFamilyAddFamily)
    Button PatientFamilyAddFamily;

    @BindView(R.id.PatientFamilyHome)
    ImageButton PatientFamilyHome;

    @BindView(R.id.PatientFamilyHeart)
    ImageButton PatientFamilyHeart;

    @BindView(R.id.PatientFamilyAccount)
    ImageButton PatientFamilyAccount;

    @BindView(R.id.PatientFamilyFamily)
    ImageButton PatientFamilyFamily;

    @BindView(R.id.PatientFamilyIconLocation)
    ImageButton PatientFamilyIconLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_family);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.PatientFamilyAddFamily)
    void onClickPatientFamilyAddFamily(){
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(PatientFamily.this);
        View mView = getLayoutInflater().inflate(R.layout.patientaddfamily,null);

        final AutoCompleteTextView PatientFamilyAddFamilyText = (AutoCompleteTextView) mView.findViewById(R.id.PatientFamilyAddFamilyText);
        final Button PatientFamilyAddFamilyBotton = (Button) mView.findViewById(R.id.PatientFamilyAddFamilyBotton);


        PatientFamilyAddFamilyBotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PatientFamily.this,"Family has been adding",Toast.LENGTH_SHORT).show();
            }
        });
        mBuilder.setView(mView);
        AlertDialog dialog = mBuilder.create();
        dialog.show();
    }

    @OnClick(R.id.PatientFamilyFamily)
    void onClickPatientFamily(){
        startActivity(PatientFamily.class," ");
    }

    @OnClick(R.id.PatientFamilyIconLocation)
    void onClickPatientHospitalMap(){
        startActivity(PatientHospitalMap.class," ");
    }

    @OnClick(R.id.PatientFamilyAccount)
    void onClickPatientAccount(){
        startActivity(PatientAccount.class," ");
    }


    @OnClick(R.id.PatientFamilyHeart)
    void onClickPatientMyHealth(){
        startActivity(PatientMyHealth.class," ");
    }

    @OnClick(R.id.PatientFamilyHome)
    void onClickPatientHome(){
        startActivity(PatientHome.class," ");
    }


    private void startActivity(Class targetActivity,String data){
        Intent intent =new Intent(this,targetActivity);
        intent.putExtra("data",data);
        startActivity(intent);
    }


    }

