package com.meganlee;

import java.util.*;

public class InsertInterval {
    //--------------- Solution --------------------//
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // input checking
        if (newInterval == null) {
            return intervals;
        }
        // the problem assumes intervals is already sorted and non-overlapping
        List<Interval> results = new ArrayList();
        for (Interval current: intervals) {
            // current preceding newInterval (no overlap)
            if (current.end < newInterval.start) {
                results.add(current);
            // newInterval preceding current (no overlap)
            } else if (current.start > newInterval.end) {
                results.add(newInterval);
                newInterval = current;
            // current and newInterval overlapping
            } else {
                newInterval.start = Math.min(current.start, newInterval.start);
                newInterval.end = Math.max(current.end, newInterval.end);
            }
        }
        results.add(newInterval); // add it at last
        return results;
    }


    //--------------- Solution 1 --------------------//
    // reuse code of Sor MergeIntervals
    // add one line: intervals.add(newInterval);
    public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
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
        for (int s = 0, e = 0; e < n; e++) {
            if (e == n - 1 || ends[e] < starts[e + 1]) {
                res.add(new Interval(starts[s], ends[e]));
                s = e + 1;
            }
        }
        return res;
    }
}
