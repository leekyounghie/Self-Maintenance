package com.demo.betterplaceplatform.self_maintenance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.demo.betterplaceplatform.self_maintenance.carchoice.Maint_List_Activity;
import com.demo.betterplaceplatform.self_maintenance.push.logic.InstanceIdHelper;
import com.demo.betterplaceplatform.self_maintenance.push.model.SenderCollection;

public class MainActivity extends ActionBarActivity {
    private InstanceIdHelper mInstanceIdHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intentSubActivity =
                new Intent(MainActivity.this, Maint_List_Activity.class);
        startActivity(intentSubActivity);

        mInstanceIdHelper = new InstanceIdHelper(getApplicationContext());
        mInstanceIdHelper.getGcmTokenInBackground(SenderCollection.DEFAULT_SENDER_ID);

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
