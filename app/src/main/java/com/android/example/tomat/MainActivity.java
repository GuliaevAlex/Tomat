package com.android.example.tomat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    long timeForTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        TextView visualTimer = (TextView) findViewById(R.id.VisualTimer);

        Button start = (Button) findViewById(R.id.start);
        Button stop = (Button) findViewById(R.id.stop);

        Button workTime = (Button) findViewById(R.id.WorkTime);
        Button smallPause = (Button) findViewById(R.id.SmallPause);
        Button longPause = (Button) findViewById(R.id.LongPause);

        CustomTimer customTimer = new CustomTimer();

        timeForTimer = 0;

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");


        View.OnClickListener onClickListenerWorkTimeBtn = view -> {
            timeForTimer = customTimer.workTimeMinutesMls;
            cal.setTimeInMillis(timeForTimer);
            visualTimer.setText(String.valueOf(sdf.format(cal.getTimeInMillis())));
        };
        workTime.setOnClickListener(onClickListenerWorkTimeBtn);

        View.OnClickListener onClickListenerSmallPauseBtn = view -> {
            timeForTimer = customTimer.smallPauseMls;
            cal.setTimeInMillis(timeForTimer);
            visualTimer.setText(String.valueOf(sdf.format(cal.getTimeInMillis())));
        };
        smallPause.setOnClickListener(onClickListenerSmallPauseBtn);

        View.OnClickListener onClickListenerLongPauseBtn = view -> {
            timeForTimer = customTimer.bigPauseMls;
            cal.setTimeInMillis(timeForTimer);
            visualTimer.setText(String.valueOf(sdf.format(cal.getTimeInMillis())));
        };
        longPause.setOnClickListener(onClickListenerLongPauseBtn);


        View.OnClickListener onClickListenerStartBtn =
                view ->
                        customTimer.executionerCDTimer(visualTimer, timeForTimer);
        start.setOnClickListener(onClickListenerStartBtn);

        View.OnClickListener onClickListenerStopBtn = view ->{
            timeForTimer = customTimer.currentTime;
                customTimer.cancel();

        };
        stop.setOnClickListener(onClickListenerStopBtn);


    }


}
