package com.meganlee;

import org.junit.*;

public class RotateImageTest {
    RotateImage solution = new RotateImage();
    private String calculate(int[][] matrix) {
        solution.rotate(matrix);
        return PrettyPrinter.str2DIntArray(matrix);
    }
    int[][] m1 = {{1, 2}, 
                  {3, 4}};

    int[][] m2 = {{1, 2, 3}, 
                  {4, 5, 6}, 
                  {7, 8, 9}};

    @Test
    public void testMatrix1() {
        // [3, 1]
        // [4, 2]
        Assert.assertEquals(
            "[3, 1]\n[4, 2]",
            calculate(m1)
        );
    }

    @Test
    public void testMatrix2() {
        // [7, 4, 1]
        // [8, 5, 2]
        // [9, 6, 3]
        Assert.assertEquals(
            "[7, 4, 1]\n[8, 5, 2]\n[9, 6, 3]",
            calculate(m2)
        );
    }
}