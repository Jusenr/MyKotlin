package com.myself.mykotlin;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.myself.mykotlin.base.BaseActivity;
import com.myself.mykotlin.demo.CreateQRActivity;
import com.myself.mykotlin.demo.NoteActivity;
import com.myself.mykotlin.demo.ecodetest.EcodeActivity;
import com.myself.mykotlin.demo.zxing.CaptureActivity;
import com.myself.mykotlin.demo.zxing.EricQRActivity;
import com.myself.mykotlin.tencentx5demo.MiniQBActivity;
import com.myself.mykotlin.tencentx5demo.TencentX5Activity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9, R.id.btn_10, R.id.btn_11, R.id.btn_12, R.id.btn_13, R.id.btn_14, R.id.btn_15, R.id.btn_16, R.id.btn_17, R.id.btn_18, R.id.btn_19, R.id.btn_20, R.id.btn_21, R.id.btn_22, R.id.btn_23, R.id.btn_24, R.id.btn_25, R.id.btn_26, R.id.btn_27, R.id.btn_28, R.id.btn_29})
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
            case R.id.btn_4:
                startActivity(NoteActivity.class);
                break;
            case R.id.btn_5:
                startActivity(TencentX5Activity.class);
                break;
            case R.id.btn_6:
                startActivity(MiniQBActivity.class);
                break;
            case R.id.btn_7:
//                startActivity(NoteActivity.class);
                break;
            case R.id.btn_8:
//                startActivity(TencentX5Activity.class);
                break;
            case R.id.btn_9:
//                startActivity(MiniQBActivity.class);
                break;
            case R.id.btn_10:
//                startActivity(CreateQRActivity.class);
                break;
            case R.id.btn_11:
//                startActivity(CaptureActivity.class);
                break;
            case R.id.btn_12:
//                startActivity(EcodeActivity.class);
                break;
            case R.id.btn_13:
//                startActivity(EricQRActivity.class);
                break;
            case R.id.btn_14:
//                startActivity(NoteActivity.class);
                break;
            case R.id.btn_15:
//                startActivity(TencentX5Activity.class);
                break;
            case R.id.btn_16:
//                startActivity(MiniQBActivity.class);
                break;
            case R.id.btn_17:
//                startActivity(NoteActivity.class);
                break;
            case R.id.btn_18:
//                startActivity(TencentX5Activity.class);
                break;
            case R.id.btn_19:
//                startActivity(MiniQBActivity.class);
                break;
            case R.id.btn_20:
//                startActivity(CreateQRActivity.class);
                break;
            case R.id.btn_21:
//                startActivity(CaptureActivity.class);
                break;
            case R.id.btn_22:
//                startActivity(EcodeActivity.class);
                break;
            case R.id.btn_23:
//                startActivity(EricQRActivity.class);
                break;
            case R.id.btn_24:
//                startActivity(NoteActivity.class);
                break;
            case R.id.btn_25:
//                startActivity(TencentX5Activity.class);
                break;
            case R.id.btn_26:
//                startActivity(MiniQBActivity.class);
                break;
            case R.id.btn_27:
//                startActivity(NoteActivity.class);
                break;
            case R.id.btn_28:
//                startActivity(TencentX5Activity.class);
                break;
            case R.id.btn_29:
//                startActivity(MiniQBActivity.class);
                break;
        }
        view.setBackgroundColor(Color.LTGRAY);
    }
}
