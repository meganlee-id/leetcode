package com.meganlee;

import org.junit.*;

public class PowXNTest {
    PowXN solution = new PowXN();
    
    String[] s1 = {"1", "2", "3", "#", "#", "4", "#", "#", "5"};
    String[] s2 = {"3", "9", "20", "#", "#", "15", "7"};
    TreeNode root1 = TreeNode.buildTreeFromLevelOrder(s1);
    TreeNode root2 = TreeNode.buildTreeFromLevelOrder(s2);

    private String calculate(double x, int n) {
        return String.valueOf(solution.myPow(x, n));
    }

    @Test
    public void testNGreaterThanZero() {
        // n > 0
        Assert.assertEquals("9.0", calculate(-3, 2));
        Assert.assertEquals("1.0", calculate(1, 2));
        Assert.assertEquals("0.125", calculate(0.5, 3));
        Assert.assertEquals("-0.125", calculate(-0.5, 3));
    }

    @Test
    public void testNSmallerThanZero() {
        // n < 0
        Assert.assertEquals("-0.3333333333333333", calculate(-3, -1));
        Assert.assertEquals("0.1111111111111111", calculate(3, -2));
        Assert.assertEquals("8.0", calculate(0.5, -3));
        Assert.assertEquals("-8.0", calculate(-0.5, -3));
    }

    @Test
    public void testNEqualsZero() {
        // n == 0
        Assert.assertEquals("1.0", calculate(1, 0));
        Assert.assertEquals("1.0", calculate(-0.5, 0));
    }

    @Test
    public void testXEqualsZero() {
        // x == 0
        Assert.assertEquals("1.0", calculate(0, 0));
        Assert.assertEquals("0.0", calculate(0, 1));
    }

    @Test(expected = ArithmeticException.class)
    public void testXEqualsZeroException() {
        // x == 0
        // java.lang.ArithmeticException: Could not raise 0 to a negative number!
        calculate(0, -1);
    }  

    @Test
    public void testXEqualsOne() {
        // x == 1
        Assert.assertEquals("1.0", calculate(1, Integer.MIN_VALUE));
    }
}
