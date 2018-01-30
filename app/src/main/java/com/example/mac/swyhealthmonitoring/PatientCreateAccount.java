package com.example.mac.swyhealthmonitoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PatientCreateAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_create_account);
        final TextView PatientCreateAccountLogin = (TextView) findViewById(R.id.PatientCreateAccountLogin);
        final Button PatientCreateAccountNext =(Button) findViewById(R.id.PatientCreateAccountNext);
        PatientCreateAccountLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientCreateAccount.this,PatientLogin.class);
                startActivity(intent);
            }
        });

        PatientCreateAccountNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientCreateAccount.this,PatientCreateAccount2.class);
                startActivity(intent);
            }
        });
    }
}
