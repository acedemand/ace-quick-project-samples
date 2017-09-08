package com.acedemand.formatting;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author : Pamir Erdem <pamir.erdem@acedemand.com>
 * @date : 7/27/2015.
 */
public class DateFormatting2 {
    public static void main(String[] args) {
        Date currentDate = new Date();

        String pattern = "dd-M-yyyy H:m:s a";
        String pattern2 = "dd-M-yyyy h:m:s a";
        String pattern3 = "EEEE dd-M-yyyy h:m:s a";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(pattern2);
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat(pattern3, Locale.CANADA_FRENCH);

        System.out.println("currentDate = " + simpleDateFormat.format(currentDate));
        System.out.println("currentDate = " + simpleDateFormat2.format(currentDate));
        System.out.println("currentDate = " + simpleDateFormat3.format(currentDate));
    }
}

