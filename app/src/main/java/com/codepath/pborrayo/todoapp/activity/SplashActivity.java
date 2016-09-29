package com.codepath.pborrayo.todoapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.codepath.pborrayo.todoapp.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by pborrayo on 9/29/16.
 */
public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_DELAY = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        getSupportActionBar().hide();

        final Intent mainActivity = new Intent(this, MainActivity.class);

        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                startActivity(mainActivity);
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, SPLASH_DISPLAY_DELAY);

    }

}
