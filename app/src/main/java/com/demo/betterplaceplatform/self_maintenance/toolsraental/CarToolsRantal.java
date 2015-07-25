package com.demo.betterplaceplatform.self_maintenance.toolsraental;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.demo.betterplaceplatform.self_maintenance.R;
import com.demo.betterplaceplatform.self_maintenance.payment.Payment_Activity;

public class CarToolsRantal extends ActionBarActivity {

    ListView setLiftChoice_01, setLiftChoice_02, setLiftChoice_03;
    Button Payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cartoolsrantal_activity);

        ChoicereftAdapter_1 choicereftAdapter_1 = new ChoicereftAdapter_1(this);
        ChoicereftAdapter_2 choicereftAdapter_2 = new ChoicereftAdapter_2(this);
        ChoicereftAdapter_3 choicereftAdapter_3 = new ChoicereftAdapter_3(this);

        setLiftChoice_01 = (ListView) findViewById(R.id.setLiftChoice_01);
        setLiftChoice_02 = (ListView) findViewById(R.id.setLiftChoice_02);
        setLiftChoice_03 = (ListView) findViewById(R.id.setLiftChoice_03);

        Payment = (Button) findViewById(R.id.Payment);

        setLiftChoice_01.setAdapter(choicereftAdapter_1);
        setLiftChoice_02.setAdapter(choicereftAdapter_2);
        setLiftChoice_03.setAdapter(choicereftAdapter_3);

        Payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Payment_Activity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cartoolsrantal, menu);
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
