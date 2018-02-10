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
        final TextView PatientAccountPAtientInfoText =(TextView) findViewById(R.id.PatientAccountPAtientInfoText);

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

        PatientAccountPAtientInfoText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientAccount.this,PatientAccountInformation.class);
                startActivity(intent);
            }
        });
    }
}
