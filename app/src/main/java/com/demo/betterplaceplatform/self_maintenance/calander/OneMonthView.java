package com.demo.betterplaceplatform.self_maintenance.calander;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by starnamu on 2015-07-16.
 */
public class OneMonthView extends LinearLayout implements View.OnClickListener {


    private static final String TAG = MConfig.TAG;
    private static final String NAME = "OneMonthView";
    private final String CLASS = NAME + "@" + Integer.toHexString(hashCode());

    private Context mContext;
    private int mYear;
    private int mMonth;

    public OneMonthView(Context context) {
        this(context, null);
    }

    public OneMonthView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OneMonthView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        mContext = context;

        setOrientation(LinearLayout.VERTICAL);

        //뷰를 미리 넉넉한 만큼 만들어 놓는다.
        if (weeks == null) {

            weeks = new ArrayList<LinearLayout>(6); //한달에 최대 6주
            dayViews = new ArrayList<OneDayView>(42); // 7일 * 6주 = 42

            LinearLayout ll = null;
            for (int i = 0; i < 42; i++) {

                if (i % 7 == 0) {
                    //한 주 레이아웃 생성
                    ll = new LinearLayout(mContext);
                    LinearLayout.LayoutParams params
                            = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0);
                    params.weight = 1;
                    ll.setOrientation(LinearLayout.HORIZONTAL);
                    ll.setLayoutParams(params);
                    ll.setWeightSum(7);

                    weeks.add(ll);
                }

                LinearLayout.LayoutParams params
                        = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
                params.weight = 1;

                OneDayView ov = new OneDayView(mContext);
                ov.setLayoutParams(params);
                ov.setOnClickListener(this);

                ll.addView(ov);
                dayViews.add(ov);
            }
        }

        //미리보기
        if (isInEditMode()) {
            Calendar cal = Calendar.getInstance();
            make(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH));
        }

    }

    /**
     * 년
     *
     * @return 4자리 년도
     */
    public int getYear() {
        return mYear;
    }

    /**
     * 달
     *
     * @return 0~11 (Calendar.JANUARY ~ Calendar.DECEMBER)
     */
    public int getMonth() {
        return mMonth;
    }


    /**
     * Any layout manager that doesn't scroll will want this.
     */
    @Override
    public boolean shouldDelayChildPressedState() {
        return false;
    }


    private ArrayList<LinearLayout> weeks = null;
    private ArrayList<OneDayView> dayViews = null;

    public void make(int year, int month) {
        if (mYear == year && mMonth == month) {
            HLog.d(TAG, CLASS, ">>>>> same " + year + "." + month);
            return;
        }

        long makeTime = System.currentTimeMillis();
        HLog.d(TAG, CLASS, ">>>>> make");

        this.mYear = year;
        this.mMonth = month;

        //if(viewRect.width() == 0 || viewRect.height() == 0) return;

        Calendar cal = Calendar.getInstance();
        cal.set(year, month, 1);
        cal.setFirstDayOfWeek(Calendar.SUNDAY);//일요일을 주의 시작일로 지정

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);//1일의 요일
        int maxOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);//마지막 일수
        ArrayList<OneDayData> oneDayDatas = new ArrayList<OneDayData>();

        cal.add(Calendar.DAY_OF_MONTH, Calendar.SUNDAY - dayOfWeek);//주의 첫 일로 이동
        //HLog.d(TAG, CLASS, "first day : " + cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.KOREA) + " / " + cal.get(Calendar.DAY_OF_MONTH));

        /* add previous month */
        int seekDay;
        for (; ; ) {
            seekDay = cal.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek == seekDay) break;

            OneDayData one = new OneDayData();
            one.setDay(cal);
            oneDayDatas.add(one);
            //하루 증가
            cal.add(Calendar.DAY_OF_MONTH, 1);
        }

        //HLog.d(TAG, CLASS, "this month : " + cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.KOREA) + " / " + cal.get(Calendar.DAY_OF_MONTH));
        /* add this month */
        for (int i = 0; i < maxOfMonth; i++) {
            OneDayData one = new OneDayData();
            one.setDay(cal);
            oneDayDatas.add(one);
            //하루 증가
            cal.add(Calendar.DAY_OF_MONTH, 1);
        }

        /* add next month */
        for (; ; ) {
            if (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                OneDayData one = new OneDayData();
                one.setDay(cal);
                oneDayDatas.add(one);
            } else {
                break;
            }
            //하루 증가
            cal.add(Calendar.DAY_OF_MONTH, 1);
        }

        if (oneDayDatas.size() == 0) return;

        //모든 주를 지우기
        this.removeAllViews();

        int count = 0;
        for (OneDayData oneday : oneDayDatas) {

            if (count % 7 == 0) {
                addView(weeks.get(count / 7));
            }
            OneDayView ov = dayViews.get(count);
            ov.setDay(oneday);
            ov.setMsg("");
            ov.refresh();
            count++;
        }

        /* 주의 개수만큼 무게 지정*/
        this.setWeightSum(getChildCount());


        HLog.d(TAG, CLASS, "<<<<< take timeMillis : " + (System.currentTimeMillis() - makeTime));

    }


    protected String doubleString(int value) {

        String temp;

        if (value < 10) {
            temp = "0" + String.valueOf(value);

        } else {
            temp = String.valueOf(value);
        }
        return temp;
    }

    @Override
    public void onClick(View v) {

        OneDayView ov = (OneDayView) v;
        HLog.d(TAG, CLASS, "click " + ov.get(Calendar.MONTH) + "/" + ov.get(Calendar.DAY_OF_MONTH));

        ((Calandar_Activity) mContext).onStartNextActivity();

    }
}
