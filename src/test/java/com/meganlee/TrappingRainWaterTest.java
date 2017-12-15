package com.meganlee;

import java.util.*;
import org.junit.*;

public class TrappingRainWaterTest {
    TrappingRainWater solution = new TrappingRainWater();
    private int calculate(int[] bars) {
        int res = solution.trap(bars);
        System.out.println(Arrays.toString(bars));
        System.out.println(res);                
        return res;
    }

    int[] bars1 = {9,6,8,8,5,6,3};
    int[] bars2 = {4,4,4,4,4};
    int[] bars3 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
    int[] bars4 = {0,0,0,0};


    @Test
    public void testRandomHeights() {
        Assert.assertEquals(calculate(bars1), 3);
    }

    @Test
    public void testSameHeights() {
        Assert.assertEquals(calculate(bars2), 0);
    }

    @Test
    public void testAscendingHeights() {
        Assert.assertEquals(calculate(bars3), 0);
    }

    @Test
    public void testZeroHeights() {
        Assert.assertEquals(calculate(bars4), 0);
    }
}