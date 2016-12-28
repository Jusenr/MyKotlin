package com.myself.mykotlin;

import android.os.Bundle;
import android.view.View;

import com.myself.mykotlin.base.BaseActivity;
import com.myself.mykotlin.demo.CreateQRActivity;
import com.myself.mykotlin.demo.ecodetest.EcodeActivity;
import com.myself.mykotlin.demo.zxing.CaptureActivity;
import com.myself.mykotlin.demo.zxing.EricQRActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_0:
                startActivity(CreateQRActivity.class);
                break;
            case R.id.btn_1:
                startActivity(CaptureActivity.class);
                break;
            case R.id.btn_2:
                startActivity(EcodeActivity.class);
                break;
            case R.id.btn_3:
                startActivity(EricQRActivity.class);
                break;
        }
    }
}
