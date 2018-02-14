package com.example.mac.swyhealthmonitoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PatientAccountInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_account_information);

        final Button PatientAccountInformationconfirm = (Button) findViewById(R.id.PatientAccountInformationconfirm);

        PatientAccountInformationconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PatientAccountInformation.this, PatientAccount.class);
                startActivity(intent);
            }
        });
    }
}
