package com.example.mac.swyhealthmonitoring.patient;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
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

    @BindView(R.id.Person1Name)
    EditText Person1Name;

    @BindView(R.id.Person1Phone)
    EditText Person1Phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_family);
        ButterKnife.bind(this);
    }



    //This codes must be written at save button
    private void saveBtnClicked(){
        SharedPreferences.Editor editor = getSharedPreferences("app",MODE_PRIVATE).edit();

          editor.putString("person1",Person1Phone.getText().toString());
//        editor.putString("person2",phoneNumber);
//        editor.putString("person3",phoneNumber);
        editor.apply();

        Toast.makeText(this,"Your contacts saved successfully",Toast.LENGTH_SHORT).show();
    }


    @OnClick(R.id.PatientFamilyAddFamily)
    void onClickPatientFamilyAddFamily(){
        saveBtnClicked();
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

