package com.example.mac.swyhealthmonitoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DoctorSupport extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_support);
        final Button DoctorSupportAskQuestion=(Button) findViewById(R.id.DoctorSupportAskQuestion);

        DoctorSupportAskQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(DoctorSupport.this,DoctorAskQuestion.class);
                startActivity(intent);
            }
        });
    }
}
