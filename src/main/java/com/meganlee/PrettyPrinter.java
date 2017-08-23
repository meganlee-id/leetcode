package com.meganlee;

import java.util.*;

public class PrettyPrinter {
    //------ 1D List/Integer --------//
    /*
        java> List<Integer> l = Arrays.asList(1, 2, 3);
        java.util.List<java.lang.Integer> l = [1, 2, 3]

        java> l.toString();
        java.lang.String res6 = "[1, 2, 3]"
    */
    public static String str1DIntList(List<Integer> l) {
        if (l == null) {
            return "null";
        } else {
            return l.toString();
        }
    }

    public static void print1DIntList(List<Integer> l) {
        System.out.println(str1DIntList(l));
    }

    //------ 1D List/String --------//
    public static String str1DStrList(List<String> s) {
        if (s == null) {
            return "null";
        } else {
            return s.toString();
        }
    }

    public static void print1DStrList(List<String> s) {
        System.out.println(str1DStrList(s));
    }

    //------ 1D Array/Integer --------//
    /*
        java> int[] x = {1,2,3};
        int[] x = [1, 2, 3]

        java> x.toString();
        java.lang.String res3 = "[I@9d2498"

        java> Arrays.toString(x);
        java.lang.String res4 = "[1, 2, 3]"
    */
    public static String str1DIntArray(int[] a) {
        if (a == null) {
            return "null";
        } else {
            return Arrays.toString(a);
        }
    }

    public static void print1DIntArray(int[] a) {
        System.out.println(str1DIntArray(a));
    }


    //------ 1D Array/String --------//
    public static String str1DStrArray(String[] a) {
        if (a == null) {
            return "null";
        } else {
            return Arrays.toString(a);
        }
    }

    public static void print1DStrArray(String[] strs) {
        System.out.println(str1DStrArray(strs));
    }


    //------ 2D List/Integer --------//
    public static String str2DIntList(List<List<Integer>> list) {
        if (list == null) {
            return "null";
        } else if (list.size() == 0) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(str1DIntList(list.get(i)));
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


    //------  2D Array/Integer --------//
    public static String str2DIntArray(int[][] matrix) {
        if (matrix == null) {
            return "null";
        } else if (matrix.length == 0) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < matrix.length; i++) {
                sb.append(str1DIntArray(matrix[i]));
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