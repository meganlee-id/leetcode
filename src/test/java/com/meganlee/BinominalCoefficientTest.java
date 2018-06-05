package com.meganlee;

import java.util.*;
import org.junit.*;

public class BinominalCoefficientTest {
    BinominalCoefficient solution = new BinominalCoefficient();
    private int calculate(int n, int k) {
        int res = solution.binomialCoeff(n, k);
        System.out.println(String.format("C(%s, %s) = %s", n, k, res));
        return res;
    }

    @Test
    public void test() {
       Assert.assertEquals(20, calculate(6, 3));
       Assert.assertEquals(15, calculate(6, 4));
       Assert.assertEquals(6, calculate(6, 1));
       Assert.assertEquals(120, calculate(10, 3));
       Assert.assertEquals(210, calculate(10, 6));
       Assert.assertEquals(252, calculate(10, 5));
    }
}