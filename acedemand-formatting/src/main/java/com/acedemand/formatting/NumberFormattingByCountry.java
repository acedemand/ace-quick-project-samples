package com.acedemand.formatting;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author : Pamir Erdem <pamir.erdem@acedemand.com>
 * @date : 7/26/2015.
 */
public class NumberFormattingByCountry {
    public static void main(String[] args) {

        double number = 1235.34123;
        NumberFormat USFormat = NumberFormat.getInstance(Locale.US);
        NumberFormat FRFormat = NumberFormat.getInstance(Locale.FRANCE);
        NumberFormat GRFormat = NumberFormat.getInstance(Locale.GERMANY);

        System.out.println(USFormat.format(number));
        System.out.println(FRFormat.format(number));
        System.out.println(GRFormat.format(number));


    }
}
