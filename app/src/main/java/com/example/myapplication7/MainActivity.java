package com.example.myapplication7;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_SKREEN=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

new Handler().postDelayed(new Runnable() {
    @Override
    public void run() {
Intent intent=new Intent(MainActivity.this, SingInActivity.class);
startActivity(intent);
    }
},SPLASH_SKREEN);


    }
}