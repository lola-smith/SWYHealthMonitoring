package com.example.mac.swyhealthmonitoring.patient.my_health;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.mac.swyhealthmonitoring.R;
import com.example.mac.swyhealthmonitoring.blutooth.BluetoothReadingService;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SugerSetting extends AppCompatActivity {

    @BindView(R.id.SugerSettingAutoReadingRadio)
    RadioGroup updateReading;
    @BindView(R.id.SugerSettingHistoryRadio)
    RadioGroup updateHistory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suger_setting);
        ButterKnife.bind(this);

        updateReading.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                Calendar.getInstance();
                long repeateInterval = 1000;
                int selectedRadioBtnID = group.getCheckedRadioButtonId();
                switch (selectedRadioBtnID) {
                    case R.id.SugerSettingAutoReadingRadio1:
                        repeateInterval = 3*60*60*1000;
                        break;
                    case R.id.SugerSettingAutoReadingRadio2:
                        repeateInterval = 6*60*60*1000;
                        break;
                    case R.id.SugerSettingAutoReadingRadio3:
                        repeateInterval = 12*60*60*1000;
                        break;
                    case R.id.SugerSettingAutoReadingRadio4:
                        repeateInterval = 24*60*60*1000;
                        break;
                }
              //  ShareUtils.shareToWhatsapp(SugerSetting.this,"01017005710","Hello!");
                createNotificationReminder(repeateInterval);
            }
        });
        updateHistory.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                Calendar.getInstance();
                long repeateInterval = 1000;
                int selectedRadioBtnID = group.getCheckedRadioButtonId();
                switch (selectedRadioBtnID) {
                    case R.id.SugerSettingHistoryRadio1:
                        repeateInterval = 30*24*60*60*1000;
                        break;
                    case R.id.SugerSettingHistoryRadio2:
                        repeateInterval = 3*30*24*60*60*1000;
                        break;
                    case R.id.SugerSettingHistoryRadio3:
                        repeateInterval = 6*30*24*60*60*1000;
                        break;
                    case R.id.SugerSettingHistoryRadio4:
                        repeateInterval = 9*30*24*60*60*1000;
                        break;
                }
                //  ShareUtils.shareToWhatsapp(SugerSetting.this,"01017005710","Hello!");
                createNotificationReminder(repeateInterval);
            }
        });
    }


    private void createNotificationReminder(long repeateInterval) {
        Intent myIntent = new Intent(this, BluetoothReadingService.class);
        myIntent.putExtra("temp", true);
        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getService(this, 0, myIntent, 0);



        if (alarmManager != null) {
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), repeateInterval, pendingIntent);
            Toast.makeText(this, "Your settings saved succesfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Sorry we can not save your settings right now, please try again later.", Toast.LENGTH_LONG).show();
        }
    }
}
