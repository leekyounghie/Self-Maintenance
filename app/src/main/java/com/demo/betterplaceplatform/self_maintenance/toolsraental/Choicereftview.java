package com.demo.betterplaceplatform.self_maintenance.toolsraental;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo.betterplaceplatform.self_maintenance.R;

/**
 * Created by starnamu on 2015-07-24.
 */
public class Choicereftview extends LinearLayout {

    public TextView textView;

    public Choicereftview(Context context) {
        super(context);
        init(context);
    }

    public Choicereftview(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = inflater.inflate(R.layout.choicereftview, this);
        textView = (TextView) v.findViewById(R.id.rantalname);

        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setBackgroundColor(Color.argb(255, 250, 255, 71));
            }
        });
    }

    public void getRantalName(String str) {
        textView.setText(str);
    }
}
