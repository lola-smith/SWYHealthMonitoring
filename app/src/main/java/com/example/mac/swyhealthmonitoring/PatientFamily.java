package com.example.mac.swyhealthmonitoring;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class PatientFamily extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_family);

       final Button PatientFamilyAddFamily = (Button) findViewById(R.id.PatientFamilyAddFamily);
        final ImageButton PatientHomeHome = (ImageButton) findViewById(R.id.PatientHomeHome);
        final ImageButton PatientHomeHeart = (ImageButton) findViewById(R.id.PatientHomeHeart);
        final ImageButton PatientHomeAccount = (ImageButton) findViewById(R.id.PatientHomeAccount);
        final ImageButton PatientHomeFamily = (ImageButton) findViewById(R.id.PatientHomeFamily);
        final  ImageButton PatientHomeIconLocation = (ImageButton) findViewById(R.id.PatientHomeIconLocation);
        PatientHomeHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PatientFamily.this, PatientHome.class);
                startActivity(intent);
            }
        });
        PatientHomeHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PatientFamily.this, PatientMyHealth.class);
                startActivity(intent);

            }
        });
        PatientHomeAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PatientFamily.this, PatientAccount.class);
                startActivity(intent);
            }
        });

        PatientHomeIconLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PatientFamily.this, PatientHospitalMap.class);
                startActivity(intent);
            }
        });

        PatientHomeFamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PatientFamily.this, PatientFamily.class);
                startActivity(intent);

            }
        });
        PatientFamilyAddFamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
        });

    }


    }

