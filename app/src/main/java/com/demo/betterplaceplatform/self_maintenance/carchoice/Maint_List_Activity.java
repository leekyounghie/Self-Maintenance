package com.demo.betterplaceplatform.self_maintenance.carchoice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.demo.betterplaceplatform.self_maintenance.R;
import com.demo.betterplaceplatform.self_maintenance.carrepairmap.CarRepairMapActivity;

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
        String[] CarDescribed = {"차량이나 기계의 운전 속도를 늦추기 위한 제동기",
                "혁신적인 LED 기술 또는 기존의 전구 여부에 관계없이, Bosch의 후방등은 최대 20가지의 구성 요소를 통해 최고의 신뢰성과 기능성",
                "가장기본적인 타입으로 전기적 조절장치가 들어가지않고 기계식 조절장치 적용됩니다.",
                "전기를 저장해 두고 필요할 때 끌어다 사용할 수 있는 '전기은행'이라고 말할 수 있다. 보통 수명은 2~3년 정도이지만 일상관리만 잘 ",
                "자동차 진행 방향을 다른 차량 및 보행자에게 알리는 역할을 하는 램프. 좌·우 방향지시등을 동시에 점멸시키면 비상등으로 사용된다. ",
                "자동차 에어컨 시스템에서 가장 중요한 것은 VENT를 통해 나오는 풍량이며, 배출되어지는 공기가 깨끗하게 정화된 공기만이 쾌적한",
                "열선시트는 한겨울 몸을 녹여 주고, 장마철 습기 제거용으로도 활용할 수 있다. 시중에서 파는 열선시트 부품과 SM5용 열선버튼, 전선",
                "동차용 후방감지기는 초음파로 작동되며 각 센서는 송신기와 수신기의 역할을 겸하고 있다 작동 과정을 살펴보면, 우선 센서가 송신기로 ",
                "워셔액이 담긴 워셔액통 하단에 조그만 펌프가 달려있습니다. 펌프에 자동차전원이 연결되면 워셔액을 일정한 압력으로 펌핑합니다."};
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < CarPartName.length; i++) {
                items.add(new Caritem(CarPartNo[i], CarPartName[i], CarPartPrice[i], CarDescribed[i]));
            }
        }
        return items;
    }


    public void onStartNextActivity() {
        Intent intent = new Intent(this, CarRepairMapActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
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
