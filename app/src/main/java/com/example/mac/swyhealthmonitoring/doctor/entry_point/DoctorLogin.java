package com.example.mac.swyhealthmonitoring.doctor.entry_point;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import android.widget.ProgressBar;
import com.example.mac.swyhealthmonitoring.R;
import com.example.mac.swyhealthmonitoring.doctor.DoctorHome;
import com.example.mac.swyhealthmonitoring.doctor.entry_point.DoctorCreateAccount;
import com.example.mac.swyhealthmonitoring.doctor.entry_point.DoctorForgetPassword;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DoctorLogin extends AppCompatActivity {
    private FirebaseAuth FBADoctorLogin;

    @BindView(R.id.DoctorLoginprogressBar)
    ProgressBar DoctorLoginprogressBar;


    @BindView(R.id.DoctorLoginEmail)
    EditText DoctorLoginEmail;

    @BindView(R.id.DoctorLoginPassword)
    EditText DoctorLoginPassword;


    @BindView(R.id.DoctorLoginForgetPassword)
    TextView DoctorLoginForgetPassword;

    @BindView(R.id.DoctorLogincreataccount)
    TextView DoctorLogincreataccount;

    @BindView(R.id.DoctorLoginButtonLogin)
    Button  DoctorLoginButtonLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_login);

        ButterKnife.bind(this);
    }
    private void UserLogin(){

        String Email =DoctorLoginEmail.getText().toString().trim();

        String password =DoctorLoginPassword.getText().toString().trim();
        if (Email.isEmpty())
        {
            DoctorLoginEmail.setError("Email is Required");
            DoctorLoginEmail.requestFocus();
            return;

        }
        if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches())
        {
            DoctorLoginEmail.setError("Please Enter a Valid Email");
            DoctorLoginEmail.requestFocus();
            return;

        }

        if (password.length()<6)
        {
            DoctorLoginEmail.setError("Minimum length of Password should be 6 ");
            DoctorLoginEmail.requestFocus();
            return;

        }
        if (password.isEmpty())
        {
            DoctorLoginPassword.setError("Password is Required");
            DoctorLoginPassword.requestFocus();
            return;

        }



        DoctorLoginprogressBar.setVisibility(View.VISIBLE);

        FBADoctorLogin.signInWithEmailAndPassword(Email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {


            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                DoctorLoginprogressBar.setVisibility(View.GONE);
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Login Successfull",Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }

            }  });
            }








    @OnClick(R.id.DoctorLoginForgetPassword)
    void onClickDoctorForgetPassword(){
        startActivity(DoctorForgetPassword.class," ");
    }
    @OnClick(R.id.DoctorLogincreataccount)
    void onClickDoctorCreataccount(){
        startActivity(DoctorCreateAccount.class," ");
    }
    @OnClick(R.id.DoctorLoginButtonLogin)
    void onClickDoctorHome(){
        startActivity(DoctorHome.class," ");
    }

    private void startActivity(Class targetActivity,String data){
        Intent intent =new Intent(this,targetActivity);
        intent.putExtra("data",data);
        startActivity(intent);
    }
}
