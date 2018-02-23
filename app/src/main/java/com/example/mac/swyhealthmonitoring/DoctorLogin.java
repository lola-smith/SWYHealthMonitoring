package com.example.mac.swyhealthmonitoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DoctorLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_login);
        final TextView DoctorLoginForgetPassword= (TextView) findViewById(R.id.DoctorLoginForgetPassword);
        final TextView DoctorLogincreataccount=(TextView) findViewById(R.id.DoctorLogincreataccount);
        final Button  DoctorLoginButtonLogin =(Button) findViewById(R.id.DoctorLoginButtonLogin);

        DoctorLoginForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(DoctorLogin.this,DoctorForgetPassword.class);
                startActivity(intent);
            }
        });
        DoctorLogincreataccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(DoctorLogin.this,DoctorCreateAccount.class);
                startActivity(intent);

            }
        });
        DoctorLoginButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(DoctorLogin.this,DoctorHome.class);
                startActivity(intent);
            }
        });

    }
}
