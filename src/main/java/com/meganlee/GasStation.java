package com.meganlee;

import java.util.*;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // input checking
        if (gas == null || cost == null || gas.length != cost.length) {
            return -1;
        }
        int sum = 0, rangeSum = 0;
        int start = 0; // do no put start in for loop, need to access it at the end
        for (int end = 0; end < gas.length; end++) {
            // 1. update cache
            int diff = gas[end] - cost[end];
            sum += diff;
            rangeSum += diff;
            // 2. adjust start
            if (rangeSum < 0) {
                start = end + 1;
                rangeSum = 0;
            }
        }
        return (sum >= 0) ? start : -1;
    }
}
