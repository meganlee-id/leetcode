package com.meganlee;

import java.util.*;
import org.junit.*;

public class JumpGameTest {
    JumpGame solution = new JumpGame();
    private boolean calculate(int[] array) {
        System.out.println(Arrays.toString(array));
        boolean res = solution.canJump(array);
        System.out.println(res);
        return res;
    }

    int[] A1 = {5, 3, 2, 1, 4};
    int[] A2 = {0};
    int[] A3 = {0, 1, 3};

    @Test
    public void test() {
        Assert.assertEquals(true, calculate(A1));
        Assert.assertEquals(true, calculate(A2));
        Assert.assertEquals(false, calculate(A3));
    }
}