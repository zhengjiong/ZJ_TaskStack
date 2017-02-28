package com.zj.example.taskstack.cleartop;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.zj.example.taskstack.R;

/**
 * Created by zj on 2017/2/28.
 */

public class AActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        System.out.println("AActivity onCreate");
        ((TextView) findViewById(R.id.textview)).setText("AActivity");
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AActivity.this, BActivity.class));
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        System.out.println("AActivity onNewIntent");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("AActivity onDestroy");
    }
}
