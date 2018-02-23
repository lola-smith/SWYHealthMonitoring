package com.example.mac.swyhealthmonitoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DoctorAccountInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_account_info);

        final Button DoctorAccountInfoConfirm=(Button)findViewById(R.id.DoctorAccountInfoConfirm);
        DoctorAccountInfoConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(DoctorAccountInfo.this,DoctorAccount.class);
                startActivity(intent);
            }
        });
    }


}
