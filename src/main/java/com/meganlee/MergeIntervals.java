package com.meganlee;

import java.util.*;

public class MergeIntervals {
    //----------   Solution 1 --------------//
    // sort according to the start index
    public List<Interval> merge(List<Interval> intervals) {
        // input checking
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        // sort and solve
        //---- OPTION1 ----
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        //
        //---- OPTION2 ----
        // intervals.sort((i1, i2) -> i1.start - i2.start); // have to make sure lambda returns an int!!
        //
        //---- OPTION3 ----
        // Collections.sort(intervals, new Comparator<Interval>() {
        //     @Override
        //     public int compare(Interval a, Interval b) {
        //         return a.start - b.start;
        //     }
        // }); // ADD A ';'!

        // merge one by one
        List<Interval> res = new ArrayList(Arrays.asList(intervals.get(0)));
        Interval cur = intervals.get(0);
        for (Interval i: intervals) {
            if (i.start <= cur.end) { // overlaps
                cur.end = Math.max(i.end, cur.end);
            } else {
                res.add(i);
                cur = i;
            }
        }
        return res;
    }


    //----------   Solution 2 --------------//
    // sort starts and ends separately
    // when #_starts == #_ends, we found a merged interval
    // otherwise #_starts > #_ends, we're still seeing overlaps
    public List<Interval> merge2(List<Interval> intervals) {
        // input checking
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        // sort starts & ends
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        // loop through
        List<Interval> res = new ArrayList<Interval>();
        // s: pointer to the next new interval's start
        // e: pointer to the next new interval's end
        for (int s = 0, e = 0; e < n; e++) {
            // RULE1: e[i] > s[i] is guaranteed
            //        #_starts >= #_ends, where all starts and ends < a certain number x
            // RULE2: based on RULE1, let's compare e[i] with s[i + 1]
            //      -- if e[i] < s[i + 1] || e == last end
            //          at current ends, #_start == #_ends
            //          current interval ends
            //      -- if e[i] >= s[i]
            //          overlaps #_starts > #_ends
            if (e == n - 1 || ends[e] < starts[e + 1]) {
                res.add(new Interval(starts[s], ends[e]));
                s = e + 1;
            }

        }
        return res;
    }
}
