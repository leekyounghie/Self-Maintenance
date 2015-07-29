package com.demo.betterplaceplatform.self_maintenance.carchoice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo.betterplaceplatform.self_maintenance.R;

/**
 * Created by starnamu on 2015-07-15.
 */
public class CarListItem extends LinearLayout {

    Context mContext;
    ImageView PartImage;
    TextView PartName, PartPrice, Described;

    public CarListItem(Context context) {
        super(context);
        init(context);
    }

    public CarListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.carlistitem, this);
        PartImage = (ImageView) view.findViewById(R.id.PartImage);
        PartName = (TextView) view.findViewById(R.id.text01);
        PartPrice = (TextView) view.findViewById(R.id.text02);
        Described = (TextView) view.findViewById(R.id.text03);
    }

    public void setCarItem(Caritem item) {

        int CarPicture = item.getCarPicture();
        PartImage.setImageResource(CarPicture);

        String CarName = item.getPartName();
        PartName.setText(CarName);

        String CarPrice = item.getPrice();
        PartPrice.setText(CarPrice);

        String CarDescribed = item.getDescribed();
        Described.setText(CarDescribed);
    }
}
