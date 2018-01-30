package com.example.mac.swyhealthmonitoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        final Button MainPatientButton;
        final  Button MainDoctorButton;

        MainPatientButton=findViewById(R.id.MainPatientButton);
        MainPatientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainPage.this,PatientLogin.class);
                startActivity(intent);
            }
        });

        MainDoctorButton=findViewById(R.id.MainDoctorButton);
        MainDoctorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainPage.this,DoctorLogin.class);
                startActivity(intent);
            }
        });


    }
}
