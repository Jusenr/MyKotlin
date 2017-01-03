package com.myself.mykotlin.tencentx5demo;

import android.os.Bundle;

import com.myself.mykotlin.R;
import com.myself.mykotlin.base.BaseActivity;
import com.myself.mykotlin.tencentx5demo.util.X5WebView;

public class WebViewTransportActivity extends BaseActivity {
	
	X5WebView x5WebView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_webview_transport);
		
		X5WebView.setSmallWebViewEnabled(true);//开启webview窗口转移功能
		x5WebView=(X5WebView) findViewById(R.id.full_web_webview);
		x5WebView.loadUrl("file:///android_asset/webpage/creat_new_window.html");//提供能够创建新窗口的web页面
		
	}

}
