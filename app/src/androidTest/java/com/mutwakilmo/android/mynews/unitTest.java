package com.mutwakilmo.android.mynews;

import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;

/**
 * Created by Mutwakil Mo on
 */


//1. "19980708" after formatting, is it equal to "08/07/1998"?
//        2. "2019-08-17T23:04:34-04:00" after formatting, is it equal to "17/08/1998"?
public class unitTest {
    @Test
    public void datDate() throws Exception{

        new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").parse("2017-11-27T20:13:24+00:00");
    }



//    @Test
//    public void checkEndDate() {
//        Utils formatter = new Utils();
//
//        Assert.assertEquals("19980708", formatter.getEndDate("08/07/1998"));
//        Assert.assertEquals(formatter.setCalendarFormat(), formatter.getEndDate(""));
//    }
//
//    @Test
//    public void checkBeginDate() {
//        Utils formatter = new Utils();
//
//        Assert.assertEquals("20190817", formatter.getEndDate("17/08/2019"));
//        Assert.assertEquals(formatter.setCalendarFormatPriorYear(),
//                formatter.getBeginDate(""));
//    }
//
//    @Test
//    public void getItemArticleFormattedDate() {
//
//        Assert.assertEquals(utils.getArticleItemFormattedDate(
//                "2019-08-17T23:04:34-04:00"), "17/08/19");
//    }
//
//    @Test
//    public void formatCalendar() {
//
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.DATE, 0);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
//
//        String actual = simpleDateFormat.format(calendar.getTime());
//        String expected = utils.setCalendarFormat();
//
//        Assert.assertEquals(expected, actual);
//    }

    @Test
    public void testNewDeskMethod() {

        String[] error = new String[6];
        error[0] = "Sport";

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < error.length; i++) {
            if (error[i] != null) {
                if (i > 0 && ((!error[i].isEmpty())))
                    res.append(" ");
                res.append(error[i]);
            }
        }

        String s = res.toString().isEmpty() ? "" : res.toString();

        Assert.assertEquals("Sport", s);

    }

}
