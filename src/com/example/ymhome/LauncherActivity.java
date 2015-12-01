package com.example.ymhome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;


/**
 * Created by Jyan on 2015/11/30.
 * Mail:jyan.lin@foxmail.com
 */
public class LauncherActivity extends Activity {
//    private Handler handler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            Intent intent = new Intent(LauncherActivity.this, GuideActivity.class);
//            startActivity(intent);
//            finish();
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

//        handler.sendEmptyMessageDelayed(0, 1500);
        getWindow().getDecorView().setBackgroundResource(R.drawable.bg_startup_launcher);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LauncherActivity.this,GuideActivity.class);
                startActivity(intent);
                LauncherActivity.this.finish();
            }
        },1500);
    }
}
