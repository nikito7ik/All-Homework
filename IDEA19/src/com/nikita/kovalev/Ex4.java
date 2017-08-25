package com.nikita.kovalev;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by nikit on 26.07.2017.
 * This class displays the number 153.5 in monetary form for Ukraine
 */
public class Ex4 {
    public static void main(final String... args) {
        final double number = 153.5;
        Locale l = new Locale("uk", "UA");
        russianLanguage(number, l);
        System.out.println("=================");
        ukrainianLanguage(number, l);
    }

    public static void russianLanguage(final double number, Locale l) {
        System.out.println("Russian language: ");
        System.out.println(l.getDisplayCountry());
        System.out.println(l.getDisplayLanguage());
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        System.out.println(nf.format(number));
    }

    public static void ukrainianLanguage(final double number, Locale l) {
        System.out.println("Ukrainian language: ");
        System.out.println(l.getDisplayCountry(l));
        System.out.println(l.getDisplayLanguage(l));
        NumberFormat nf = NumberFormat.getCurrencyInstance(l);
        System.out.println(nf.format(number));
    }
}
