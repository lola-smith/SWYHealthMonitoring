package com.example.mac.swyhealthmonitoring;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PatientForgetPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_forget_password);

        final Button PatientForgetPasswordSubmit = (Button) findViewById(R.id.PatientForgetPasswordSubmit);
        final TextView PatientForgetPasswordHint = (TextView) findViewById(R.id.PatientForgetPasswordHint);
        PatientForgetPasswordSubmit .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PatientForgetPasswordHint.setText(getString(R.string.PatientForgetPasswordHint1));
            }
        });
    }
}
