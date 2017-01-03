package com.myself.mykotlin.tencentx5demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.myself.mykotlin.R;
import com.myself.mykotlin.tencentx5demo.util.X5WebView;

public class MiniQBActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_qb);

//        WebView wv_wevview = (WebView) findViewById(R.id.wv_wevview);
//        wv_wevview.loadUrl("http://blog.csdn.net/github_35033182");

        X5WebView wv_X5WebView = (X5WebView) findViewById(R.id.wv_X5WebView);
        wv_X5WebView.loadUrl("http://blog.csdn.net/github_35033182");
    }
}
