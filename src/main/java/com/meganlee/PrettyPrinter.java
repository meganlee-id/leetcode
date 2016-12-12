package com.meganlee;

import java.util.Arrays;
import java.util.List;

public class PrettyPrinter {
    //------ Print 1D List/Array --------//
    /*
        java> List<Integer> l = Arrays.asList(1, 2, 3);
        java.util.List<java.lang.Integer> l = [1, 2, 3]

        java> l.toString();
        java.lang.String res6 = "[1, 2, 3]"
    */
    public static void print1DList(List<Integer> l ) {
        if (l == null) {
            System.out.println("null");
        } else {
            System.out.println(l.toString());
        }
    }

    /*
        java> int[] x = {1,2,3};
        int[] x = [1, 2, 3]

        java> x.toString();
        java.lang.String res3 = "[I@9d2498"

        java> Arrays.toString(x);
        java.lang.String res4 = "[1, 2, 3]"
    */

    public static void print1DArray(int[] a) {
        if (a == null) {
            System.out.println("null");
        } else {
            System.out.println(Arrays.toString(a));
        }
    }

    private static void print1DArrayFormat(int[] row) {
        for (int cell: row) {
            System.out.format("%7d", cell);
        }
        System.out.println();
    }

    public static void print1DStrArray(String[] strs) {
        System.out.print("[");
        for (int i = 0; i < strs.length; i++) {
            System.out.print("\"" + strs[i] +"\"");
            if (i < strs.length - 1) System.out.print(", ");
        }
        System.out.println("]\n");
    }

    public static void print2DList(List<List<Integer>> list ) {
        if (list == null) {
            System.out.println("null");
        } else {
            for (List<Integer> l : list) {
                print1DList(l);
            }
        }
    }

    public static void print2DArray(int[][] matrix) {
        if (matrix == null) {
            System.out.println("null");
        } else {
            for (int[] arr : matrix) {
                print1DArrayFormat(arr);
                // print1DArray(arr);
            }
        }
    }

    public static void main(String[] args) {
        int[][] grids1 = {{0,0,0}, {0,10,0}, {0,0,0}};
        print2DArray(grids1);
    }
}

