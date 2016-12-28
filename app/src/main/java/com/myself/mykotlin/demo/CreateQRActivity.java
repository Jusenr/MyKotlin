package com.myself.mykotlin.demo;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.myself.mykotlin.R;
import com.myself.mykotlin.base.BaseActivity;
import com.myself.mykotlin.utils.BitmapLoader;
import com.myself.mykotlin.utils.StringUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.myself.mykotlin.R.id.btn_confirm;

public class CreateQRActivity extends BaseActivity {
    private static final String TAG = CreateQRActivity.class.getSimpleName();

    @BindView(R.id.et_0)
    EditText mEt0;
    @BindView(R.id.tv_0)
    TextView mTv0;
    @BindView(R.id.iv_0)
    ImageView mIv0;
    @BindView(btn_confirm)
    Button mBtnConfirm;
    @BindView(R.id.btn_create_qrcode)
    Button mBtnCreateQrcode;


    private String base_url = "http://qr.topscan.com/api.php";
    private String qrcodeColor = "bg=f3f3f3&fg=ff0000&gc=222222&el=l&w=200&m=10";
    private String textInfo = "http://blog.csdn.net/github_35033182";

    private StringBuffer mBuffer;
    private StringBuffer mShowInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_qr);
        ButterKnife.bind(this);

        //注意：StringBuffer必须用字符长度来做非空判断
        mShowInfo = new StringBuffer();
        mBuffer = new StringBuffer();

        initData();
    }

    private void initData() {
        mBuffer.append(base_url);
        mBuffer.append("?" + qrcodeColor);
        mBuffer.append("&text=");
    }

    private void confirmInfo() {
        String mInfo = mEt0.getText().toString().trim();
        if (!StringUtils.isEmpty(mInfo)) {
            mShowInfo.append(mInfo + "\r\n");
            mBuffer.append(mInfo);
        }
        if (mShowInfo.length() >= 1)
            mTv0.setText(mShowInfo.toString());

        mEt0.setText("");
    }

    private void createQRCode() {
        if (mBuffer.length() < 1) {
            initData();
            if (mShowInfo.length() < 1)
                mBuffer.append(textInfo);
            else
                mBuffer.append(mShowInfo.toString());
        } else {
            if (mShowInfo.length() < 1)
                mBuffer.append(textInfo);
            else
                mBuffer.append(mShowInfo.toString());
        }
        String url = mBuffer.toString();
        mTv0.setText(url);
        mTv0.setTextColor(Color.DKGRAY);
        Log.v(TAG, "createQRCode: url-->" + url);
        BitmapLoader.newInstance(this).load(url, new BitmapLoader.BitmapCallback() {
            @Override
            public void onResult(Bitmap bitmap) {
                mIv0.setImageBitmap(bitmap);
            }
        });
        mShowInfo.delete(0, mShowInfo.length());
        mBuffer.delete(0, mBuffer.length());
    }

    @OnClick({btn_confirm, R.id.btn_create_qrcode, R.id.fl_default})
    public void onClick(View view) {
        switch (view.getId()) {
            case btn_confirm:
                confirmInfo();
                break;
            case R.id.btn_create_qrcode:
                createQRCode();
                break;
            case R.id.fl_default:
                if (mBuffer.length() < 1)
                    initData();
                String url = mBuffer.append(textInfo).toString();
                mTv0.setText(url);
                BitmapLoader.newInstance(this).load(url, new BitmapLoader.BitmapCallback() {
                    @Override
                    public void onResult(Bitmap bitmap) {
                        mIv0.setImageBitmap(bitmap);
                        mBuffer.delete(0, mBuffer.length());
                    }
                });
                break;
        }
    }
}
