package com.example.mac.swyhealthmonitoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PatientHomeSuger extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home_suger);

        final TextView PatientHomeSugerHistory = (TextView) findViewById(R.id.PatientHomeSugerHistory);
        final TextView PatientHomeSugerSetting = (TextView) findViewById(R.id.PatientHomeSugerSetting);
        PatientHomeSugerHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientHomeSuger.this,SugerHistory.class);
                startActivity(intent);
            }
        });
        PatientHomeSugerSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientHomeSuger.this,SugerSetting.class);
                startActivity(intent);
            }
        });
    }
}
