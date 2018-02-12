package com.example.mac.swyhealthmonitoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class DoctorHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_home);


        final ImageButton DoctorHomeHomeImage=(ImageButton)findViewById(R.id.DoctorHomeHomeImage);
        final ImageButton DoctorHomeAccountImage=(ImageButton)findViewById(R.id.DoctorHomeAccountImage);
        DoctorHomeHomeImage .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(DoctorHome.this,DoctorHome.class);
                startActivity(intent);
            }
        });
    }
}
