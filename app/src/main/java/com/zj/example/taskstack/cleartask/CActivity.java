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

public class CActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        ((TextView) findViewById(R.id.textview)).setText("CActivity");
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * FLAG_ACTIVITY_CLEAR_TASK必须和FLAG_ACTIVITY_NEW_TASK一起使用,
                 * 才能达到清除task中所有activity的效果
                 */
                Intent intent = new Intent(CActivity.this, BActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                /**
                 * 这里如果加了singleTop也是没有作用的, BActivity一样会重新onCreate
                 */
                //intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("CActivity onDestroy");
    }
}
