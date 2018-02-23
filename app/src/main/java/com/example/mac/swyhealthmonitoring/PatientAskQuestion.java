package com.example.mac.swyhealthmonitoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PatientAskQuestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_ask_question);
       final Button PatientAskQuestionSubmit =(Button) findViewById(R.id.PatientAskQuestionSubmit);
        PatientAskQuestionSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PatientAskQuestion.this,PatientSupport.class);
                startActivity(intent);
            }
        });
    }
}
