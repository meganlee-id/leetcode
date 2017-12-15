package com.meganlee;

import org.junit.*;

public class SqrtTest {
    Sqrt solution = new Sqrt();

    @Test
    public void test() {
        Assert.assertEquals(solution.sqrt(0), 0);
        Assert.assertEquals(solution.sqrt(32), 5);
        Assert.assertEquals(solution.sqrt(64), 8);
    }

    @Test(expected = ArithmeticException.class) 
    public void testException() {
        solution.sqrt(-3);
    }
}