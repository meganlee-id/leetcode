package com.meganlee;

import java.util.*;
import org.junit.*;

public class StringToIntegerTest {
    StringToInteger solution = new StringToInteger();
    private int calculate(String s) {
        int res = solution.myAtoi(s);
        System.out.println("String:  \"" + s + "\"");       
        System.out.println("Integer: " + res);
        return res;
    }

    // Emptys and null
    @Test
    public void testNull() {
        Assert.assertEquals(0, calculate(null));
    }

    @Test
    public void testEmpty() {
        Assert.assertEquals(0, calculate(""));
    }

    @Test
    public void testSpaces() {
        Assert.assertEquals(0, calculate("   "));
    }

    // Invalids
    @Test
    public void testInvalidNoSign() {
        Assert.assertEquals(0, calculate("  d-fl03 "));
    }

    @Test
    public void testInvalidWithSign() {
        Assert.assertEquals(0, calculate("  +d-fl03 "));
    }

    @Test
    public void testSpecialString() {
        Assert.assertEquals(0, calculate("Integer.MAX_VALUE"));
    }

    // Zeros and leading zeros
    @Test
    public void testZero() {
        Assert.assertEquals(0, calculate("  +00d-fl03 "));
    }

    @Test
    public void testNoSignLeadingZero() {
        Assert.assertEquals(123, calculate("  0000123 "));
    }

    @Test
    public void testPosLeadingZero() {
        Assert.assertEquals(123, calculate("  +0000123 "));
    }

    @Test
    public void testNegLeadingZero() {
        Assert.assertEquals(-123, calculate("  -0000123 "));
    }

    // extreme values
    @Test
    public void testMax() {
        Assert.assertEquals(Integer.MAX_VALUE, calculate("2147483657"));
    }

    @Test
    public void testMin() {
        Assert.assertEquals(Integer.MIN_VALUE, calculate("-2147483648"));
    }

    // overflows
    @Test
    public void testPosOverflow() {
        Assert.assertEquals(Integer.MAX_VALUE, calculate("2147483658"));
    }

    // overflows
    @Test
    public void testNegOverflow() {
        Assert.assertEquals(Integer.MIN_VALUE, calculate("-2147483649"));
    }
}