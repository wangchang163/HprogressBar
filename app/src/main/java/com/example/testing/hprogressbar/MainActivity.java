package com.example.testing.hprogressbar;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.testing.library.HprogressView;

public class MainActivity extends AppCompatActivity {

    private HprogressView hProgressView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hProgressView= (HprogressView) findViewById(R.id.hProgressView);
//        hProgressView.startAnim();

        final Handler handler=new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {
                switch (message.what){
                    case 1:
                        hProgressView.setProgress(message.arg1);
                        break;
                }
                return false;
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<101;i++){
                    Message message=new Message();
                    message.what=1;
                    message.arg1=i;
                    handler.sendMessage(message);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
