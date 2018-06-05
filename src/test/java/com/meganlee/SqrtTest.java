package com.meganlee;

import org.junit.*;

public class SqrtTest {
    Sqrt solution = new Sqrt();

    @Test
    public void test() {
        Assert.assertEquals(0, solution.sqrt(0));
        Assert.assertEquals(5, solution.sqrt(32));
        Assert.assertEquals(8, solution.sqrt(64));
    }

    @Test(expected = ArithmeticException.class) 
    public void testException() {
        solution.sqrt(-3);
    }
}