package com.android.example.tomat;

import android.os.CountDownTimer;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CustomTimer {
    long workTimeMinutesMls = 25 * 60_000;
    long smallPauseMls = 5 * 60_000;
    long bigPauseMls = 15 * 60_000;

    long currentTime = 0;

    CountDownTimer timer;
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
    void executionerCDTimer(TextView view, long executionStage) {

        timer = new CountDownTimer(executionStage, 1000) {
            @Override
            public void onTick(long l) {
                currentTime = l;
                cal.setTimeInMillis(l);
                view.setText(sdf.format(cal.getTimeInMillis()));
            }

            @Override
            public void onFinish() {
               view.setText("The End");
            }

        };
        timer.start();


    }

    void cancel(){
        timer.cancel();
    }



}
