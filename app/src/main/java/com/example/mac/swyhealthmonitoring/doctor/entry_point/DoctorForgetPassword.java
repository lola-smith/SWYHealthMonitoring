package com.example.mac.swyhealthmonitoring.doctor.entry_point;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.mac.swyhealthmonitoring.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DoctorForgetPassword extends AppCompatActivity {


    @BindView(R.id.DoctorForgetPasswordSubmit)
    Button DoctorForgetPasswordSubmit ;

    @BindView(R.id.DoctortForgetPasswordHint)
    TextView DoctortForgetPasswordHint ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_forget_password);
        ButterKnife.bind(this);

    }


    @OnClick(R.id. DoctorForgetPasswordSubmit)
    void  onClickDoctorLogin(){
        DoctortForgetPasswordHint.setText(getString(R.string.DoctorForgetPasswordHint1));
        startActivity(DoctorLogin.class," ");
    }

    private void startActivity(Class targetActivity,String data){
        Intent intent =new Intent(this,targetActivity);
        intent.putExtra("data",data);
        startActivity(intent);
    }
}
