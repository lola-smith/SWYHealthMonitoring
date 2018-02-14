package com.example.mac.swyhealthmonitoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class PatientHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home);
        final ImageButton PatientHomeHome = (ImageButton) findViewById(R.id.PatientHomeHome);
        final ImageButton PatientHomeAccount =(ImageButton) findViewById(R.id.PatientHomeAccount);
        final Button PatientHomeVideoCall =(Button) findViewById(R.id.PatientHomeVideoCall);
        final ImageButton PatientHomeIconLocation =(ImageButton) findViewById(R.id.PatientHomeIconLocation);
        final ImageButton PatientHomeHeart =(ImageButton) findViewById(R.id.PatientHomeHeart);
        final ImageButton PatientHomeFamily =(ImageButton) findViewById(R.id.PatientHomeFamily);
        final ImageButton PatientHomeTempImage = (ImageButton) findViewById(R.id.PatientHomeTempImage);
        final ImageButton PatientHomeglocImage =(ImageButton) findViewById(R.id.PatientHomeglocImage);
        final ImageButton PatientHomeHeartImage =(ImageButton) findViewById(R.id.PatientHomeHeartImage);
        final ImageButton PatientHomePreImage =(ImageButton) findViewById(R.id.PatientHomePreImage);
        final TextView PatientHomeTempText = (TextView) findViewById(R.id.PatientHomeTempText);
        final TextView PatientHomeglocText =(TextView) findViewById(R.id.PatientHomeglocText);
        final TextView PatientHomeHeartText =(TextView) findViewById(R.id.PatientHomeHeartText);
        final TextView PatientHomePreText =(TextView) findViewById(R.id.PatientHomePreText);

        PatientHomeHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientHome.this,PatientHome.class);
                startActivity(intent);
            }
        });
        PatientHomeAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientHome.this,PatientAccount.class);
                startActivity(intent);
            }
        });

        PatientHomeVideoCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientHome.this,PatientVideoCall.class);
                startActivity(intent);
            }
        });
        PatientHomeIconLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientHome.this,PatientHospitalMap.class);
                startActivity(intent);
            }
        });

        PatientHomeFamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientHome.this,PatientFamily.class);
                startActivity(intent);
            }
        });

        PatientHomeHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientHome.this,PatientMyHealth.class);
                startActivity(intent);
            }
        });

        PatientHomeTempImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientHome.this,PatientHomeTemperature.class);
                startActivity(intent);
            }
        });
        PatientHomeglocImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientHome.this,PatientHomeSuger.class);
                startActivity(intent);
            }
        });
        PatientHomeHeartImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientHome.this,PatientHomeHeartRate.class);
                startActivity(intent);

            }
        });
        PatientHomePreImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientHome.this,PatientHomePressure.class);
                startActivity(intent);

            }
        });

        PatientHomeTempText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientHome.this,PatientHomeTemperature.class);
                startActivity(intent);
            }
        });
        PatientHomeglocText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientHome.this,PatientHomeSuger.class);
                startActivity(intent);
            }
        });
        PatientHomeHeartText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientHome.this,PatientHomeHeartRate.class);
                startActivity(intent);

            }
        });
        PatientHomePreText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientHome.this,PatientHomePressure.class);
                startActivity(intent);

            }
        });


        }}
