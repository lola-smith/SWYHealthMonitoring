package com.example.mac.swyhealthmonitoring.patient.my_health;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.mac.swyhealthmonitoring.R;
import com.example.mac.swyhealthmonitoring.blutooth.BluetoothReadingService;
import com.example.mac.swyhealthmonitoring.utils.ShareUtils;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HeartRateSetting extends AppCompatActivity {
    @BindView(R.id.HeartRateSettingAutoReading)
    RadioGroup updateReading;
    @BindView(R.id.HeartRateSettingHistory)
    RadioGroup updateHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_rate_setting);
        ButterKnife.bind(this);

        updateReading.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                Calendar.getInstance();
                long repeateInterval = 1000;
                int selectedRadioBtnID = group.getCheckedRadioButtonId();
                switch (selectedRadioBtnID) {
                    case R.id.HeartRateSettingAutoReadingRadio1:
                        repeateInterval = 1*60*60*1000;
                        break;
                    case R.id.HeartRateSettingAutoReadingRadio2:
                        repeateInterval = 2*60*60*1000;
                        break;
                    case R.id.HeartRateSettingAutoReadingRadio3:
                        repeateInterval = 4*60*60*1000;
                        break;
                    case R.id.HeartRateSettingAutoReadingRadio4:
                        repeateInterval = 6*24*60*60*1000;
                        break;
                }
               // ShareUtils.shareToWhatsapp(HeartRateSetting.this,"01017005710","Hello!");
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
                    case R.id.HeartRateSettingHistoryRadio1:
                        repeateInterval = 30*24*60*60*1000;
                        break;
                    case R.id.HeartRateSettingHistoryRadio2:
                        repeateInterval = 3*30*24*60*60*1000;
                        break;
                    case R.id.HeartRateSettingHistoryRadio3:
                        repeateInterval = 6*30*24*60*60*1000;
                        break;
                    case R.id.HeartRateSettingHistoryRadio4:
                        repeateInterval = 9*30*24*60*60*1000;
                        break;
                }
                // ShareUtils.shareToWhatsapp(HeartRateSetting.this,"01017005710","Hello!");
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
