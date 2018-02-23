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

public class DoctorVideoCall extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_video_call);
        final ImageButton DoctorHomeHomeImage=(ImageButton) findViewById(R.id.DoctorHomeHomeImage);
        final ImageButton DoctorHomeAccountImage=(ImageButton) findViewById(R.id.DoctorHomeAccountImage);
        final Button DoctorVideoCallButton =(Button) findViewById(R.id.DoctorVideoCallButton);

        DoctorHomeHomeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(DoctorVideoCall.this,DoctorHome.class);
                startActivity(intent);
            }
        });

        DoctorHomeAccountImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(DoctorVideoCall.this,DoctorAccount.class);
                startActivity(intent);
            }
        });

        DoctorVideoCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(DoctorVideoCall.this);
                View mView = getLayoutInflater().inflate(R.layout.doctoraddpatient,null);

                final AutoCompleteTextView DoctorAddPatientText = (AutoCompleteTextView) mView.findViewById(R.id.DoctorAddPatientText);
                final Button DoctorAddPatientBotton = (Button) mView.findViewById(R.id.DoctorAddPatientBotton);


                DoctorAddPatientBotton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(DoctorVideoCall.this,"Patient has been adding",Toast.LENGTH_SHORT).show();
                    }
                });
                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });

    }
}
