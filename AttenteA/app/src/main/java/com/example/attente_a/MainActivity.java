package com.example.attente_a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {


    Button btn;
    TextView tv;

    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        tv = findViewById(R.id.Tv);
        progress = findViewById(R.id.progress);
        button();
    }

    private void button() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeVisibility();
                ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
                exec.schedule(MainActivity.this::returnVisibility, 1, TimeUnit.SECONDS);

                //returnVisibility();
            }
        });
    }
    private void changeVisibility(){
        progress.setVisibility(View.VISIBLE);
        tv.setVisibility(View.GONE);
        btn.setEnabled(false);
    }
    private void returnVisibility(){
        runOnUiThread(() -> {
            progress.setVisibility(View.GONE);
            tv.setVisibility(View.VISIBLE);
            btn.setEnabled(true);
        });

    }
}