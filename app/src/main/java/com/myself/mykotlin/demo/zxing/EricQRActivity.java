package com.myself.mykotlin.demo.zxing;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.myself.mykotlin.R;
import com.myself.mykotlin.utils.StringUtils;

import java.util.Hashtable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EricQRActivity extends AppCompatActivity {

    @BindView(R.id.img_touxiang)
    ImageView mImgTouxiang;
    @BindView(R.id.edit_password)
    EditText mEditPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eric_qr);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_change, R.id.btn_scan, R.id.btn_reset, R.id.text_loginpro})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_change:
                try {
                    String code = mEditPassword.getText().toString();
                    if (StringUtils.isEmpty(code))
                        Toast.makeText(this, "内容不能为空", Toast.LENGTH_SHORT).show();
                    else {
                        Bitmap codeBitmap = EncodingHandler.createQRCode(code, 220);
                        mImgTouxiang.setImageBitmap(codeBitmap);
                    }
                } catch (WriterException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_scan:
                Intent intent = new Intent();
                intent.setClass(EricQRActivity.this, CaptureActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_reset:
                mEditPassword.setText("");
                break;
            case R.id.text_loginpro:
                finish();
                break;
        }
    }

    //生成二维码
    public final static class EncodingHandler {
        private static final int BLACK = 0xff000000;

        public static Bitmap createQRCode(String str, int widthAndHeight) throws WriterException {
            Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            BitMatrix matrix = new MultiFormatWriter().encode(str,
                    BarcodeFormat.QR_CODE, widthAndHeight, widthAndHeight, hints);
            int width = matrix.getWidth();
            int height = matrix.getHeight();
            int[] pixels = new int[width * height];

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (matrix.get(x, y)) {
                        pixels[y * width + x] = BLACK;
                    }
                }
            }
            Bitmap bitmap = Bitmap.createBitmap(width, height,
                    Bitmap.Config.ARGB_8888);
            bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
            return bitmap;
        }
    }
}
