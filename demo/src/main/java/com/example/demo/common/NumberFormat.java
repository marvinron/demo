package com.example.demo.common;

import java.util.Locale;

public class NumberFormat {
    public static void main(String[] args) {
        java.text.NumberFormat numberFormat = java.text.NumberFormat.getNumberInstance(Locale.CHINA);
        numberFormat.format(10000);
        System.out.println(numberFormat.format(10000));

    }
}
