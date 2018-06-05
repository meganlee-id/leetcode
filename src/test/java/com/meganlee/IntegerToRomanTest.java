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
        Assert.assertEquals(null, calculate(-100));
        Assert.assertEquals(null, calculate(0));
        Assert.assertEquals(null, calculate(4000));
        // normal
        Assert.assertEquals("MMMCMXCIX", calculate(3999));
        Assert.assertEquals("CMXLIV", calculate(944));
     }
}