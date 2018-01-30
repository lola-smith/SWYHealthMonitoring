package com.example.mac.swyhealthmonitoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DoctorCreateAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_create_account);

        final TextView DoctorCreateAccountLogin = (TextView) findViewById(R.id.DoctorCreateAccountLogin);
        final Button DoctorCreateAccountNext =(Button) findViewById(R.id.DoctorCreateAccountNext);
        DoctorCreateAccountLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(DoctorCreateAccount.this,DoctorLogin.class);
                startActivity(intent);
            }
        });

        DoctorCreateAccountNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(DoctorCreateAccount.this,DoctorCreateAccount2.class);
                startActivity(intent);
            }
        });

    }
}
