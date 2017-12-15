package com.meganlee;

import org.junit.*;

public class MaxPointsOnLineTest {
    MaxPointsOnLine solution = new MaxPointsOnLine();
    private int calculate(int[][] points) {
        return solution.maxPoints(Point.buildPoints(points));
    }

    int[][] xys1 = {{84,250},{0,0},{1,0},{0,-70},{0,-70},{1,-1},{21,10},{42,90},{-42,-230}};
    int[][] xys2 = {{0,9},{138,429},{115,359},{115,359},{-30,-102},{230,709},{-150,-686},{-135,-613},{-60,-248},{-161,-481},{207,639},{23,79},{-230,-691}, {-115,-341},{92,289},{60,336},{-105,-467},{135,701},{-90,-394},{-184,-551},{150,774}};
    int[][] xys3 = {{0,0},{0,0},{0,0},{0,0}};

    @Test
    public void test() {
        Assert.assertEquals(calculate(xys1), 6);
        Assert.assertEquals(calculate(xys2), 12);
        Assert.assertEquals(calculate(xys3), 4);
    }
}