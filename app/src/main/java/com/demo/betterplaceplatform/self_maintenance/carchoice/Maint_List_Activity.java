package com.demo.betterplaceplatform.self_maintenance.carchoice;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.demo.betterplaceplatform.self_maintenance.R;

import java.util.ArrayList;


public class Maint_List_Activity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymaint_list);
        init();
    }

    public void init() {
        ListView listView = (ListView) findViewById(R.id.CarChoice);

        ArrayList<Caritem> items = setData();

        CarListAdapter carListAdapter = new CarListAdapter(items, this);
        listView.setAdapter(carListAdapter);
    }

    public ArrayList<Caritem> setData() {
        ArrayList<Caritem> items = new ArrayList<>();
        int[] CarPartNo = {R.drawable.car_1, R.drawable.car_2, R.drawable.car_3, R.drawable.car_4,
                R.drawable.car_5, R.drawable.car_6, R.drawable.car_7, R.drawable.car_8, R.drawable.car_9};
        String[] CarPartName = {"브레이크", "후방 등", "에어 쇼바", "밧데리",
                "방향 지시등", "항균필터", "시트 열선", "후방 센서", "워셔 노즐"};
        String[] CarPartPrice = {"78,000", "110,000", "55,000", "65,000",
                "27.000", "33,000", "15,000", "39,000", "42000"};
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < CarPartName.length; i++) {
                items.add(new Caritem(CarPartNo[i], CarPartName[i], CarPartPrice[i]));
            }
        }
        return items;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_maint__list, menu);
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
