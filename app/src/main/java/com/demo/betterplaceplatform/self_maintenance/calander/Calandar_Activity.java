package com.demo.betterplaceplatform.self_maintenance.calander;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.demo.betterplaceplatform.self_maintenance.R;
import com.demo.betterplaceplatform.self_maintenance.toolsraental.CarToolsRantal;

public class Calandar_Activity extends FragmentActivity {


    private static final String TAG = MConfig.TAG;
    private static final String NAME = "MainActivity";
    private final String CLASS = NAME + "@" + Integer.toHexString(hashCode());

    Button addButton, monthButton, weekButton, dayButton;
    TextView thisMonthTv;
    int current, mSelectedIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calandar_activity);

        addButton = (Button) findViewById(R.id.main_add_bt);
        monthButton = (Button) findViewById(R.id.main_monthly_bt);
        weekButton = (Button) findViewById(R.id.main_weekly_bt);
        dayButton = (Button) findViewById(R.id.main_daily_bt);
        thisMonthTv = (TextView) findViewById(R.id.this_month_tv);

        MonthlyFragment mf = (MonthlyFragment) getSupportFragmentManager().findFragmentById(R.id.monthly);
        mf.setOnMonthChangeListener(new MonthlyFragment.OnMonthChangeListener() {

            @Override
            public void onChange(int year, int month) {
                HLog.d(TAG, CLASS, "onChange " + year + "." + month);
                thisMonthTv.setText(year + "." + (month + 1));
            }
        });

    }

    public void onStartNextActivity() {
        Intent intent = new Intent(this, CarToolsRantal.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calandar, menu);
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
