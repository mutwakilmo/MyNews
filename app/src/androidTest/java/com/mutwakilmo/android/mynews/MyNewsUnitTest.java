/*
package com.mutwakilmo.android.mynews;


import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

*/
/**
 * Created by Mutwakil Mo on
 *//*

public class MyNewsUnitTest {

    //Date Formatting and Retrieval Testing//
    @Test
    public void checkEndDate() {


        Assert.assertEquals("19980708", formatter.getEndDate("08/07/1998"));
        Assert.assertEquals(formatter.setCalendarFormat(), formatter.getEndDate(""));
    }

    @Test
    public void checkBeginDate() {
        String mFormat = "yyyyMMdd";
        Calendar calendar = Calendar.getInstance();

        Assert.assertEquals("20190817", formatter.getEndDate("17/08/2019"));
        Assert.assertEquals(formatter.setCalendarFormatPriorYear(),
                formatter.getBeginDate(""));
    }

    @Test
    public void getItemArticleFormattedDate() {
        String format = "yyyyMMddHHmm";
        Calendar calendar = Calendar.getInstance();
        Assert.assertEquals(utils.getArticleItemFormattedDate(
                "2019-08-17T23:04:34-04:00"), "17/08/19");
    }

    @Test
    public void formatCalendar() {
        Utils utils = new Utils();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

        String actual = simpleDateFormat.format(calendar.getTime());
        String expected = utils.setCalendarFormat();

        Assert.assertEquals(expected, actual);
    }

    //Checkbox Functionality Testing//
    @Test
    public void getNewDesk() {


        String[] empty = {"", "", ""};
        String[] full = {"Books", "Health", "Movies",
                "Science", "Technology", "Travel"};
        String[] null_ = new String[5];

        Assert.assertEquals(utils.getNewDesk(full),
                "Books Health Movies Science Technology Travel");
        Assert.assertEquals(utils.getNewDesk(empty), "");
        Assert.assertEquals(utils.getNewDesk(null_), "");
    }




}*/
