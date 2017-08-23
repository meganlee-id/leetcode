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
            // current interval preceding new interval
            if (current.end < newInterval.start) {
                results.add(current);
            // new interval preceding current
            } else if (current.start > newInterval.end) {
                results.add(newInterval);
                newInterval = current;
            // current and new interval overlapping
            } else {
                newInterval.start = Math.min(current.start, newInterval.start);
                newInterval.end = Math.max(current.end, newInterval.end);
            }
        }
        results.add(newInterval); // add it at last
        return results;
    }
}
