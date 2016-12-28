package com.myself.mykotlin.demo.ecodetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class EcodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EcodeingView ev = new EcodeingView(this);
        setContentView(ev);
    }
}
