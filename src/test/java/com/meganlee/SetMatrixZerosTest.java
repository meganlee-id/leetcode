package com.meganlee;

import org.junit.*;

public class SetMatrixZerosTest {
    SetMatrixZeros solution = new SetMatrixZeros();
    private String calculate(int[][] matrix) {
        solution.setZeroes(matrix);
        return PrettyPrinter.str2DIntArray(matrix);
    }

    // test cases:
    int[][] matrix = {{1,0,3}, {0,5,6}, {7,8,9}};
    
    @Test
    public void testMatrix() {
        // [0, 0, 0]
        // [0, 0, 0]
        // [0, 0, 9]
        Assert.assertEquals(calculate(matrix), "[0, 0, 0]\n[0, 0, 0]\n[0, 0, 9]");
    }
}
