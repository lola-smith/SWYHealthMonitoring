package com.example.mac.swyhealthmonitoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DoctorAccountEmailAndPass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_account_email_and_pass);

        final Button DoctorAccountEmailAndPassConfirmChange=(Button)findViewById(R.id.DoctorAccountEmailAndPassConfirmChange);
        DoctorAccountEmailAndPassConfirmChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(DoctorAccountEmailAndPass.this,DoctorAccount.class);
                startActivity(intent);
            }
        });
    }

}
