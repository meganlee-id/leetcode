package com.meganlee;

import java.util.*;

public class LengthOfLongestSubstring {
    //---------- Solution 1:  Sliding Window--------------
    // brute-force O(N^3): Time Limit Exceeded
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLen = 0;
        for (int start = 0; start < s.length(); start++) {
            for (int end = start; end < s.length(); end++) {
                if (!hasDupes(s, start, end)) {
                    maxLen = Math.max(maxLen, end - start + 1);
                }
            }
        }
        return maxLen;
    }

    private boolean hasDupes(String s, int start, int end) {
        // check dupes between range [start, end] both end inclusive
        Set<Character> seenChars = new HashSet();
        for (int i = start; i <= end; i++) {
            char ch = s.charAt(i);
            if (seenChars.contains(ch)) return true;
            else seenChars.add(ch);
        }
        return false;
    }


    //---------- Solution 2:  Sliding Window--------------
    // sliding window: seen flag, HashSet/boolean[256]
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> seenChars = new HashSet();
        int maxLen = 0;
        // window [start, end] should also contains all distinct chars
        for (int start = 0, end = 0; end < s.length(); end++) {
            // get char at end
            char ch = s.charAt(end);
            // invariant not hold: try to adjust start one-by-one
            if (seenChars.contains(ch)) {
                seenChars.remove(s.charAt(start)); // update cache
                start++;  // update start
                end--;
            // invariant satisfied, update cache, update res
            } else {
                seenChars.add(ch);  // update cache
                maxLen = Math.max(maxLen, end - start + 1); // update res
            }
        }
        return maxLen;
    }
    

    //---------- Solution 3:  Sliding Window--------------
    // last index: HashMap or int[256]
    public int lengthOfLongestSubstring3(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> lastIndex = new HashMap();
        int maxLen = 0;
        // window [start, end] should also contains all distinct chars
        for (int start = 0, end = 0; end < s.length(); end++) {
            // 1) get ch at end
            char ch = s.charAt(end);
            // 2) adjust start to keep invariant
            if (lastIndex.containsKey(ch)) {
                start =  Math.max(start, lastIndex.get(ch) + 1); // attention here
            }
            // 3) invariant satisfied, update cache, update res
            lastIndex.put(ch, end);  // update cache
            maxLen = Math.max(maxLen, end - start + 1); // update res
        }
        return maxLen;
    }
}