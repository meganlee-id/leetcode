package com.meganlee;

import java.util.*;
import org.junit.*;

public class UniquePath2Test {
    UniquePath2 solution = new UniquePath2();
    private int calculate(int[][] grid) {
        System.out.println("============== Input grid ==============");
        PrettyPrinter.print2DIntArray(grid);
        int res = solution.uniquePathsWithObstacles4(grid);
        System.out.println(res);
        return res;
    }

    int[][] grids1 = {{0,0,0}, {0,1,0}, {0,0,0}};
    int[][] grids2 = {{0,0,0}};

    @Test
    public void test() {
        Assert.assertEquals(2, calculate(grids1));
        Assert.assertEquals(1, calculate(grids2));
    }
}