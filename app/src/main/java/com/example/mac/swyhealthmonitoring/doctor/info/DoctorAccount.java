package com.example.mac.swyhealthmonitoring.doctor.info;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mac.swyhealthmonitoring.R;
import com.example.mac.swyhealthmonitoring.doctor.DoctorHome;
import com.example.mac.swyhealthmonitoring.doctor.entry_point.DoctorLogin;
import com.google.firebase.auth.FirebaseAuth;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DoctorAccount extends AppCompatActivity {
    private FirebaseAuth FBADoctorLogout;
    @BindView(R.id.DoctorAccountAccountImage)
    ImageButton DoctorAccountAccountImage;

    @BindView(R.id.DoctorAccountHomeImage)
    ImageButton DoctorAccountHomeImage;

    @BindView(R.id.DoctorAccountEmailandPass)
    TextView DoctorAccountEmailandPass;

    @BindView(R.id.DoctorAccountInfotext)
    TextView DoctorAccountInfotext;

    @BindView(R.id.DoctorAccountAboutUsText)
    TextView DoctorAccountAboutUsText;

    @BindView(R.id.DoctorAccountCustomerSupportText)
    TextView DoctorAccountCustomerSupportText;

    @BindView(R.id.DoctorAccountLogout)
    TextView DoctorAccountLogout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_account);

        ButterKnife.bind(this);
    }
    @OnClick(R.id. DoctorAccountLogout)
    void onClickDoctorLogin(){
        FBADoctorLogout.getInstance().signOut();
        finish();
        startActivity(DoctorLogin.class," ");
    }

    @OnClick(R.id. DoctorAccountCustomerSupportText)
    void onClickDoctorSupport(){
        startActivity(DoctorSupport.class," ");
    }

    @OnClick(R.id. DoctorAccountAboutUsText)
    void onClickDoctorAboutUs(){
        startActivity(DoctorAboutUs.class," ");
    }

    @OnClick(R.id. DoctorAccountInfotext)
    void onClickDoctorAccountInfo(){
        startActivity(DoctorAccountInfo.class," ");
    }

    @OnClick(R.id. DoctorAccountEmailandPass)
    void onClickDoctorAccountEmailAndPass(){
        startActivity(DoctorAccountEmailAndPass.class," ");
    }


    @OnClick(R.id. DoctorAccountAccountImage)
    void onClickDoctorAccount(){
        startActivity(DoctorAccount.class," ");
    }

    @OnClick(R.id.DoctorAccountHomeImage)
    void onClickDoctorHome(){
        startActivity(DoctorHome.class," ");
    }

    private void startActivity(Class targetActivity,String data){
        Intent intent =new Intent(this,targetActivity);
        intent.putExtra("data",data);
        startActivity(intent);
    }
    }

