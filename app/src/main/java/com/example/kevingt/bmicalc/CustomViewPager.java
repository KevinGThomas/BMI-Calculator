package com.example.kevingt.bmicalc;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Kevin GT on 7/30/2018.
 */

public class CustomViewPager extends ViewPager {


    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    //to disable swipping using finger

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

}
