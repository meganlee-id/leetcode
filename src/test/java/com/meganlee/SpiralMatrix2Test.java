package com.meganlee;

import java.util.*;
import org.junit.*;

public class SpiralMatrix2Test {
    SpiralMatrix2 solution = new SpiralMatrix2();
    private String calculate(int n) {
        int[][] matrix = solution.generateMatrix(n);
        System.out.println(String.format("n == %d", n));
        System.out.println("------- Spiral ------");
        PrettyPrinter.print2DIntArray(matrix);
        System.out.println("");
        return (matrix == null) ? "" : PrettyPrinter.str2DIntArray(matrix);
    }

    @Test
    public void testMinusOne() {
        Assert.assertEquals(calculate(-1), "");
    }

    @Test
    public void testZero() {
        Assert.assertEquals(calculate(0), "[]");
    }

    @Test
    public void testOne() {
        Assert.assertEquals(calculate(1), "[1]");
    }

    @Test
    public void testTwo() {
        // [1, 2]
        // [4, 3]
        Assert.assertEquals(calculate(2), "[1, 2]\n[4, 3]");
    }

    @Test
    public void testThree() {
        // [1, 2, 3]
        // [8, 9, 4]
        // [7, 6, 5]
        Assert.assertEquals(calculate(3), "[1, 2, 3]\n[8, 9, 4]\n[7, 6, 5]");
    }

    @Test
    public void testFour() {
        // [1,   2,  3, 4]
        // [12, 13, 14, 5]
        // [11, 16, 15, 6]
        // [10,  9,  8, 7]
        Assert.assertEquals(calculate(4), "[1, 2, 3, 4]\n[12, 13, 14, 5]\n[11, 16, 15, 6]\n[10, 9, 8, 7]");
    }
}
