package com.zj.example.taskstack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zj.example.taskstack.cleartask.AActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, com.zj.example.taskstack.cleartop.AActivity.class));
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AActivity.class));
            }
        });


        if (getIntent() != null) {
            System.out.println("-_-_-_-_-_-_-_-_-_-_-_ZJ_TaskStack Start-_-_-_-_-_-_-_-_-_-_-_-_");
            System.out.println("getAction=" + getIntent().getAction());
            if (getIntent().getCategories() != null) {
                for (String str : getIntent().getCategories()) {
                    System.out.println("getCategories=" + str);
                }
            }
            if (getIntent().getData() != null) {
                System.out.println("schema=" + getIntent().getData().getScheme());
                System.out.println("host=" + getIntent().getData().getHost());
                System.out.println("path=" + getIntent().getData().getPath());
                System.out.println("query=" + getIntent().getData().getQuery());
            }
            System.out.println("getDataString=" + getIntent().getDataString());
            System.out.println("getComponent=" + getIntent().getComponent());
            System.out.println("-_-_-_-_-_-_-_-_-_-_-_ZJ_TaskStack End-_-_-_-_-_-_-_-_-_-_-_-_");
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        System.out.println("onNewIntent");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy");
        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, com.zj.example.taskstack.reordertofront.AActivity.class));
            }
        });
    }
}
