package com.meganlee;

import java.util.*;

public class PrettyPrinter {
    //------ List<Ingeter> --------//
    /*
        java> List<Integer> l = Arrays.asList(1, 2, 3);

        java> l.toString();
        java.lang.String res6 = "[1, 2, 3]"
    */
    public static String str1DIntList(List<Integer> l) {
        return (l == null) ? "null" : l.toString();
    }

    public static void print1DIntList(List<Integer> l) {
        System.out.println(str1DIntList(l));
    }

    //------ List<String> --------//
    public static String str1DStrList(List<String> l) {
        return (l == null) ? "null" : l.toString();
    }

    public static void print1DStrList(List<String> l) {
        System.out.println(str1DStrList(l));
    }

    //------ int[] || String[] --------//
    /*
        java> int[] x = {1,2,3};

        java> x.toString();
        java.lang.String res3 = "[I@9d2498"

        java> Arrays.toString(x);
        java.lang.String res4 = "[1, 2, 3]"

    /////////////////////////////////////

        java> int[] x = null;

        java> x.toString();
        java.lang.NullPointerException

        java> Arrays.toString(x);
        java.lang.String res10 = "null"
    */


    //------ List<List<Integer>> --------//
    public static String str2DIntList(List<List<Integer>> list) {
        if (list == null) {
            return "null";
        } else if (list.size() == 0) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(str1DIntList(list.get(i)));
                // break lines
                if (i != list.size() - 1) {
                    sb.append('\n');
                }

            }
            return sb.toString();
        }
    }
    public static void print2DIntList(List<List<Integer>> list) {
        System.out.println(str2DIntList(list));
    }


    //------  int[][] --------//
    public static String str2DIntArray(int[][] matrix) {
        if (matrix == null) {
            return "null";
        } else if (matrix.length == 0) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < matrix.length; i++) {
                sb.append(Arrays.toString(matrix[i]));
                // break lines
                if (i != matrix.length - 1) {
                    sb.append('\n');
                }
            }
            return sb.toString();
        }
    }

    public static void print2DIntArray(int[][] matrix) {
        System.out.println(str2DIntArray(matrix));
    }
}