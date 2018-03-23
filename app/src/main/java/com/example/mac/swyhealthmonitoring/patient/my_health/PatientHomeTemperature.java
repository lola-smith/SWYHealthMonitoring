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
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PatientHomeTemperature extends AppCompatActivity {
    @BindView(R.id.PatientHomeTempButton)
    Button PatientHomeTempButton;

    @BindView(R.id.PatientHomeTempHistory)
    TextView PatientHomeTempHistory;

    @BindView(R.id.PatientHomeTempSetting)
    TextView PatientHomeTempSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home_temperature);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.PatientHomeTempButton)
    void onClickTempStartReading(){

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(PatientHomeTemperature.this);
        View mView = getLayoutInflater().inflate(R.layout.tempstartreading,null);

        final TextView PatientTempReading = (TextView) mView.findViewById(R.id.PatientTempReading);
        final Button PatientTempOK = (Button) mView.findViewById(R.id.PatientTempOK);


        PatientTempOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PatientHomeTemperature.this,"Reading has been Saving",Toast.LENGTH_SHORT).show();
            }
        });
        mBuilder.setView(mView);
        AlertDialog dialog = mBuilder.create();
        dialog.show();
    }

    @OnClick(R.id.PatientHomeTempSetting)
    void onClickTempSetting(){
        startActivity(TempSetting.class," ");
    }

    @OnClick(R.id.PatientHomeTempHistory)
    void onClickTempHistory(){
        startActivity(TempHistory.class," ");
    }


    private void startActivity(Class targetActivity,String data){
        Intent intent =new Intent(this,targetActivity);
        intent.putExtra("data",data);
        startActivity(intent);
    }
}
