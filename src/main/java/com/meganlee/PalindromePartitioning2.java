package com.meganlee;

import java.util.stream.*;

public class PalindromePartitioning2 {
    //--------------------- Solution 1 --------------------------//
    // backtracing: Time Limit Exceeded (1min for PalindromePartitioning2Test) 
    public int minCut(String s) {
        // validate input
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int[] res = {s.length() - 1};
        findResult(s, 0, -1, res);
        return res[0];
    }

    private void findResult(String s, int start, int curCut, int[] res) {
        // base case
        if (start >= s.length()) {
            res[0] = Math.min(res[0], curCut);
        }
        // general case
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                findResult(s, end + 1, curCut + 1, res);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        return start > end;
    }

    //--------------------- Solution 2 --------------------------//
    // dp: with isPalin table
    public int minCut2(String s) {
        // validate input
        if (s == null || s.length() <= 1) {
            return 0;
        }
        // 1st dp: build valid table
        int N = s.length();
        boolean[][] isPalindrome = new boolean[N][N]; // isPalindrome[start][end] => substring(start, end+1) is valid
        for (int end = 0; end < N; end++) { // outer loop needs to be end (could also use len)
            for (int start = 0; start <= end; start++) {
                if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || isPalindrome[start + 1][end - 1])) { // end - 1 has been calculated
                    isPalindrome[start][end] = true;
                }
            }
        }
        // 2nd dp: find min cut
        int[] cuts = IntStream.range(0, N).toArray(); // initial value: dp[i] = i;
        for (int end = 0; end < N; end++) {
            // cuts[end] = end; // could also do initialization here
            for (int start = 0; start <= end; start++) {
                if (isPalindrome[start][end]) {
                    int newCutAtEnd = (start == 0) ? 0 : cuts[start - 1] + 1;
                    cuts[end] = Math.min(cuts[end], newCutAtEnd);
                }
            }
        }
        return cuts[N - 1];
    }


    //--------------------- Solution 3 --------------------------//
    // dp: Iterate through all chars as mid point, expand on both side and update dp[end]
    // T=O(N^2), S=O(N)
    public int minCut3(String s) {
        // validate input
        if (s == null || s.length() <= 1) {
            return 0;
        }
        // dp
        int N = s.length();
        int[] cuts = IntStream.range(0, N).toArray(); // initial value: cuts[i] = i
        for (int mid = 1; mid <  N; mid++) { // iterate through all chars as mid point of palindrome
            // CASE 1. odd len: center is at index mid, expand on both sides
            for (int start = mid, end = mid; start >= 0 && end < N && s.charAt(start) == s.charAt(end); start--, end++) {
                int newCutAtEnd = (start == 0) ? 0 : cuts[start - 1] + 1;
                cuts[end] = Math.min(cuts[end], newCutAtEnd);
            }
            // CASE 2: even len: center is between [mid-1,mid], expand on both sides
            for (int start = mid - 1, end = mid; start >= 0 && end < N && s.charAt(start) == s.charAt(end); start--, end++) {
                // exactly same as content of above for loop
                int newCutAtEnd = (start == 0) ? 0 : cuts[start - 1] + 1;
                cuts[end] = Math.min(cuts[end], newCutAtEnd);
            }
        }
        return cuts[N - 1];
    }
}
