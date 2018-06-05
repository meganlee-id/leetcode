package com.meganlee;

import java.util.*;
import org.junit.*;

public class BestTimeBuyAndSellStockTest {
    BestTimeBuyAndSellStock solution = new BestTimeBuyAndSellStock();
    private int calculate(int[] prices) {
        int res = solution.maxProfit(prices);
        System.out.println(Arrays.toString(prices));
        System.out.println(res);
        return res;
    }

    int[] prices1 = {1, 2, 5, 3, 4, 6, 2, 8};
    int[] prices2 = {7, 1, 5, 3, 6, 4};

    @Test
    public void test() {
        System.out.println("============  Only One Transaction =========");
        Assert.assertEquals(7, calculate(prices1));
        Assert.assertEquals(5, calculate(prices2));
    }
}