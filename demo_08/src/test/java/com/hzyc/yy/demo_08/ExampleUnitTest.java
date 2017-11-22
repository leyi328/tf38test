package com.hzyc.yy.demo_08;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
       /* Date date = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd-hh-mm-ss");
        String sj = simpleDateFormat.format(date);
        System.out.println(sj);

        String [] str = sj.split("-");
        System.out.println(str[0]);
        System.out.println(str[1]);
        System.out.println(str[2]);

        int year = Integer.parseInt(str[0]);*/

       /* Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(year);
        System.out.println(month+1);
        System.out.println(day);*/

        Calendar calendar = Calendar.getInstance();

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        System.out.println(hour);
        System.out.println(minute);

}
}