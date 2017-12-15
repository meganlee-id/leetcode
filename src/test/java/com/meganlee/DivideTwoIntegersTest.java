package com.meganlee;

import org.junit.*;

public class DivideTwoIntegersTest {
    DivideTwoIntegers solution = new DivideTwoIntegers();
    public int calculate(int dividend, int divisor) {
        int quotient = solution.divide(dividend, divisor);
        System.out.println(String.format("\n %s / %s = %s \n", dividend, divisor, quotient));
        return quotient;
    }
    int min = Integer.MIN_VALUE;
    int max = Integer.MAX_VALUE;

    /** PLEASE CONSIDER ALL COMBINATION OF THE FOLLOWING **/
    // divisor:  pos (max) / 0 / neg (min)
    // dividend: pos (max) / 0 / neg (min)

    @Test
    public void testDivingZero() {
       Assert.assertEquals(calculate(0, min), 0);
    }

    @Test
    public void testPosDividedByZero() {
       Assert.assertEquals(calculate(max, 0), max);
    }

    @Test
    public void testNegDividedByZero() {
       Assert.assertEquals(calculate(min, 0), max);
    }

    @Test
    public void testOverflow() {
       Assert.assertEquals(calculate(min, -1), max);
    }

    @Test
    public void testNegDividedByPos1() {
       Assert.assertEquals(calculate(-10, 3), -3);
    }

    @Test
    public void testNegDividedByPos2() {
       Assert.assertEquals(calculate(min, max), -1);
    }

    @Test
    public void testPosDividedByNeg() {
       Assert.assertEquals(calculate(max, min), 0);
    }
}