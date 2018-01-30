package com.example.mac.swyhealthmonitoring;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PatientForgetPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_forget_password);

        final Button PatientForgetPasswordSubmit = (Button) findViewById(R.id.PatientForgetPasswordSubmit);
        final EditText PatientForgetPasswordHint = (EditText) findViewById(R.id.PatientForgetPasswordHint);
        PatientForgetPasswordSubmit .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PatientForgetPasswordHint.setText(getString(R.string.PatientForgetPasswordHint1));
            }
        });
    }
}
