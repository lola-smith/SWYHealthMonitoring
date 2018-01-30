package com.example.mac.swyhealthmonitoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PatientLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_login);
        final TextView PatientLoginForgetPassword= (TextView) findViewById(R.id.PatientLoginForgetPassword);
        final TextView PatientLogincreataccount=(TextView) findViewById(R.id.PatientLogincreataccount);
        final Button PatientLoginButtonLogin =(Button) findViewById(R.id.PatientLoginButtonLogin);
        PatientLoginForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientLogin.this,PatientForgetPassword.class);
                startActivity(intent);
            }
        });

        PatientLogincreataccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientLogin.this,PatientCreateAccount.class);
                startActivity(intent);

            }
        });

        PatientLoginButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientLogin.this,PatientHome.class);
                startActivity(intent);
            }
        });

    }
}
