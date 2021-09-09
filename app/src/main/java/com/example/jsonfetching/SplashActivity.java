package com.example.jsonfetching;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    TextView tv_splash_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tv_splash_text = findViewById(R.id.splash_text);
        tv_splash_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        Intent myIntent = new Intent(SplashActivity.this, MainActivity.class);
                       startActivity(myIntent);

            }
        });
    }

}