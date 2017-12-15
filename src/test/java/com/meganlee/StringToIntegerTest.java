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
        Assert.assertEquals(calculate(null), 0);
    }

    @Test
    public void testEmpty() {
        Assert.assertEquals(calculate(""), 0);
    }

    @Test
    public void testSpaces() {
        Assert.assertEquals(calculate("   "), 0);
    }

    // Invalids
    @Test
    public void testInvalidNoSign() {
        Assert.assertEquals(calculate("  d-fl03 "), 0);
    }

    @Test
    public void testInvalidWithSign() {
        Assert.assertEquals(calculate("  +d-fl03 "), 0);
    }

    @Test
    public void testSpecialString() {
        Assert.assertEquals(calculate("Integer.MAX_VALUE"), 0);
    }

    // Zeros and leading zeros
    @Test
    public void testZero() {
        Assert.assertEquals(calculate("  +00d-fl03 "), 0);
    }

    @Test
    public void testNoSignLeadingZero() {
        Assert.assertEquals(calculate("  0000123 "), 123);
    }

    @Test
    public void testPosLeadingZero() {
        Assert.assertEquals(calculate("  +0000123 "), 123);
    }

    @Test
    public void testNegLeadingZero() {
        Assert.assertEquals(calculate("  -0000123 "), -123);
    }

    // extreme values
    @Test
    public void testMax() {
        Assert.assertEquals(calculate("2147483657"), Integer.MAX_VALUE);
    }

    @Test
    public void testMin() {
        Assert.assertEquals(calculate("-2147483648"), Integer.MIN_VALUE);
    }

    // overflows
    @Test
    public void testPosOverflow() {
        Assert.assertEquals(calculate("2147483658"), Integer.MAX_VALUE);
    }

    // overflows
    @Test
    public void testNegOverflow() {
        Assert.assertEquals(calculate("-2147483649"), Integer.MIN_VALUE);
    }
}