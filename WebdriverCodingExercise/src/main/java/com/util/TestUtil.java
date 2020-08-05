package com.util;

import com.base.TestBase;

import java.util.Calendar;
import java.util.TimeZone;

public class TestUtil extends TestBase {
    public static long PAGE_LOAD_TIMEOUT = 60;
    public static long IMPLICIT_WAIT = 20;

    //Me
    public static String getCurrenDayofWeek(){
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        int today=calendar.get(Calendar.DAY_OF_WEEK);
        String currenDayofWeek="";
        switch(today)
        {
            case 1:
                currenDayofWeek="SUN";
                break;
            case 2:
                currenDayofWeek="MON";
                break;
            case 3:
                currenDayofWeek="TUE";
                break;
            case 4:
                currenDayofWeek="WED";
                break;
            case 5:
                currenDayofWeek="THU";
                break;
            case 6:
                currenDayofWeek="FRI";
                break;
            case 7:
                currenDayofWeek="SAT";
                break;
            default:
                System.out.println("Default ");
        }

        return currenDayofWeek;
    }
}
