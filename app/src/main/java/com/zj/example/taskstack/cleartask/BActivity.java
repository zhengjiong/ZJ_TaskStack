package com.zj.example.taskstack.cleartask;

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

public class BActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        ((TextView) findViewById(R.id.textview)).setText("BActivity");
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * FLAG_ACTIVITY_CLEAR_TASK必须和FLAG_ACTIVITY_NEW_TASK一起使用,
                 * 才能达到清除task中所有activity的效果
                 */
                Intent intent = new Intent(BActivity.this, CActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
}
