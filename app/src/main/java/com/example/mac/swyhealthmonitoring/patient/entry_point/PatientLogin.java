package com.example.mac.swyhealthmonitoring.patient.entry_point;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mac.swyhealthmonitoring.R;
import com.example.mac.swyhealthmonitoring.database.DatabaseManager;
import com.example.mac.swyhealthmonitoring.patient.PatientHome;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.schedulers.Schedulers;


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


    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_login);
        ButterKnife.bind(this);
        firebaseAuth = FirebaseAuth.getInstance();

    }

    private void LoginUser() {

        String email = PatientLoginEmail.getText().toString().trim();
        String password = PatientLoginPassword.getText().toString().trim();

        if (email.isEmpty()) {
            PatientLoginEmail.setError("Email is Required");
            PatientLoginEmail.requestFocus();
            return;

        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            PatientLoginEmail.setError("Please Enter a Valid Email");
            PatientLoginEmail.requestFocus();
            return;

        }
        if (password.isEmpty()) {
            PatientLoginPassword.setError("Password is Required");
            PatientLoginPassword.requestFocus();
            return;
        }
        if (password.length() < 6) {
            PatientLoginPassword.setError("Minimum length of Password should be 6 ");
            PatientLoginPassword.requestFocus();
            return;

        }
        PatientLoginprogressBar.setVisibility(View.VISIBLE);
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            PatientLoginprogressBar.setVisibility(View.GONE);
            if (task.isSuccessful()) {
                DatabaseManager.getInstance().getUserId(PatientLoginEmail.getText().toString())
                        .subscribeOn(Schedulers.io())
                        .subscribe(this::onUserFoundInDatabase,this::onUserNotFound);

            } else
                Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
        });
    }

    private void onUserNotFound(Throwable throwable) {
        Toast.makeText(this,"Please Try again later",Toast.LENGTH_LONG).show();
    }

    private void onUserFoundInDatabase(String user) {
        DatabaseManager.userID = user;
        startActivity(PatientHome.class, " ");
    }

    @OnClick(R.id.PatientLoginButtonLogin)
    void onClickPatientHome() {
        LoginUser();
//        startActivity(PatientHome.class, " ");
    }

    @OnClick(R.id.PatientLoginForgetPassword)
    void onClickPatientForgetPassword() {
        startActivity(PatientForgetPassword.class, " ");
    }

    @OnClick(R.id.PatientLogincreataccount)
    void onClickPatientCreateAccount() {
        startActivity(PatientCreateAccount.class, " ");
    }


    private void startActivity(Class targetActivity, String data) {
        Intent intent = new Intent(this, targetActivity);
        intent.putExtra("data", data);
        startActivity(intent);
    }
}
