package com.meganlee;

import java.util.*;

public class Interval {
    //------ standard fields and constructor --------//
    int start;
    int end;
    public Interval() {
        start = 0;
        end = 0;
    }
    public Interval(int s, int e) { 
        start = s;
        end = e;
    }

    //------ extended for testing --------//
    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }

    public static List<Interval> buildIntervals(int[] a) {
        // input checking, make odd number of ints
        List<Interval> l = new ArrayList();
        if (a.length % 2 != 0) {
            a = Arrays.copyOf(a, a.length + 1);
            a[a.length - 1] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < a.length; i += 2) {
            Interval inter = new Interval(a[i], a[i + 1]);
            l.add(inter);
        }
        return l;
    }

    public static String strIntervalList(List<Interval> l) {
        StringBuilder sb = new StringBuilder();
        for (Interval interval : l) {
            sb.append(interval + " ");
        }
        return sb.substring(0, sb.length() - 1) + "\n";
    }

    public static void printIntervalList(List<Interval> l) {
        System.out.print(strIntervalList(l));
    }
}