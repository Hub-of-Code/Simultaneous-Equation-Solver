package com.example.zucky.simultaneousequationsolverv10;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;


public class MainActivity extends Activity {
    int counter=0;
    ImageView i1,i2,i3,i4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i1 = (ImageView) findViewById(R.id.I1);
        i2 = (ImageView) findViewById(R.id.I2);
        i3 = (ImageView) findViewById(R.id.I3);
        i4 = (ImageView) findViewById(R.id.I4);
        new CountDownTimer(6000,200) {
            public void onTick(long UntilFinish) {
                counter++;
                if (counter == 1) {
                    i1.setBackgroundColor(Color.CYAN);
                    i2.setBackgroundColor(Color.WHITE);
                    i3.setBackgroundColor(Color.WHITE);
                    i4.setBackgroundColor(Color.WHITE);
                }
                if (counter == 2) {
                    i1.setBackgroundColor(Color.WHITE);
                    i2.setBackgroundColor(Color.CYAN);
                    i3.setBackgroundColor(Color.WHITE);
                    i4.setBackgroundColor(Color.WHITE);
                }
                if (counter == 3) {
                    i1.setBackgroundColor(Color.WHITE);
                    i2.setBackgroundColor(Color.WHITE);
                    i3.setBackgroundColor(Color.CYAN);
                    i4.setBackgroundColor(Color.WHITE);
                }
                if (counter == 4) {
                    i1.setBackgroundColor(Color.WHITE);
                    i2.setBackgroundColor(Color.WHITE);
                    i3.setBackgroundColor(Color.WHITE);
                    i4.setBackgroundColor(Color.CYAN);
                }
                if (counter == 4) {
                    counter = 0;

                }
            }
            public void onFinish(){
              openActivity2();
            }
        }.start();
    }
    public void openActivity2(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
        MainActivity.this.finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
