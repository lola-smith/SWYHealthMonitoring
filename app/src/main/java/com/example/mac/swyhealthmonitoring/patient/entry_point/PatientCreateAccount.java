package com.example.mac.swyhealthmonitoring.patient.entry_point;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mac.swyhealthmonitoring.R;
import com.example.mac.swyhealthmonitoring.database.DatabaseManager;
import com.example.mac.swyhealthmonitoring.entities.User;
import com.example.mac.swyhealthmonitoring.patient.PatientHome;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PatientCreateAccount extends AppCompatActivity {

    @BindView(R.id.PatientCreateAccountName)
    EditText patientName;

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


    private FirebaseAuth firebaseAuthIstance;

    private final User currentUser = new User();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_create_account);
        ButterKnife.bind(this);
        firebaseAuthIstance = FirebaseAuth.getInstance();
    }

    private void RegisterUser() {

        String Email = PatientCreateAccountEmail.getText().toString().trim();
        String Password = PatientCreateAccountPassword.getText().toString().trim();
        String ConfirmPassword = PatientCreateAccountConfirmPassword.getText().toString().trim();


        if (Email.isEmpty()) {
            PatientCreateAccountEmail.setError("Email is Required");
            PatientCreateAccountEmail.requestFocus();
            return;

        }
        if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            PatientCreateAccountEmail.setError("Please Enter a Valid Email");
            PatientCreateAccountEmail.requestFocus();
            return;

        }
        if (Password.length() < 6) {
            PatientCreateAccountPassword.setError("Minimum length of Password should be 6 ");
            PatientCreateAccountPassword.requestFocus();
            return;

        }
        if (Password.isEmpty()) {
            PatientCreateAccountPassword.setError("Password is Required");
            PatientCreateAccountPassword.requestFocus();
            return;

        }

        if (!Password.equals(ConfirmPassword)) {
            PatientCreateAccountConfirmPassword.setError("ReType Password");
            PatientCreateAccountConfirmPassword.requestFocus();
            return;

        }
        PatientCreateAccountprogressBar.setVisibility(View.VISIBLE);

        Task<AuthResult> authResultTask = firebaseAuthIstance.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(task -> {

            if (task.isSuccessful()) {

                Toast.makeText(getApplicationContext(), "User Registered Successfully", Toast.LENGTH_LONG).show();
                currentUser.setUserName(patientName.getText().toString());
                currentUser.setEmail(PatientCreateAccountEmail.getText().toString());

                DatabaseManager.getInstance()
                        .insertUser(currentUser)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(this::onUserInsertedToDatabase,
                                this::onInsertUserToDatabaseFail);


            } else {

                if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                    Toast.makeText(getApplicationContext(), "You are already registered", Toast.LENGTH_LONG).show();
                } else if(task.getException()!=null) {
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "We can not handle Your request right now", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void onUserInsertedToDatabase() {
        PatientCreateAccountprogressBar.setVisibility(View.GONE);
        startActivity(new Intent(this, PatientHome.class));
        this.finish();
    }

    private void onInsertUserToDatabaseFail(Throwable throwable) {
        if (firebaseAuthIstance.getCurrentUser() != null)
            firebaseAuthIstance.getCurrentUser().delete();
        PatientCreateAccountprogressBar.setVisibility(View.GONE);
        Toast.makeText(this, "We can not add user to database please try again later", Toast.LENGTH_LONG).show();

    }

    @OnClick(R.id.PatientCreateAccountLogin)
    void onClickPatientLogin() {

        startActivity(PatientLogin.class, " ");
    }


    @OnClick(R.id.PatientCreateAccountCreate)
    void onClickPatientHome() {

        RegisterUser();
    }

    private void startActivity(Class targetActivity, String data) {
        Intent intent = new Intent(this, targetActivity);
        intent.putExtra("data", data);
        startActivity(intent);
    }
}
