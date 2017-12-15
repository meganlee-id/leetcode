package com.meganlee;

import org.junit.*;

public class IntegerToRomanTest {
    IntegerToRoman solution = new IntegerToRoman();
    private String calculate(int num) {
        String res = solution.intToRoman(num);
        System.out.println("Integer: " + num);
        System.out.println("Roman:   " + res);
        return res;
    }

    @Test
    public void testBigNumbers() {
        // out of range
        Assert.assertEquals(calculate(-100), null);
        Assert.assertEquals(calculate(0), null);
        Assert.assertEquals(calculate(4000), null);
        // normal
        Assert.assertEquals(calculate(3999), "MMMCMXCIX");
        Assert.assertEquals(calculate(944), "CMXLIV");
     }
}