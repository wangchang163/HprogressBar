package com.example.testing.hprogressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.testing.library.HprogressView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HprogressView hProgressView= (HprogressView) findViewById(R.id.hProgressView);
        hProgressView.startAnim();
    }
}
