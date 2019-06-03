package com.example.todopomo;

import android.app.Dialog;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class Timer extends AppCompatActivity {
    // add timer with dialog
    public void pomodoroTimer() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.timer);

        final Chronometer chronometer = (Chronometer) findViewById(R.id.chronometer);
        Button buttonStart = (Button) findViewById(R.id.timer_button_start);
        Button buttonStop = (Button) findViewById(R.id.timer_button_stop);
        Button buttonReset = (Button) findViewById(R.id.timer_button_reset);

        buttonStart.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                chronometer.start();
            }
        });

        buttonStop.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                chronometer.stop();
            }
        });

        buttonReset.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
            }
        });
    }
}
