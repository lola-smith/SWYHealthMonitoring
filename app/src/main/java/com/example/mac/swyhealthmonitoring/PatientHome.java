package com.example.mac.swyhealthmonitoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PatientHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home);
        final ImageButton PatientHomeHome = (ImageButton) findViewById(R.id.PatientHomeHome);
        final ImageButton PatientHomeAccount =(ImageButton) findViewById(R.id.PatientHomeAccount);
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
    }
}
