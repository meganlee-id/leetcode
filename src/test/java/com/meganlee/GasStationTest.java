package com.meganlee;

import java.util.*;
import org.junit.*;

public class GasStationTest {
    GasStation solution = new GasStation();
    private int calculate(int[] gas, int[] cost) {
        return solution.canCompleteCircuit(gas, cost);
    }

    int[] gas  = {3, 1, 2, 5, 4};
    int[] cost = {4, 1, 1, 2, 3};

    @Test
    public void test() {
        Assert.assertEquals(1, calculate(gas, cost));
    }
}