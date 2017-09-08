package com.acedemand.formatting;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * @author : Pamir Erdem <pamir.erdem@acedemand.com>
 * @date : 7/26/2015.
 */
public class DecimalFormatting {
    public static void main(String[] args) {
        double number = 1235.34123;
        String pattern1 = "###,###.###";
        DecimalFormat format = new DecimalFormat(pattern1);
        System.out.println("format.format(number) = " + format.format(number));
        
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(';');
        symbols.setGroupingSeparator(':');

        System.out.println("new DecimalFormat(pattern1,symbols).format(number) = " + new DecimalFormat(pattern1,symbols).format(number));
    }
}
