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
       Assert.assertEquals(0, calculate(0, min));
    }

    @Test
    public void testPosDividedByZero() {
       Assert.assertEquals(max, calculate(max, 0));
    }

    @Test
    public void testNegDividedByZero() {
       Assert.assertEquals(max, calculate(min, 0));
    }

    @Test
    public void testOverflow() {
       Assert.assertEquals(max, calculate(min, -1));
    }

    @Test
    public void testNegDividedByPos1() {
       Assert.assertEquals(-3, calculate(-10, 3));
    }

    @Test
    public void testNegDividedByPos2() {
       Assert.assertEquals(-1, calculate(min, max));
    }

    @Test
    public void testPosDividedByNeg() {
       Assert.assertEquals(0, calculate(max, min));
    }
}