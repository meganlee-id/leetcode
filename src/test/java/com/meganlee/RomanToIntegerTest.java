package com.meganlee;

import org.junit.*;

public class RomanToIntegerTest {
    RomanToInteger solution = new RomanToInteger();
    private int calculate(String roman) {
        int res = solution.romanToInt(roman);
        System.out.println("Roman:   " + roman);
        System.out.println("Integer: " + res);
        return res;
    }

    @Test
    public void testEmpty() {
        // empty
        Assert.assertEquals(0, calculate(null));
        Assert.assertEquals(0, calculate(""));
     }

    @Test
    public void test() {
        // empty
        Assert.assertEquals(3999, calculate("MMMCMXCIX"));
        Assert.assertEquals(8, calculate("VIII"));
        Assert.assertEquals(27, calculate("XXVII"));
     }
}