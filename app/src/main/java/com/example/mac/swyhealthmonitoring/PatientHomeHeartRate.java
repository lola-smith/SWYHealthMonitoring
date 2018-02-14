package com.example.mac.swyhealthmonitoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PatientHomeHeartRate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home_heart_rate);

        final TextView PatientHomeHeartRateHistory = (TextView) findViewById(R.id.PatientHomeHeartRateHistory);
        final TextView PatientHomeHeartRateSetting = (TextView) findViewById(R.id.PatientHomeHeartRateSetting);
        PatientHomeHeartRateHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientHomeHeartRate.this,HeartRateHistory.class);
                startActivity(intent);
            }
        });
        PatientHomeHeartRateSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientHomeHeartRate.this,HeartRateSetting.class);
                startActivity(intent);
            }
        });
    }

    }

