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
                Set<Character> seenChars = new HashSet();
                // check dupes between range [start, end]
                for (int i = start; i <= end; i++) {
                    if (seenChars.contains(s.charAt(i))) { // contains dupes, break
                        break;
                    } else {
                        seenChars.add(s.charAt(i));
                    }
                }
                // if no dupes, update maxLen
                if (seenChars.size() == end - start + 1) { // no access to i could not use (i == end + 1)
                    maxLen = Math.max(maxLen, seenChars.size());
                }
            }
        }
        return maxLen;
    }


    //---------- Solution 2:  Sliding Window--------------
    // sliding window: seen flag, HashSet/boolean[256]
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Set<Character> seenChars = new HashSet();
        int maxLen = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            // 1) adjust start, to keep the invariant
            char ch = s.charAt(end);
            while (seenChars.contains(ch)) {
                seenChars.remove(s.charAt(start));
                start++;
            }
            // 2) update cache
            seenChars.add(ch);
            // 3) invariant hold: update result
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
    

    //---------- Solution 3:  Sliding Window--------------
    // last index: HashMap or int[256]
    public int lengthOfLongestSubstring3(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] table = new int[256];
        Arrays.fill(table, -1);
        int maxLen = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            // 1) adjust start, to keep the invariant
            char ch = s.charAt(end);
            int lastIndex = table[ch];  // ch could be auto converted to int
            if (lastIndex >= start) {   // seen in cur substr, adjust start
                start = lastIndex + 1;
            } 
            // 2) update cache (seen table)
            table[ch] = end;
            // 3) invariant hold: update result
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}