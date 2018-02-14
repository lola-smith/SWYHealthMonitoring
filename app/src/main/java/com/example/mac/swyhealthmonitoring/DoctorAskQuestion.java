package com.example.mac.swyhealthmonitoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DoctorAskQuestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_ask_question);
        final Button DoctorAskQuestionSubmit =(Button) findViewById(R.id.PatientAskQuestionSubmit);
        DoctorAskQuestionSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(DoctorAskQuestion.this,DoctorSupport.class);
                startActivity(intent);
            }
        });
    }
}
