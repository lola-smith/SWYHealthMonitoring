package com.example.mac.swyhealthmonitoring.doctor.entry_point;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.support.annotation.NonNull;
import com.example.mac.swyhealthmonitoring.R;
import com.example.mac.swyhealthmonitoring.doctor.DoctorHome;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class DoctorCreateAccount extends AppCompatActivity {
    private FirebaseAuth FBADoctorCreateAccount;

    @BindView(R.id.DoctorCreateAccountCreateAccount)
    TextView DoctorCreateAccountCreateAccount ;

    @BindView(R.id.DoctorCreateAccountLogin)
    TextView DoctorCreateAccountLogin ;


    @BindView(R.id.DoctorCreateAccountEmail)
    EditText DoctorCreateAccountEmail ;


    @BindView(R.id.DoctorCreateAccountPassword)
    EditText DoctorCreateAccountPassword ;

    @BindView(R.id.DoctorCreateAccountConfirmPassword)
    EditText DoctorCreateAccountConfirmPassword;


    @BindView(R.id.DoctorCreateAccountprogressBar)
    ProgressBar DoctorCreateAccountprogressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_create_account);
        ButterKnife.bind(this);
        FBADoctorCreateAccount = FirebaseAuth.getInstance();

    }

    private void Registeruser(){

        String Email =DoctorCreateAccountEmail.getText().toString().trim();

        String password =DoctorCreateAccountPassword.getText().toString().trim();
        String ConfirmPassword =DoctorCreateAccountConfirmPassword.getText().toString().trim();



        if (Email.isEmpty())
        {
            DoctorCreateAccountEmail.setError("Email is Required");
            DoctorCreateAccountEmail.requestFocus();
            return;

        }
        if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches())
        {
            DoctorCreateAccountEmail.setError("Please Enter a Valid Email");
            DoctorCreateAccountEmail.requestFocus();
            return;

        }

        if (password.length()<6)
        {
            DoctorCreateAccountPassword.setError("Minimum length of Password should be 6 ");
            DoctorCreateAccountPassword.requestFocus();
            return;

        }
        if (password.isEmpty())
        {
            DoctorCreateAccountPassword.setError("Password is Required");
            DoctorCreateAccountPassword.requestFocus();
            return;

        }

        if (!password.equals(ConfirmPassword))
        {
            DoctorCreateAccountConfirmPassword.setError("ReType Password");
            DoctorCreateAccountConfirmPassword.requestFocus();
            return;

        }

        DoctorCreateAccountprogressBar.setVisibility(View.VISIBLE);

        FBADoctorCreateAccount.createUserWithEmailAndPassword(Email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {


            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                DoctorCreateAccountprogressBar.setVisibility(View.GONE);
                if(task.isSuccessful()){

                    Toast.makeText(getApplicationContext(),"User Registred Successfull",Toast.LENGTH_LONG).show();

                    startActivity(DoctorHome.class," ");


                }
                else{

                    if(task.getException()instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(getApplicationContext(),"You are already registered",Toast.LENGTH_LONG).show();
                    }
                    else {

                        Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_LONG).show();

                    }
                }
            }
        });
    }


    @OnClick(R.id.DoctorCreateAccountLogin)
    void onClickDoctorLogin(){
        startActivity(DoctorLogin.class," ");
    }
    @OnClick(R.id.DoctorCreateAccountCreateAccount)
    void  onClickDoctorHome(){

        Registeruser();
    }



    private void startActivity(Class targetActivity,String data){
        Intent intent =new Intent(this,targetActivity);
        intent.putExtra("data",data);
        startActivity(intent);
    }
}
