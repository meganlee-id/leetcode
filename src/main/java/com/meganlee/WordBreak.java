package com.meganlee;

import java.util.*;
import java.util.stream.*;

public class WordBreak {
    //---------- DP -------------//
    // more solutions, pls check here: 
    // https://leetcode.com/problems/word-break/solution/
    public boolean wordBreak(String s, Set<String> dict) {
        // input validation
        if (s == null || s.length() == 0) {
            return true;
        }
        if (dict == null || dict.size() == 0) {
            return false;
        }

        // get max and min len of the words
        int minLen = Integer.MAX_VALUE;
        int maxLen = Integer.MIN_VALUE;
        for (String word: dict) {
            int wordLen = word.length();
            minLen = Math.min(minLen, wordLen);
            maxLen = Math.max(maxLen, wordLen);
        }
        // start calculation
        boolean[] res = new boolean[s.length() + 1]; // res[len], can prefix with len i be segmented
        res[0] = true;
        for (int end = minLen; end <= s.length(); end++) {
            for (int start = Math.max(end - maxLen, 0); start <= end - minLen; start++) {
                String curWord = s.substring(start, end);
                if (dict.contains(curWord) && res[start]) { // res[start] record the substring BEFORE index start
                    res[end] = true;
                    break;
                }
            }
        }
        return res[s.length()];
    }
}

// 1. Discuss about what should be returned when s == null s is empty string
//          according to test cases, we should return new ArrayList();
// 2. Discuss about whether words in the dict could be used multiple times
//          it seems that dict words could be used multiple times
// 3. Optimization: minLen and maxLen
// 4. Error:      for (int j = i - maxLen; ...)
//            --> for (int j = Math.max(i - maxLen, 0); ...)
