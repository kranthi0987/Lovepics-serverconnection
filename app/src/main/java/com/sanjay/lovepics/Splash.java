package com.sanjay.lovepics;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.sanjay.lovepics.utils.ApplicationUtility;
import com.sanjay.lovepics.utils.URLContent;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {
//    URLContent httpContent = new URLContent(this);
//    String test =  httpContent.getContent("http://api.aroundtirupati.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Timer t = new Timer();
        boolean checkConnection=new ApplicationUtility().checkConnection(this);
        if (checkConnection) {
            t.schedule(new splash(), 3000);
        } else {


            Toast.makeText(this,
                    "connection not found...plz check connection", Toast.LENGTH_LONG).show();
        }
    }

    class splash extends TimerTask {

        @Override
        public void run() {
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            finish();
            startActivity(i);
        }


    }
}
