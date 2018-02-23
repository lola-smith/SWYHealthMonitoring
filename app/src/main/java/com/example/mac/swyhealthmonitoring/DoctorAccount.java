package com.example.mac.swyhealthmonitoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class DoctorAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_account);

        final ImageButton DoctorAccountAccountImage=(ImageButton)findViewById(R.id.DoctorAccountAccountImage);
        final ImageButton DoctorAccountHomeImage=(ImageButton)findViewById(R.id.DoctorAccountHomeImage);
        final TextView DoctorAccountEmailandPass =(TextView) findViewById(R.id.DoctorAccountEmailandPass);
        final TextView DoctorAccountInfotext =(TextView) findViewById(R.id.DoctorAccountInfotext);
        final TextView DoctorAccountAboutUsText=(TextView) findViewById(R.id.DoctorAccountAboutUsText);
        final TextView DoctorAccountCustomerSupportText=(TextView) findViewById(R.id.DoctorAccountCustomerSupportText) ;
        final TextView DoctorAccountLogout=(TextView) findViewById(R.id.DoctorAccountLogout);
        DoctorAccountHomeImage.setOnClickListener(new View.OnClickListener() {
                                                      @Override
             public void onClick(View view) {
                                                          Intent intent =new Intent(DoctorAccount.this,DoctorHome.class);
                                                          startActivity(intent);
                                                      }
                                                  });
                DoctorAccountAccountImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(DoctorAccount.this, DoctorAccount.class);
                        startActivity(intent);
                    }
                });

        DoctorAccountEmailandPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DoctorAccount.this, DoctorAccountEmailAndPass.class);
                startActivity(intent);
            }
        });

        DoctorAccountInfotext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DoctorAccount.this, DoctorAccountInfo.class);
                startActivity(intent);
            }
        });

        DoctorAccountAboutUsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DoctorAccount.this, DoctorAboutUs.class);
                startActivity(intent);
            }
        });

        DoctorAccountCustomerSupportText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DoctorAccount.this, DoctorSupport.class);
                startActivity(intent);
            }
        });

        DoctorAccountLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DoctorAccount.this, DoctorLogin.class);
                startActivity(intent);
            }
        });

    }
    }

