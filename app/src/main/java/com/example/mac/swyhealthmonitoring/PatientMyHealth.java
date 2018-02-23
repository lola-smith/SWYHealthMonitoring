package com.example.mac.swyhealthmonitoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PatientMyHealth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_my_health);
        final ImageButton PatientHomeHome = (ImageButton) findViewById(R.id.PatientHomeHome);
        final ImageButton PatientHomeHeart =(ImageButton) findViewById(R.id.PatientHomeHeart);
        final ImageButton PatientHomeAccount =(ImageButton) findViewById(R.id.PatientHomeAccount);
        final ImageButton PatientHomeFamily =(ImageButton) findViewById(R.id.PatientHomeFamily);
        final ImageButton PatientHomeIconLocation =(ImageButton) findViewById(R.id.PatientHomeIconLocation);
        PatientHomeHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientMyHealth.this,PatientHome.class);
                startActivity(intent);
            }
        });
        PatientHomeHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientMyHealth.this,PatientMyHealth.class);
                startActivity(intent);

            }
        });
        PatientHomeAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientMyHealth.this,PatientAccount.class);
                startActivity(intent);
            }
        });

        PatientHomeFamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientMyHealth.this,PatientFamily.class);
                startActivity(intent);

            }
        });

        PatientHomeIconLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientMyHealth.this,PatientHospitalMap.class);
                startActivity(intent);

            }
        });
    }

}

