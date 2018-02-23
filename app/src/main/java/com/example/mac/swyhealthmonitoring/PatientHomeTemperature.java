package com.example.mac.swyhealthmonitoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PatientHomeTemperature extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home_temperature);

        final TextView PatientHomeTempHistory = (TextView) findViewById(R.id.PatientHomeTempHistory);
        final TextView PatientHomeTempSetting = (TextView) findViewById(R.id.PatientHomeTempSetting);
        PatientHomeTempHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientHomeTemperature.this,TempHistory.class);
                startActivity(intent);
            }
        });
        PatientHomeTempSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientHomeTemperature.this,TempSetting.class);
                startActivity(intent);
            }
        });
    }
}
