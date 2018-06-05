package com.meganlee;

import java.util.*;
import org.junit.*;

public class NQueen2Test {
    NQueen2 queen = new NQueen2();
    private int calculate(int n) {
        int res = queen.totalNQueens2(n);
        System.out.println("n=" + n);
        System.out.println("num of solutions is: " + res);
        return res;
    }

    @Test
    public void test() {
        Assert.assertEquals(2, calculate(4));
        Assert.assertEquals(10, calculate(5));
    }
}
