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
        Assert.assertEquals(calculate(null), 0);
        Assert.assertEquals(calculate(""), 0);
     }

    @Test
    public void test() {
        // empty
        Assert.assertEquals(calculate("MMMCMXCIX"), 3999);
        Assert.assertEquals(calculate("VIII"), 8);
        Assert.assertEquals(calculate("XXVII"), 27);
     }
}