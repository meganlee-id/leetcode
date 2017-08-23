package com.meganlee;

import java.util.*;
import org.junit.*;

public class InsertIntervalTest {
    InsertInterval solution = new InsertInterval();
    private String calculate(int [] a, int newStart, int newEnd) {
        System.out.println("---- input ----");
        List<Interval> list = Interval.buildIntervals(a);
        Interval newInterval = new Interval(newStart, newEnd);
        Interval.printIntervalList(list);
        System.out.println(newInterval);

        System.out.println("---- output ----");
        List<Interval> res = solution.insert(list, newInterval);
        Interval.printIntervalList(res);
        System.out.println();

        return Interval.strIntervalList(res);
    }
    int[] a = {0, 3, 8, 10, 15, 20, 3, 6, 8, 12, 19, 20};

    @Test
    public void testCase1() {
        Assert.assertEquals(calculate(a, 3, 6), "[0, 6] [8, 10] [3, 6] [8, 12] [15, 20]\n");
    }
}


