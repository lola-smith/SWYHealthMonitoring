package com.example.mac.swyhealthmonitoring.patient.my_health;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mac.swyhealthmonitoring.R;
import com.example.mac.swyhealthmonitoring.patient.info.PatientAskQuestion;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PatientHomeHeartRate extends AppCompatActivity {

    @BindView(R.id.PatientHomeHeartReatButton)
    Button PatientHomeHeartReatButton;

    @BindView(R.id.PatientHomeHeartRateSetting)
    TextView PatientHomeHeartRateSetting;

    @BindView(R.id.PatientHomeHeartRateHistory)
    TextView PatientHomeHeartRateHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home_heart_rate);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.PatientHomeHeartReatButton)
    void onClickHeartStartReading(){
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(PatientHomeHeartRate.this);
        View mView = getLayoutInflater().inflate(R.layout.heartstartreading,null);

        final TextView PatientHeartReading = (TextView) mView.findViewById(R.id.PatientHeartReading);
        final Button PatientHeartOK = (Button) mView.findViewById(R.id.PatientHeartOK);


        PatientHeartOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PatientHomeHeartRate.this,"Reading has been Saving",Toast.LENGTH_SHORT).show();
            }
        });
        mBuilder.setView(mView);
        AlertDialog dialog = mBuilder.create();
        dialog.show();
    }

    @OnClick(R.id.PatientHomeHeartRateSetting)
    void onClickHeartRateSetting(){
        startActivity(HeartRateSetting.class," ");
    }

    @OnClick(R.id.PatientHomeHeartRateHistory)
    void onClickHeartRateHistory(){
        startActivity(HeartRateHistory.class," ");
    }


    private void startActivity(Class targetActivity,String data){
        Intent intent =new Intent(this,targetActivity);
        intent.putExtra("data",data);
        startActivity(intent);
    }

    }

