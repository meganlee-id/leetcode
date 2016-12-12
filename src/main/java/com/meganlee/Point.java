package com.meganlee;


public class Point {
	int x;
	int y;
	Point(int a, int b) { x = a; y = b; }
	
	public static Point[] buildPoints(int[] x, int[] y) {
		if (x == null || y == null || x.length != y.length) {
			return null;
		}
		Point[] points = new Point[x.length];
		for (int i = 0; i < x.length; i++) {
			points[i] = new Point(x[i], y[i]);
		}
		return points;
	}

	public static Point[] buildPoints(int[][] xys) {
	    Point[] points = new Point[xys.length];
		for (int i = 0; i < xys.length; i++) {
		    points[i] = new Point(xys[i][0], xys[i][1]);
		}
		return points;
	}
}
