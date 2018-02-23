package com.example.mac.swyhealthmonitoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PatientAccountEmailAndPass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_account_email_and_pass);

        final Button PatientAccountEmailAndPassConfirmChange=(Button)findViewById(R.id.PatientAccountEmailAndPassConfirmChange);
        PatientAccountEmailAndPassConfirmChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientAccountEmailAndPass.this,PatientAccount.class);
                startActivity(intent);
            }
        });
    }
}
