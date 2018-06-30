package com.example.mac.swyhealthmonitoring.patient.info;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mac.swyhealthmonitoring.R;
import com.example.mac.swyhealthmonitoring.database.DatabaseManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.example.mac.swyhealthmonitoring.database.DatabaseManager.currentUser;

public class PatientAccountInformation extends AppCompatActivity {

    @BindView(R.id.PatientAccountInformationconfirm)
    Button PatientAccountInformationconfirm;

    @BindView(R.id.PatientAccountInformationDateOfBirth)
    TextView PatientAccountInformationDateOfBirth;

    @BindView(R.id.PatientAccountInformationName)
    TextView PatientAccountInformationName;

    @BindView(R.id.PatientAccountInformationPhone)
    TextView PatientAccountInformationPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_account_information);
        ButterKnife.bind(this);



    }

    @OnClick(R.id.PatientAccountInformationconfirm)
    void onClickPatientAccount(){
        Updatebd(PatientAccountInformationDateOfBirth.getText().toString());

        Updatename(PatientAccountInformationName.getText().toString());

        Updatephone(PatientAccountInformationPhone.getText().toString());
        startActivity(PatientAccount.class," ");
    }

   public void Updatebd (String bd ){

       currentUser.setBirthDate(bd);

       DatabaseManager.getInstance()
               .insertUser(currentUser)
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(this::onDataUpdatedInDB,this::onDatabaseError);


   }

   public void Updatename (String name){

        currentUser.setUserName(name);

        DatabaseManager.getInstance()
                .insertUser(currentUser)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onDataUpdatedInDB,this::onDatabaseError);


    }

    public void Updatephone (String phone){

        currentUser.setPhoneNumber(phone);

        DatabaseManager.getInstance()
                .insertUser(currentUser)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onDataUpdatedInDB,this::onDatabaseError);


    }
    private void onDatabaseError(Throwable throwable) {
        Toast.makeText(this, "Sorry Please try again later", Toast.LENGTH_SHORT).show();
    }

    private void onDataUpdatedInDB() {
        Toast.makeText(this, "Your contacts saved successfully", Toast.LENGTH_SHORT).show();

    }



    private void startActivity(Class targetActivity,String data){

        Intent intent =new Intent(this,targetActivity);
        intent.putExtra("data",data);
        startActivity(intent);

    }


}
