package com.meganlee;

import java.util.*;
import org.junit.*;

public class BestTimeBuyAndSellStock3Test {
    BestTimeBuyAndSellStock3 solution = new BestTimeBuyAndSellStock3();
    private int calculate(int[] prices) {
        int res = solution.maxProfit(prices);
        System.out.println(Arrays.toString(prices));
        System.out.println(res);
        return res;
    }

    int[] prices1 = {397,6621,4997,7506,8918,1662,9187,3278,3890,514,18,9305,93,5508};
    int[] prices2 = {1,2,0,1};

    @Test
    public void test() {
        System.out.println("============  Two Transaction =========");
        Assert.assertEquals(18077, calculate(prices1));
        Assert.assertEquals(2, calculate(prices2));
    }
}