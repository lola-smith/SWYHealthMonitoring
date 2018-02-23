package com.example.mac.swyhealthmonitoring;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class PatientVideoCall extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_video_call);

        final ImageButton PatientHomeHome = (ImageButton) findViewById(R.id.PatientHomeHome);
        final ImageButton PatientHomeAccount = (ImageButton) findViewById(R.id.PatientHomeAccount);
        final ImageButton PatientHomeIconLocation=(ImageButton) findViewById(R.id.PatientHomeIconLocation);
        final ImageButton PatientHomeHeart =(ImageButton) findViewById(R.id.PatientHomeHeart);
         final ImageButton PatientHomeFamily=(ImageButton) findViewById(R.id.PatientHomeFamily);
         final Button DoctorVideoCallButton=(Button) findViewById(R.id.DoctorVideoCallButton);

                PatientHomeHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientVideoCall.this,PatientHome.class);
                startActivity(intent);
            }
        });
        PatientHomeAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientVideoCall.this,PatientAccount.class);
                startActivity(intent);
            }
        });
        PatientHomeIconLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientVideoCall.this,PatientHospitalMap.class);
                startActivity(intent);
            }
        });

        PatientHomeHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientVideoCall.this,PatientMyHealth.class);
                startActivity(intent);
            }
        });

        PatientHomeFamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientVideoCall.this,PatientFamily.class);
                startActivity(intent);
            }
        });

        DoctorVideoCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(PatientVideoCall.this);
                View mView = getLayoutInflater().inflate(R.layout.patientadddoctor,null);

                final AutoCompleteTextView PatientAddDoctorText = (AutoCompleteTextView) mView.findViewById(R.id.PatientAddDoctorText);
                final Button PatientAddDoctorBotton = (Button) mView.findViewById(R.id.PatientAddDoctorBotton);


                PatientAddDoctorBotton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(PatientVideoCall.this,"Doctor has been adding",Toast.LENGTH_SHORT).show();
                    }
                });
                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });

    }
}
