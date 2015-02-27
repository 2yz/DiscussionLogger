package com.n2exp.discussionlogger.ui.activity;

import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.n2exp.discussionlogger.R;
import com.n2exp.discussionlogger.config.Constants;
import com.n2exp.discussionlogger.util.SharedPreferencesUtil;

public class SplashActivity extends BaseActivity {

    private boolean isFirstUse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SharedPreferencesUtil.setVersionCode(this);
        isFirstUse = SharedPreferencesUtil.checkIsFirstUse(this);
        if (isFirstUse) {
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    openActivitySelf(GuideActivity.class);
                }
            }, Constants.TIME_DELAY_GUIDE);
        } else {
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    openActivitySelf(MainActivity.class);
                }
            }, Constants.TIME_DELAY_SPLASH);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
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
