package tech.yojigen.timetoclose;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btn_1, btn_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_1.setOnClickListener(v -> {
            startAlarm(1000 * 60 * 60 * 2);
            finish();
        });
        btn_2.setOnClickListener(v -> {
            startAlarm(1000 * 60);
            finish();
        });
    }

    private void startAlarm(int time) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(this, StopReceiver.class);
        long alarmTime = SystemClock.elapsedRealtime() + time;
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, new Random().nextInt(), intent, 0);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, alarmTime, pendingIntent);
    }
}