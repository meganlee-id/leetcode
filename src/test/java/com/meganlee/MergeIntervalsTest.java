package com.meganlee;

import java.util.*;
import org.junit.*;

public class MergeIntervalsTest {
    MergeIntervals solution = new MergeIntervals();
    private String calculate(int [] a) {
        System.out.println("---- input ----");
        List<Interval> list = Interval.buildIntervals(a);
        Interval.printIntervalList(list);

        System.out.println("---- output ----");
        List<Interval> res = solution.merge(list);
        Interval.printIntervalList(res);
        System.out.println();
        
        return Interval.strIntervalList(res);
    }
    int[] a = {0, 3, 8, 10, 15, 20, 3, 6, 8, 12, 19, 20};

    @Test
    public void testCase1() {
        Assert.assertEquals("[0, 6] [8, 12] [15, 20]\n", calculate(a));
    }
}
