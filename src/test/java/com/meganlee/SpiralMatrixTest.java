package com.meganlee;

import org.junit.*;

public class SpiralMatrixTest {
    SpiralMatrix solution = new SpiralMatrix();
    private String calculate(int[][] array) {
        System.out.println("------- Matrix ------");
        PrettyPrinter.print2DIntArray(array);
        System.out.println("------- Spiral ------");
        String res = solution.spiralOrder(array).toString();
        System.out.println(res);
        System.out.println("");
        return res;
    }

    // test cases:
    int[][] matrix1 = {{1,2,3}, {4,5,6}, {7,8,9}};  // m > n
    int[][] matrix2 = {{1,2,3}, {4,5,6}};           // n > n
    int[][] matrix3 = {{1,2,3,4,5,6}};              // m == 1
    int[][] matrix4 = {{1},{2},{3},{4}};            // n == 1
    
    @Test
    public void testRowsMoreThanColumns() {
        Assert.assertEquals(calculate(matrix1), "[1, 2, 3, 6, 9, 8, 7, 4, 5]");
    }

    @Test
    public void testColumnsMoreThanRows() {
        Assert.assertEquals(calculate(matrix2), "[1, 2, 3, 6, 5, 4]");
    }

    @Test
    public void testOnlyOneRow() {
        Assert.assertEquals(calculate(matrix3), "[1, 2, 3, 4, 5, 6]");
    }

    @Test
    public void testOnlyOneColumn() {
        Assert.assertEquals(calculate(matrix4), "[1, 2, 3, 4]");
    }
}