package com.example.countdown;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView days, sec, minutes, months, hours;
    private TextView mTextField1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        days = (TextView)findViewById(R.id.textView);
        months = (TextView)findViewById(R.id.textView2);
        minutes = (TextView)findViewById(R.id.textView3);
        sec = (TextView)findViewById(R.id.textView4);
        hours = (TextView)findViewById(R.id.textView5);


        new CountDownTimer(dateToMilliSeconds(224,8,2020,12,0),1000) {

            public void onTick(long millisUntilFinished) {
                Calendar c = Calendar.getInstance();
                c.setTime(new Date());
                int dom = c.get(Calendar.DAY_OF_MONTH);
                int hod = c.get(Calendar.HOUR_OF_DAY);
                int moh = c.get(Calendar.MINUTE);
                int som = c.get(Calendar.SECOND);
                int mon = c.get(Calendar.MONTH);
                int dim;

                dim = 29;
                int daysLeft = (dim - dom) + 12;
                String monthsleft=Integer.toString(7 - mon);
                String hoursLeft = Integer.toString(23 - hod);
                String minutesLeft = Integer.toString(60 - moh);
                String secondsLeft = Integer.toString(60 - som);

                if (hoursLeft.length() < 2) {
                    hoursLeft = "0" + hoursLeft;
                }

                if (minutesLeft.length() < 2) {
                    minutesLeft = "0" + minutesLeft;
                }
                days.setText("Днів: " + daysLeft);
                months.setText("Місяців: " + monthsleft);
                minutes.setText("Хвилин: " + minutesLeft);
                sec.setText("Секунд: " + secondsLeft);
                hours.setText("Годин: " + hoursLeft);
            }

            public void onFinish() {
                days.setText("З Днем Народження!");
            }
        }.start();
    }

    public long dateToMilliSeconds(int day, int month, int year, int hour, int minute)  {

        Calendar c = Calendar.getInstance();
        c.set(year, month, day, hour, minute, 00);

        return c.getTimeInMillis();
    }

}
