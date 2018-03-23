package com.example.mac.swyhealthmonitoring.doctor;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.mac.swyhealthmonitoring.R;
import com.example.mac.swyhealthmonitoring.doctor.info.DoctorAccount;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DoctorVideoCall extends AppCompatActivity {


    @BindView(R.id.DoctorHomeHomeImage)
    ImageButton DoctorHomeHomeImage;

    @BindView(R.id.DoctorHomeAccountImage)
    ImageButton DoctorHomeAccountImage;

    @BindView(R.id.DoctorVideoCallButton)
    Button DoctorVideoCallButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_video_call);
        ButterKnife.bind(this);
          }

    @OnClick(R.id.DoctorHomeHomeImage)
    void onClickDoctorHome(){
        startActivity(DoctorHome.class," ");
    }

    @OnClick(R.id.DoctorHomeAccountImage)
    void onClickDoctorAccount(){
        startActivity(DoctorAccount.class," ");
    }

    @OnClick(R.id.DoctorVideoCallButton)
    void onClickDoctorAddPatient(){

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(DoctorVideoCall.this);
        View mView = getLayoutInflater().inflate(R.layout.doctoraddpatient,null);

        final AutoCompleteTextView DoctorAddPatientText = (AutoCompleteTextView) mView.findViewById(R.id.DoctorAddPatientText);
        final Button DoctorAddPatientBotton = (Button) mView.findViewById(R.id.DoctorAddPatientBotton);


        DoctorAddPatientBotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DoctorVideoCall.this,"Patient has been adding",Toast.LENGTH_SHORT).show();
            }
        });
        mBuilder.setView(mView);
        AlertDialog dialog = mBuilder.create();
        dialog.show();
    }

    private void startActivity(Class targetActivity,String data){
        Intent intent =new Intent(this,targetActivity);
        intent.putExtra("data",data);
        startActivity(intent);
    }
}
