package com.meganlee;

import java.util.*;

public class InterleavingString {
    //-------------------- Solution 1 --------------------///
    // recursion: (Time Limit Exceeded)
    public boolean isInterleave(String s1, String s2, String s3) {
        // input validation
        if (s1 == null || s2 == null || s3 == null || !isAnagram(s1 + s2, s3)) {
            return false;
        }
        //--- base case
        if (s1.length() == 0) {
            return s2.equals(s3);
        } else if (s2.length() == 0) {
            return s1.equals(s3);
        //--- general case
        } else {
            return (s3.charAt(0) == s1.charAt(0) && isInterleave(s1.substring(1), s2, s3.substring(1))) ||  // s3 match s1
                   (s3.charAt(0) == s2.charAt(0) && isInterleave(s1, s2.substring(1), s3.substring(1)));    // s3 match s2
        }
    }

    //-------------------- Solution 2 --------------------///
    // recursion: cache
    public boolean isInterleave2(String s1, String s2, String s3) {
        // input validation
        if (s1 == null || s2 == null || s3 == null || !isAnagram(s1 + s2, s3)) {
            return false;
        }

        // create cache
        int[][] cache = new int[s1.length() + 1][s2.length() + 1]; // NOTICE!! don't forget +1!
        // here we save initialization, we'll use 1 as true, -1 as false
        return helper(s1, s2, s3, 0, 0, cache);
    }

    private boolean helper(String s1, String s2, String s3, int i, int j, int[][] cache) {
        // update cache
        int S1 = s1.length(), S2 = s2.length(), k = i + j;
        if (cache[i][j] == 0) {
            if (i == S1) {           //-- base case
                cache[i][j] = s2.substring(j).equals(s3.substring(k)) ? 1 : -1; // set false to -1
            } else if (j == S2) {
                cache[i][j] = s1.substring(i).equals(s3.substring(k)) ? 1 : -1; // set false to -1
            } else {                //-- general case
                boolean matchS1 = (s3.charAt(k) == s1.charAt(i)) && helper(s1, s2, s3, i + 1, j, cache);
                boolean matchS2 = (s3.charAt(k) == s2.charAt(j)) && helper(s1, s2, s3, i, j + 1, cache);
                cache[i][j] = (matchS1 || matchS2) ? 1 : -1; // set false to -1
            }
        }
        // return cache
        return cache[i][j] == 1;
    }

    //-------------------- Solution 4 --------------------//
    // Alternative dp:
    //      use a different state definition: dp[i][j]
    //      s1.substring(0, i), s2.substring(0, j) V.S. s3.substring(0, i + j);
    public boolean isInterleave3(String s1, String s2, String s3) {
        // input validation
        if (s1 == null || s2 == null || s3 == null || s3.length() != s1.length() + s2.length()) {
            return false;
        }

        int S1 = s1.length(), S2 = s2.length();
        boolean[][] dp = new boolean[S1 + 1][S2 + 1];
        for (int i = 0; i <= S1; i++) {
            for (int j = 0; j <= S2; j++) {
                // condense 4 conditions into the following if-else block
                // 1) if (i == 0 && j == 0) 
                // 2) else if (i == 0) 
                // 3) else if (j == 0)
                // 4) else
                if (i == 0 && j == 0) {
                    dp[i][j] = true; // initialization
                } else {
                    dp[i][j] = (i > 0 && s3.charAt(i + j - 1) == s1.charAt(i - 1) && dp[i - 1][j]) || // s3 match s1
                               (j > 0 && s3.charAt(i + j - 1) == s2.charAt(j - 1) && dp[i][j - 1]);   // s3 match s2 
                }

            }
        }
        return dp[S1][S2];
    }

    //----------------   UTIL FUNCTION: Anagram ----------------------//
    // also used in ScrambleString.java
    //---------- String Methods ----------//
    private boolean isAnagram(String s1, String s2) {
        // NOT same len
        if (s1.length() != s2.length()) {
            return false;
        }
        // NOT anagram
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1); // sort returns void!
        Arrays.sort(arr2);
        return new String(arr1).equals(new String(arr2));
    }

    //---------- char freq ----------//
    private boolean isAnagram2(String s1, String s2) {
        // NOT same len
        if (s1.length() != s2.length()) {
            return false;
        }
        // balance
        int[] balance = new int[256];
        for (int i = 0; i < s1.length(); i++) {
            balance[s1.charAt(i)]++;
            balance[s2.charAt(i)]--;
        }
        for (int i: balance) {
            if (i != 0) return false;
        }
        return true;
    }
}
