package com.meganlee;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnLine {
    //-----------------  Solution 1 ----------------------------//
    // fix 2 points and count
    public int maxPoints(Point[] points) {
        // validate input
        if (points == null || points.length == 0) {
            return 0;
        }

        // find all pairs of DISTINCT points, then count how many other points are on it
        int max = 1;
        int N = points.length;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                // only look for non overlapping point pair (i, j)
                if (!samePoints(points[i], points[j])) {
                    int numOfPoints = 2;
                    for (int k = 0; k < N; k++) {
                        // find points other than i or j
                        if (k != i && k != j && onSameLine(points[i], points[j], points[k])) {
                            numOfPoints++;
                        }
                    }
                    max = Math.max(max, numOfPoints);
                }
            }
        }
        return allSamePoints(points) ? N : max;
    }



    //-----------------  Solution 2 ----------------------------//
    // categorize all lines into those of:
    // category 1: lines that across point 1, keep a map of <slope, numOfPoints>
    // category 2: lines that across point 2, keep a map of <slope, numOfPoints>
    // ...
    // category N: lines that across point N, keep a map of <slope, numOfPoints>
    //
    public int maxPoints2(Point[] points) {
        // validate inputs
        if (points == null || points.length == 0) {
            return 0;
        }

        int globalMax = 1;
        int N = points.length;

        // fix one point, then count Map<slope, numOfPoints>
        for (int i = 0; i < N; i++) {
            //---- step 1: calculated number of points ------//
            Map<Double, Integer> table = new HashMap<>();
            int dupes = 1;
            for (int j = i + 1; j < N; j++) {
                if (samePoints(points[i], points[j])) { // overlapping points, count numbers
                    dupes++;
                } else {                                // non overlapping points, collect in map table
                    Double slope = getSlope(points[i], points[j]);
                    int numOfPoints =  table.containsKey(slope) ? (table.get(slope) + 1) : 1;
                    table.put(slope, numOfPoints);
                }
            }

            //----- step2: update the max ---------//
            int localMax = dupes + (table.isEmpty() ? 0 : Collections.max(table.values()));
            globalMax = Math.max(globalMax, localMax);
        }
        return globalMax;
    }


    /** All util functions, extract out for better readability **/

    private boolean samePoints(Point p1, Point p2) {
        return (p1.x == p2.x && p1.y == p2.y);
    }

    private boolean allSamePoints(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            if (!samePoints(points[i], points[i + 1])) {
                return false;
            }
        }
        return true;
    }

    private boolean onSameLine(Point p1, Point p2, Point p3) {
        return (p3.y - p1.y) * (p2.x - p1.x) == (p3.x - p1.x) * (p2.y - p1.y) ;
    }

    private Double getSlope(Point p1, Point p2) {
        // 1) in Java -0,0 is NOT the same as 0.0, but -0.0 + 0.0 = 0.0
        // 2) don't forget to cast to (double)!! otherwise slope is rounded to int
        return (p1.x == p2.x) ? Double.POSITIVE_INFINITY : ((double)(p1.y - p2.y) / (p1.x - p2.x)) + 0.0;
    }


    //////////////////////  TEST /////////////////////////
    private static void test(MaxPointsOnLine solution, int[][] points, int expected) {
        int actual = solution.maxPoints(Point.buildPoints(points));
        System.out.println(String.format("\n\nActual: %d,  Expected: %d", actual, expected));
        System.out.println(actual == expected);
    }
    public static void main(String[] args) {
        // output 6
        int[][] xys1 = {{84,250},{0,0},{1,0},{0,-70},{0,-70},{1,-1},{21,10},{42,90},{-42,-230}};

        // output 12
        int[][] xys2 = {{0,9},{138,429},{115,359},{115,359},{-30,-102},{230,709},{-150,-686},{-135,-613},{-60,-248},{-161,-481},{207,639},{23,79},{-230,-691}, {-115,-341},{92,289},{60,336},{-105,-467},{135,701},{-90,-394},{-184,-551},{150,774}};

        // output: 4
        int[][] xys3 = {{0,0},{0,0},{0,0},{0,0}};

        MaxPointsOnLine solution = new MaxPointsOnLine();
        test(solution, xys1, 6);
        test(solution, xys2, 12);
        test(solution, xys3, 4);
    }
}
