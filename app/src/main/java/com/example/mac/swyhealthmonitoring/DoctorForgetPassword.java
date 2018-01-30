package com.example.mac.swyhealthmonitoring;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DoctorForgetPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_forget_password);

        final Button  DoctorForgetPasswordSubmit= (Button) findViewById(R.id.DoctorForgetPasswordSubmit);
        final EditText DoctortForgetPasswordHint = (EditText) findViewById(R.id.DoctortForgetPasswordHint);
        DoctorForgetPasswordSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DoctortForgetPasswordHint.setText(getString(R.string.DoctorForgetPasswordHint1));

            }
        });
    }
}
