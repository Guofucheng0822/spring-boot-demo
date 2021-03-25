package com.pers.guofucheng.demo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal a;
        BigDecimal b;
        a = new BigDecimal(69371809);
        b = new BigDecimal(600000);

        System.out.print(a.divide(b, 6, RoundingMode.HALF_UP));
    }
}
