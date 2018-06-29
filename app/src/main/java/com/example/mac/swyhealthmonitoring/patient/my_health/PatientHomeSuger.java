package com.example.mac.swyhealthmonitoring.patient.my_health;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mac.swyhealthmonitoring.MyApplication;
import com.example.mac.swyhealthmonitoring.R;
import com.example.mac.swyhealthmonitoring.blutooth.BluetoothCallback;
import com.example.mac.swyhealthmonitoring.blutooth.BluetoothDeviceConnection;
import com.example.mac.swyhealthmonitoring.database.DatabaseManager;
import com.example.mac.swyhealthmonitoring.utils.ShareUtils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PatientHomeSuger extends AppCompatActivity implements BluetoothCallback {

    @BindView(R.id.PatientHomeSugerButton)
    Button PatientHomeSugerButton;

    @BindView(R.id.PatientHomeSugerSetting)
    TextView PatientHomeSugerSetting;

    @BindView(R.id.PatientHomeSugerHistory)
    TextView PatientHomeSugerHistory;

    @BindView(R.id.PatientSugerReading)
    TextView PatientSugerReading;

    @BindView(R.id.PatientSugerReadingState)
    TextView PatientSugerReadingState;

    BluetoothDeviceConnection blutoothConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home_suger);
        ButterKnife.bind(this);

        MyApplication app = (MyApplication) getApplication();
        if (app.getBlutoothConnection() != null) {
            blutoothConnection = app.getBlutoothConnection();
            blutoothConnection.addCallback("Suger", this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (blutoothConnection != null) {
            blutoothConnection.removeCallback("Suger");
        }
    }

    @OnClick(R.id.PatientHomeSugerButton)
    void onClickSugerStartReading() {
        if (blutoothConnection.isConnected()) {
            blutoothConnection.sendData("G");
        } else {
            Toast.makeText(this, "Socket is not Connected", Toast.LENGTH_SHORT).show();
        }


    }

    @OnClick(R.id.PatientHomeSugerSetting)
    void onClickSugerSetting() {
        startActivity(SugerSetting.class, " ");
    }

    @OnClick(R.id.PatientHomeSugerHistory)
    void onClickSugerHistory() {
        startActivity(SugerHistory.class, " ");
    }


    private void startActivity(Class targetActivity, String data) {
        Intent intent = new Intent(this, targetActivity);
        intent.putExtra("data", data);
        startActivity(intent);
    }
    private void onDatabaseError(Throwable throwable) {
        Toast.makeText(this, "Sorry Please try again later", Toast.LENGTH_SHORT).show();
    }

    private void onDataUpdatedInDB() {
        Toast.makeText(this, "Your contacts saved successfully", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onIncomingData(String message) {
        try {
            float suger = Float.valueOf(message);
            List<Float> sugerreading;
            if (DatabaseManager.currentUser.getSugar() == null)
                sugerreading =new ArrayList<>();
            else
                sugerreading = DatabaseManager.currentUser.getSugar();

            sugerreading.add(suger);

            DatabaseManager.currentUser.setSugar(sugerreading);


            DatabaseManager.getInstance().editUser(DatabaseManager.currentUser).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(this::onDataUpdatedInDB,this::onDatabaseError);


            if (suger > 3.43) {
                PatientSugerReading.setText(message);
                String person1Number = getSharedPreferences("app", MODE_PRIVATE).getString("person1", "01122266168");
                String person2Number = getSharedPreferences("app", MODE_PRIVATE).getString("person2", "01122266168");
                String person3Number = getSharedPreferences("app", MODE_PRIVATE).getString("person3", "01122266168");
                String msg = "high suger level";
                ShareUtils.shareToWhatsapp(this, person1Number, msg);
                ShareUtils.shareToWhatsapp(this, person2Number, msg);
                ShareUtils.shareToWhatsapp(this, person3Number, msg);
                PatientSugerReadingState.setText("UP Normal");
                PatientSugerReadingState.setTextColor(Color.RED);
            } else if (suger < 1.30) {
                PatientSugerReading.setText(message);
                String person1Number = getSharedPreferences("app", MODE_PRIVATE).getString("person1", "01122266168");
                String person2Number = getSharedPreferences("app", MODE_PRIVATE).getString("person2", "01122266168");
                String person3Number = getSharedPreferences("app", MODE_PRIVATE).getString("person3", "01122266168");
                String msg = "low suger level";
                ShareUtils.shareToWhatsapp(this, person1Number, msg);
                ShareUtils.shareToWhatsapp(this, person2Number, msg);
                ShareUtils.shareToWhatsapp(this, person3Number, msg);
                PatientSugerReadingState.setText("up normal");
                PatientSugerReadingState.setTextColor(Color.RED);
            } else {
                PatientSugerReading.setText(message);

                PatientSugerReadingState.setText("normal");
                PatientSugerReadingState.setTextColor(Color.GREEN);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}

