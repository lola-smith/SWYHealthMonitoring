package com.example.mac.swyhealthmonitoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PatientCreateAccount2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_create_account2);
        final Button PatientCreateAccount2CreateAccount =(Button) findViewById(R.id.PatientCreateAccount2CreateAccount);
        PatientCreateAccount2CreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientCreateAccount2.this,PatientHome.class);
                startActivity(intent);
            }
        });
    }
}
