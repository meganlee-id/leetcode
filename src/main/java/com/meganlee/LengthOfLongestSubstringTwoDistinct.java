package com.meganlee;

import java.util.*;

public class LengthOfLongestSubstringTwoDistinct {
    // exactly the same code as LengthOfLongestSubstringKDistinct
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // input vlidation
        if (s == null || s.length() == 0) {
            return 0;
        }
        // sliding window, using Map as char frequency table
        int maxLen = 0;
        Map<Character, Integer> freq = new HashMap();
        for(int start = 0, end = 0; end < s.length(); end++) {
            // 1) update cache(freq/count)
            char eChar = s.charAt(end);
            freq.put(eChar, freq.getOrDefault(eChar, 0) + 1); //~~~~ freq.getOrDefault(key, defaultValue)
            // 2) adjust start, to keep the invariant
            while (freq.size() > 2) {    //~~~~ freq.size number of <k,v> pairs
                char sChar = s.charAt(start);
                freq.put(sChar, freq.get(sChar) - 1);
                freq.remove(sChar, 0); //~~~~  freq.remove(key, val)
                start++;
            }
            // 3) invariant hold: update result
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}