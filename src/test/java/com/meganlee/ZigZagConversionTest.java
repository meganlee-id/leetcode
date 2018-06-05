package com.meganlee;

import org.junit.*;

public class ZigZagConversionTest {
    ZigZagConversion solution = new ZigZagConversion();
    private String calculate(String s, int n) {
        String res = solution.convert2(s, n);
        System.out.println(res);
        return res;
    }

    String s = "PAYPALISHIRING";
    int rows = 3;

    @Test
    public void test() {
        Assert.assertEquals("PAHNAPLSIIGYIR", calculate(s, rows));
    }
}
