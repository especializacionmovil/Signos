package com.example.jaimea.signos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {

    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        progressBar= (ProgressBar) findViewById(R.id.progressbar);
        Thread tiempoejecucion = new Thread() {
            public void run () {
                try{
                    sleep(5000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(SplashActivity.this, MenuActivity.class);
                    startActivity(intent);

                }
            }
        };
        progressBar.setVisibility(View.VISIBLE);
        tiempoejecucion.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        progressBar.setVisibility(View.GONE);
        finish();
    }
}
