package com.android.cristiangallego.intents;

import java.io.Serializable;

/**
 * Created by USUARIO on 26/03/2017.
 */

public class DateTime implements Serializable {
    private int Day;

    public int getYear() {
        return Year;
    }

    public int getDay() {
        return Day;
    }

    public int getMonth() {
        return Month;
    }

    private int Month;
    private int Year;


    public DateTime(int day, int month, int year) {
        Day = day;
        Month = month;
        Year = year;
    }

    @Override
    public String toString() {
        return Day + "/" + (Month + 1) + "/" + Year;
    }
}
