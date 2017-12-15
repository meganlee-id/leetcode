package com.meganlee;


public class Point {
    int x;
    int y;
    Point(int a, int b) { 
        x = a; 
        y = b;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
          return true;
        }
        if (!(other instanceof Point)) {
          return false;
        }
        Point otherPoint = (Point) other;
        return otherPoint.x == x && otherPoint.y == y;
    }

    // use prime to implement hashCode: https://stackoverflow.com/questions/9135759/java-hashcode-for-a-point-class
    @Override
    public int hashCode() {
        return (Integer.toString(x) + "," + Integer.toString(y)).hashCode();
    }

    // xys: An array of pairs
    // e.g: int[][] xys3 = {{0,0},{0,0},{0,0}};
    public static Point[] buildPoints(int[][] xys) {
        Point[] points = new Point[xys.length];
        for (int i = 0; i < xys.length; i++) {
            points[i] = new Point(xys[i][0], xys[i][1]);
        }
        return points;
    }

}
