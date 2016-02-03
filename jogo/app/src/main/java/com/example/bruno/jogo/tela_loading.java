package com.example.bruno.jogo;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class tela_loading extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_loading);
        getSupportActionBar().hide();
        Thread t = new Thread(){
            public void run()
            {
              try
              {
                sleep(1000);
                startActivity(new Intent(tela_loading.this,rodando.class));

              } catch (InterruptedException e) {
                  e.printStackTrace();
              } finally{
                  finish();
              }
            }
        };
        t.start();

    }


}
