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

public class PatientHomeSuger extends AppCompatActivity {

    @BindView(R.id.PatientHomeSugerButton)
    Button PatientHomeSugerButton;

    @BindView(R.id.PatientHomeSugerSetting)
    TextView PatientHomeSugerSetting;

    @BindView(R.id.PatientHomeSugerHistory)
    TextView PatientHomeSugerHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home_suger);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.PatientHomeSugerButton)
    void onClickSugerStartReading(){

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(PatientHomeSuger.this);
        View mView = getLayoutInflater().inflate(R.layout.sugerstartreading,null);

        final TextView PatientSugerReading = (TextView) mView.findViewById(R.id.PatientSugerReading);
        final Button PatientSugerOK = (Button) mView.findViewById(R.id.PatientSugerOK);


        PatientSugerOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PatientHomeSuger.this,"Reading has been Saving",Toast.LENGTH_SHORT).show();
            }
        });
        mBuilder.setView(mView);
        AlertDialog dialog = mBuilder.create();
        dialog.show();
    }

    @OnClick(R.id.PatientHomeSugerSetting)
    void onClickSugerSetting(){
        startActivity(SugerSetting.class," ");
    }

    @OnClick(R.id.PatientHomeSugerHistory)
    void onClickSugerHistory(){
        startActivity(SugerHistory.class," ");
    }


    private void startActivity(Class targetActivity,String data){
        Intent intent =new Intent(this,targetActivity);
        intent.putExtra("data",data);
        startActivity(intent);
    }
}
