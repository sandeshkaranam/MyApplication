package com.example.kssand.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by kssand on 18-Feb-15.
 */
public class LaunchActivity extends Activity {
    private static final long DELAY = 1000;
    private boolean scheduled = false;
    private Timer splashTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch);

        /*splashTimer = new Timer();
        splashTimer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                LaunchActivity.this.finish();
                startActivity(new Intent(LaunchActivity.this, MainActivity.class));
            }
        },DELAY);
        scheduled = true;*/
        new Handler().postDelayed(new Runnable() {

            // Using handler with postDelayed called runnable run method

            @Override
            public void run() {
                Intent i = new Intent(LaunchActivity.this, MainActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, 40*1000);
      //  new AsyncLoadXMLFeed().execute();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        /*if (scheduled)
            splashTimer.cancel();
        splashTimer.purge();*/
    }
    private class AsyncLoadXMLFeed extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            // show your progress dialog

        }

        @Override
        protected Void doInBackground(Void... voids) {
            // load your xml feed asynchronously

            return null;
        }

        @Override
        protected void onPostExecute(Void params) {
            // dismiss your dialog
            // launch your News activity
      /*      Thread loading = new Thread() {
                public void run() {
                    try {
                        sleep(5000);

                        startActivity(new Intent(LaunchActivity.this, MainActivity.class));
                    }

                    catch (Exception e) {
                        e.printStackTrace();
                    }

                    finally {
                        finish();
                    }
                }
            };

            loading.start();*/

            // close this activity
            finish();
        }
    }
}
