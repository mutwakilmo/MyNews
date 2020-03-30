package com.mutwakilmo.android.mynews;

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
//    public void getItemArticleFormattedDate() {
//        String format = "yyyyMMddHHmm";
//        Calendar calendar = Calendar.getInstance();
//        Assert.assertEquals(utils.getArticleItemFormattedDate(
//                "2019-08-17T23:04:34-04:00"), "17/08/19");
//    }
}
