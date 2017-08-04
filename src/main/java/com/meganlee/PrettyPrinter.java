package com.meganlee;

import java.util.Arrays;
import java.util.List;

public class PrettyPrinter {
    //------ Build 1D List/Array String --------//
    /*
        java> List<Integer> l = Arrays.asList(1, 2, 3);
        java.util.List<java.lang.Integer> l = [1, 2, 3]

        java> l.toString();
        java.lang.String res6 = "[1, 2, 3]"
    */
    public static String str1DList(List<Integer> l ) {
        if (l == null) {
            return "null";
        } else {
            return l.toString();
        }
    }

    public static void print1DList(List<Integer> l ) {
        System.out.println(str1DList(l));
    }


    /*
        java> int[] x = {1,2,3};
        int[] x = [1, 2, 3]

        java> x.toString();
        java.lang.String res3 = "[I@9d2498"

        java> Arrays.toString(x);
        java.lang.String res4 = "[1, 2, 3]"
    */
    public static String str1DArray(int[] a) {
        if (a == null) {
            return "null";
        } else {
            return Arrays.toString(a);
        }
    }

    public static String str1DStrArray(String[] a) {
        if (a == null) {
            return "null";
        } else {
            return Arrays.toString(a);
        }
    }

    public static void print1DArray(int[] a) {
        System.out.println(str1DArray(a));
    }


    //------ Print 2D List/Array --------//
    public static String str2DList(List<List<Integer>> list) {
        if (list == null) {
            return "null";
        } else if (list.size() == 0) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(str1DList(list.get(i)));
                if (i != list.size() - 1) {
                    sb.append('\n');
                }

            }
            return sb.toString();
        }
    }
    public static void print2DList(List<List<Integer>> list) {
        System.out.println(str2DList(list));
    }


    public static String str2DArray(int[][] matrix) {
        if (matrix == null) {
            return "null";
        } else if (matrix.length == 0) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < matrix.length; i++) {
                sb.append(str1DArray(matrix[i]));
                if (i != matrix.length - 1) {
                    sb.append('\n');
                }
            }
            return sb.toString();
        }
    }
    public static void print2DArray(int[][] matrix) {
        System.out.println(str2DArray(matrix));
    }

    public static void main(String[] args) {
        int[][] grids1 = {{0,0,0}, {0,10,0}, {0,0,0}};
        print2DArray(grids1);
    }
}

