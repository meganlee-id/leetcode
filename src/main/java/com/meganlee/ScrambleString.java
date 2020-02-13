package com.meganlee;

import java.util.*;

public class ScrambleString {
    //----------------   Solution 1  ----------------------//
    // Recursion (TIMEOUT)
    public boolean isScramble(String s1, String s2) {
        // input checking
        if (s1 == null || s2 == null || !isAnagram(s1, s2)) {
            return false;
        }
        // base case & fast return (len == 1 || s1 == s2)
        if (s1.equals(s2)) {
            return true;
        }
        // recursive calls
        int N = s1.length();
        for (int split = 1; split < N; split++) {
            String s1A       = s1.substring(0, split),   s1B       = s1.substring(split); // s.substring(start)
            String s2NoSwapA = s2.substring(0, split),   s2NoSwapB = s2.substring(split);
            String s2SwapA   = s2.substring(N - split),  s2SwapB   = s2.substring(0, N - split);
            if (isScramble(s1A, s2NoSwapA) && isScramble(s1B, s2NoSwapB) || 
                isScramble(s1A, s2SwapA)   && isScramble(s1B, s2SwapB)) {
                return true;  // --- if matches return true
            } //--- else continues to next loop
        }
        return false;
    }

    //----------------   Solution 2  ----------------------//
    // recursion with cache: using standard template!!
    public boolean isScramble2(String s1, String s2) {
        // input checking
        if (s1 == null || s2 == null || !isAnagram(s1, s2)) {
            return false;
        }
        // base case & fast return (len == 1 || s1 == s2)
        if (s1.equals(s2)) {
            return true;
        }
        // create a cache
        int N = s1.length();
        // use int instead of boolean (true: 1, false: -1, default: 0)
        int[][][] cache = new int[N][N][N + 1];   // [s1.start][s2.start][len], len == 0 is not used!!
        return helper(s1, 0, s2, 0, N, cache) == 1;  // cache 3 indexes need to be in helper param list
    }

    private int helper(String s1, int i, String s2, int j, int len, int[][][] cache) {
        // update cache
        if (cache[i][j][len] == 0) {
            if (len == 1) {      // BASE CASE:    len == 1, initilization
                cache[i][j][len] = (s1.charAt(i) == s2.charAt(j)) ? 1 : -1;
            } else {             // GENERAL CASE: len 2 --> N
                    for (int l = 1; l <= len - 1; l++) { // l is the split, len of first part prefix
                    boolean isScramble = (helper(s1, i, s2, j, l, cache) == 1 && helper(s1, i + l, s2, j + l, len - l, cache) == 1) ||     // no swap
                                         (helper(s1, i, s2, j + len - l, l, cache) == 1 && helper(s1, i + l, s2, j, len - l, cache) == 1); // swap
                    cache[i][j][len] = isScramble ? 1 : -1;
                    if (isScramble) break; // solution found, break
                }
            }
        }
        // return value
        return cache[i][j][len];
    }

    //----------------   Solution 3  ----------------------//
    // DP O(N^3)
    public boolean isScramble3(String s1, String s2) {
        // input checking
        if (s1 == null || s2 == null || !isAnagram(s1, s2)) {
            return false;
        }
        // base case & fast return (len == 1 || s1 == s2)
        if (s1.equals(s2)) {
            return true;
        }
        // define status table and initial values
        int N = s1.length();
        boolean[][][] dp = new boolean[N][N][N + 1];  // [s1.start][s2.start][len], len == 0 is not used!!
        for (int len = 1; len <= N; len++) {
            for (int i = 0; i <= N - len; i++) { // i <= N - len (make sure the last substring within bounds)
                for (int j = 0; j <= N - len; j++) {
                    if (len == 1) {     // BASE CASE:    len == 1, initilization
                        dp[i][j][len] = s1.charAt(i) == s2.charAt(j);
                    } else {            // GENERAL CASE: len 2 --> N
                        for (int l = 1; l <= len - 1; l++) { // l is the split, len of first part prefix
                            dp[i][j][len] = (dp[i][j][l] && dp[i + l][j + l][len - l]) ||     // no swap
                                            (dp[i][j + len - l][l] && dp[i + l][j][len - l]); // swap
                            if (dp[i][j][len]) break; // solution found, break
                        }
                    }
                }
            }
        }
        return dp[0][0][N];
    }

    //----------------   UTIL FUNCTION: Anagram ----------------------//
    // also used in InterleavingString.java
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

