package com.demo.betterplaceplatform.self_maintenance.toolsraental;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by starnamu on 2015-07-24.
 */
public class ChoicereftAdapter_1 extends BaseAdapter {

    String[] Craftitem;
    Context mContext;
    Choicereftview choicereftview;
    int time;

    public ChoicereftAdapter_1(Context context) {
        time = 25;
        mContext = context;
        Craftitem = new String[time];

        for (int i = 0; i < Craftitem.length; i++) {
            Craftitem[i] = String.valueOf(i * 100);
        }
    }

    @Override
    public int getCount() {
        return Craftitem.length;
    }

    @Override
    public Object getItem(int position) {
        return Craftitem[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            choicereftview = new Choicereftview(mContext);
        if (position % 2 == 0) {
            choicereftview.setBackgroundColor(Color.argb(255, 250, 255, 255));
        } else {
            choicereftview.setBackgroundColor(Color.argb(255, 240, 255, 255));
        }
        choicereftview.getRantalName(editTime(Craftitem[position]));

        return choicereftview;
    }

    private String editTime(String str) {

        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer buffer = new StringBuffer();
        String ReturnStr = new String();
        String string = new String();
        if (str.length() == 1) {
            stringBuffer.append("000");
            stringBuffer.append(str);
            ReturnStr = stringBuffer.toString();
        } else if (str.length() == 3) {
            stringBuffer.append("0");
            stringBuffer.append(str);
            ReturnStr = stringBuffer.toString();
        } else {
            ReturnStr = str;
        }
        string = ReturnStr.substring(0, 2);
        buffer.append(string);
        buffer.append(" : ");
        buffer.append("00");

        return buffer.toString();
    }
}
