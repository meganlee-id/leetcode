package com.meganlee;

import java.util.*;
import org.junit.*;

public class JumpGame2Test {
    JumpGame2 solution = new JumpGame2();
    private int calculate(int[] array) {
        System.out.println(Arrays.toString(array));
        int res = solution.jump(array);
        System.out.println(res);
        return res;
    }

    int[] A1 = {5, 3, 2, 1, 4};
    int[] A2 = {0};
    int[] A3 = {0, 1, 3};

    @Test
    public void test() {
        Assert.assertEquals(1, calculate(A1));
        Assert.assertEquals(0, calculate(A2));
        Assert.assertEquals(0, calculate(A3));
    }
}