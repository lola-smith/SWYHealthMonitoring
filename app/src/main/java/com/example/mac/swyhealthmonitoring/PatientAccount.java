package com.example.mac.swyhealthmonitoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class PatientAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_account);
        final ImageButton PatientAccountHome = (ImageButton) findViewById(R.id.PatientAccountHome);
        final ImageButton PatientAccountAccount = (ImageButton) findViewById(R.id.PatientAccountAccount);
        final ImageButton PatientAccountIconLocation =(ImageButton) findViewById(R.id.PatientAccountIconLocation);
        final  ImageButton PatientAccountFamily =(ImageButton) findViewById(R.id.PatientAccountFamily);
        final ImageButton PatientAccountHeart =(ImageButton) findViewById(R.id.PatientAccountHeart);
        final TextView PatientAccountPAtientInfoText =(TextView) findViewById(R.id.PatientAccountPAtientInfoText);
        final  TextView PatientAccountPAtientEmailAndpassText =(TextView) findViewById(R.id.PatientAccountPAtientEmailAndpassText);
        final  TextView PatientAccountCustomerSupportText =(TextView) findViewById(R.id.PatientAccountCustomerSupportText);
        final TextView PatientAccountAboutUsText =(TextView) findViewById(R.id.PatientAccountAboutUsText);
        final TextView PatientAccountLogout =(TextView) findViewById(R.id.PatientAccountLogout);
        PatientAccountHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientAccount.this,PatientHome.class);
                startActivity(intent);
            }
        });
        PatientAccountAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientAccount.this,PatientAccount.class);
                startActivity(intent);
            }
        });

        PatientAccountIconLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientAccount.this,PatientHospitalMap.class);
                startActivity(intent);
            }
        });
        PatientAccountFamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientAccount.this,PatientFamily.class);
                startActivity(intent);
            }
        });

        PatientAccountHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientAccount.this,PatientMyHealth.class);
                startActivity(intent);
            }
        });

        PatientAccountPAtientInfoText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientAccount.this,PatientAccountInformation.class);
                startActivity(intent);
            }
        });
        PatientAccountPAtientEmailAndpassText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientAccount.this,PatientAccountEmailAndPass.class);
                startActivity(intent);
            }
        });
        PatientAccountCustomerSupportText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientAccount.this,PatientSupport.class);
                startActivity(intent);
            }
        });

        PatientAccountAboutUsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientAccount.this,PatientAboutUs.class);
                startActivity(intent);
            }
        });

        PatientAccountLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientAccount.this,PatientLogin.class);
                startActivity(intent);
            }
        });
    }
}
