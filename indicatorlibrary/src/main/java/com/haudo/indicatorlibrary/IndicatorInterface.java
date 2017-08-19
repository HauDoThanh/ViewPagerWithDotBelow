package com.haudo.indicatorlibrary;

import android.support.v4.view.ViewPager;

/**
 * Created by admin on 8/18/2017.
 */

public interface IndicatorInterface {

    void setViewPager(ViewPager viewPager) throws PagesLessException;

    void setRadiusSelected(int radius);

    void setRadiusUnSelected(int radius);

    void setDistanceDot(int distan);


    public class PagesLessException extends Exception{
        @Override
        public String getMessage() {
            return "Page must equal larger than 2";
        }
    }
}
