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

public class CActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        ((TextView) findViewById(R.id.textview)).setText("CActivity");
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CActivity.this, AActivity.class);

                /**
                 * 如果只加FLAG_ACTIVITY_CLEAR_TOP,不加FLAG_ACTIVITY_SINGLE_TOP,会清除掉AActivity之上所有的activity,
                 * 之下的MainActivity不会清楚,
                 * 最重要的是之前的AActivity会onDestroy,并重新onCreate一次:
                 * 02-28 22:30:35.507 30938-30938/com.zj.example.taskstack I/System.out: AActivity onDestroy
                 * 02-28 22:30:35.535 30938-30938/com.zj.example.taskstack I/System.out: AActivity onCreate
                 */
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                /**
                 * 如果加上FLAG_ACTIVITY_SINGLE_TOP和FLAG_ACTIVITY_CLEAR_TOP一起,
                 * AActivity不会onDestroy,会执行onNewIntent方法
                 */
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });
    }
}
