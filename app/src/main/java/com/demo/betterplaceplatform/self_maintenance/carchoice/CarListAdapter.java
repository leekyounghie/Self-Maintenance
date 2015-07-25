package com.demo.betterplaceplatform.self_maintenance.carchoice;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by starnamu on 2015-07-15.
 */
public class CarListAdapter extends BaseAdapter {

    ArrayList<Caritem> items;
    Context mContext;

    public CarListAdapter(ArrayList<Caritem> items, Context context) {
        this.items = items;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CarListItem view = new CarListItem(mContext);
        view.setCarItem(items.get(position));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Maint_List_Activity) mContext).onStartNextActivity();
            }
        });
        return view;
    }
}
