package com.acedemand.formatting;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author : Pamir Erdem <pamir.erdem@acedemand.com>
 * @date : 7/26/2015.
 */
public class DateFormatting {
    public static void main(String[] args) {
        Date currentDate = new Date();

        DateFormat usFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
        DateFormat chinaFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.CHINA);


        System.out.println("usFormat.format(currentDate) = " + usFormat.format(currentDate));
        System.out.println("chinaFormat.format(currentDate) = " + chinaFormat.format(currentDate));



        DateFormat tmusFormat = DateFormat.getTimeInstance(DateFormat.LONG, Locale.US);
        DateFormat tmchinaFormat = DateFormat.getTimeInstance(DateFormat.LONG, Locale.CHINA);


        System.out.println("tmusFormat.format(currentDate) = " + tmusFormat.format(currentDate));
        System.out.println("tmchinaFormat.format(currentDate) = " + tmchinaFormat.format(currentDate));



    }
}
