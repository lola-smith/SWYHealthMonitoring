package com.example.mac.swyhealthmonitoring.patient.entry_point;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mac.swyhealthmonitoring.R;
import com.example.mac.swyhealthmonitoring.patient.PatientHome;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class PatientLogin extends AppCompatActivity {

    @BindView(R.id.PatientLoginButtonLogin)
    Button PatientLoginButtonLogin;

    @BindView(R.id.PatientLogincreataccount)
    TextView PatientLogincreataccount;

    @BindView(R.id.PatientLoginForgetPassword)
    TextView PatientLoginForgetPassword;


    @BindView(R.id.PatientLoginEmail)
    EditText PatientLoginEmail;

    @BindView(R.id.PatientLoginPassword)
    EditText PatientLoginPassword;


    @BindView(R.id.PatientLoginprogressBar)
    ProgressBar PatientLoginprogressBar;


    private FirebaseAuth FBAPatientLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_login);
        ButterKnife.bind(this);
        FBAPatientLogin = FirebaseAuth.getInstance();

    }

  private void LoginUser(){

      String Email = PatientLoginEmail.getText().toString().trim();
      String Password =PatientLoginPassword.getText().toString().trim();

      if (Email.isEmpty())
      {
          PatientLoginEmail.setError("Email is Required");
          PatientLoginEmail.requestFocus();
          return;

      }
      if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches())
      {
          PatientLoginEmail.setError("Please Enter a Valid Email");
          PatientLoginEmail.requestFocus();
          return;

      }
      if (Password.length()<6)
      {
          PatientLoginPassword.setError("Minimum length of Password should be 6 ");
          PatientLoginPassword.requestFocus();
          return;

      }
      if (Password.isEmpty())
      {
          PatientLoginPassword.setError("Password is Required");
          PatientLoginPassword.requestFocus();
          return;

      }
      PatientLoginprogressBar.setVisibility(View.VISIBLE);
      FBAPatientLogin.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
          @Override
          public void onComplete(@NonNull Task<AuthResult> task) {

              PatientLoginprogressBar.setVisibility(View.GONE);

              if(task.isSuccessful()){
                  startActivity(PatientHome.class," ");


              }else {
                  Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_LONG).show();


              }

              }
      });
  }



    @OnClick(R.id.PatientLoginButtonLogin)
    void onClickPatientHome(){

        LoginUser();
    }

    @OnClick(R.id.PatientLoginForgetPassword)
    void onClickPatientForgetPassword(){
        startActivity(PatientForgetPassword.class," ");
    }

    @OnClick(R.id.PatientLogincreataccount)
    void onClickPatientCreateAccount(){
        startActivity(PatientCreateAccount.class," ");
    }


    private void startActivity(Class targetActivity,String data){
        Intent intent =new Intent(this,targetActivity);
        intent.putExtra("data",data);
        startActivity(intent);
    }
}
