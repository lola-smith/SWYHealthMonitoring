package com.example.mac.swyhealthmonitoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PatientHomePressure extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home_pressure);

        final TextView PatientHomePressureHistory = (TextView) findViewById(R.id.PatientHomePressureHistory);
        final TextView PatientHomePressureSetting = (TextView) findViewById(R.id.PatientHomePressureSetting);
        PatientHomePressureHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientHomePressure.this,PressureHistory.class);
                startActivity(intent);
            }
        });
        PatientHomePressureSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientHomePressure.this,PressureSetting.class);
                startActivity(intent);
            }
        });
    }
}
