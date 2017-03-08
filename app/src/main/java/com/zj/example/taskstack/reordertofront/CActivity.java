package com.zj.example.taskstack.reordertofront;

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
                Intent intent = new Intent(CActivity.this, CActivity.class);

                /**
                 * 这个跟上边FLAG_ACTIVITY_BROUGHT_TO_FRONT的是容易混淆的.
                 * 比如说原来栈中情况是A,B,C,D,在D中启动B(加入该flag)，
                 * 栈中的情况会是A,C,D,B.(调用onNewIntent())
                 */
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

                startActivity(intent);
            }
        });
    }
}
