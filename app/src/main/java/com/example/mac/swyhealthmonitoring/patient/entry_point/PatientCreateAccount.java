package com.example.mac.swyhealthmonitoring.patient.entry_point;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mac.swyhealthmonitoring.R;
import com.example.mac.swyhealthmonitoring.doctor.entry_point.DoctorLogin;
import com.example.mac.swyhealthmonitoring.patient.PatientHome;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PatientCreateAccount extends AppCompatActivity {

    @BindView(R.id.PatientCreateAccountCreate)
    Button PatientCreateAccountCreate;

    @BindView(R.id.PatientCreateAccountEmail)
    TextView PatientCreateAccountEmail;

    @BindView(R.id.PatientCreateAccountPassword)
    TextView PatientCreateAccountPassword;

    @BindView(R.id.PatientCreateAccountConfirmPassword)
    TextView PatientCreateAccountConfirmPassword;

    @BindView(R.id.PatientCreateAccountLogin)
    TextView PatientCreateAccountLogin;

    @BindView(R.id.PatientCreateAccountprogressBar)
    ProgressBar PatientCreateAccountprogressBar;


    private FirebaseAuth FBAPatientCreateAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_create_account);
        ButterKnife.bind(this);
        FBAPatientCreateAccount = FirebaseAuth.getInstance();

    }

    private void RegisterUser (){

        String Email = PatientCreateAccountEmail.getText().toString().trim();
        String Password =PatientCreateAccountPassword.getText().toString().trim();
        String ConfirmPassword =PatientCreateAccountConfirmPassword.getText().toString().trim();



        if (Email.isEmpty())
        {
            PatientCreateAccountEmail.setError("Email is Required");
            PatientCreateAccountEmail.requestFocus();
            return;

        }
        if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches())
        {
            PatientCreateAccountEmail.setError("Please Enter a Valid Email");
            PatientCreateAccountEmail.requestFocus();
            return;

        }
        if (Password.length()<6)
        {
            PatientCreateAccountPassword.setError("Minimum length of Password should be 6 ");
            PatientCreateAccountPassword.requestFocus();
            return;

        }
        if (Password.isEmpty())
        {
            PatientCreateAccountPassword.setError("Password is Required");
            PatientCreateAccountPassword.requestFocus();
            return;

        }

        if (!Password.equals(ConfirmPassword))
        {
            PatientCreateAccountConfirmPassword.setError("ReType Password");
            PatientCreateAccountConfirmPassword.requestFocus();
            return;

        }
        PatientCreateAccountprogressBar.setVisibility(View.VISIBLE);

        Task<AuthResult> authResultTask = FBAPatientCreateAccount.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(task -> {
            PatientCreateAccountprogressBar.setVisibility(View.GONE);

            if (task.isSuccessful()) {

                Toast.makeText(getApplicationContext(), "User Registred Successfull", Toast.LENGTH_LONG).show();

                startActivity(PatientHome.class, " ");


            } else {

                if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                    Toast.makeText(getApplicationContext(), "You are already registered", Toast.LENGTH_LONG).show();
                } else {

                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();

                }
            }
        });
    }

  @OnClick(R.id.PatientCreateAccountLogin)
    void onClickPatientLogin(){

      startActivity(PatientLogin.class," ");
    }


    @OnClick(R.id.PatientCreateAccountCreate)
    void onClickPatientHome(){

        RegisterUser();
    }

    private void startActivity(Class targetActivity,String data){
        Intent intent =new Intent(this,targetActivity);
        intent.putExtra("data",data);
        startActivity(intent);
    }
}
