package com.apkfuns.xprogressdialog.sample;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.apkfuns.xprogressdialog.XProgressDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            dialog.cancel();
        }
    };

    private XProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.click1).setOnClickListener(this);
        findViewById(R.id.click2).setOnClickListener(this);
        findViewById(R.id.click3).setOnClickListener(this);
        findViewById(R.id.click4).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String msg = "数据加载中...";
        if (v.getId() == R.id.click1) {
            dialog = new XProgressDialog(this, msg, XProgressDialog.THEME_HORIZONTAL_SPOT);
        } else if (v.getId() == R.id.click2) {
            dialog = new XProgressDialog(this, msg, XProgressDialog.THEME_CIRCLE_PROGRESS);
        } else if (v.getId() == R.id.click3) {
            dialog = new XProgressDialog(this, msg, XProgressDialog.THEME_HEART_PROGRESS);
        } else if (v.getId() == R.id.click4) {
//            ProgressDialog progressDialog = new ProgressDialog(this);
////            progressDialog.setProgressStyle();
//            progressDialog.setMessage(msg);
//            progressDialog.show();
            MyProgressDialog dialog = new MyProgressDialog(this, msg);
            dialog.show();
            return;
        }
//        dialog.setMessage("1232123213");
        dialog.show();

        handler.sendMessageDelayed(new Message(), 5000L);
    }
}
