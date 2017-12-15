package com.meganlee;

import java.util.*;

class LengthOfLongestSubstringKDistinct {
    //--------------- Solution 1 ----------------//
    // a typical sliding window problem
    // int[256] + count:  char freq
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // input vlidation
        if (s == null || s.length() == 0 || k <= 0) {
            return 0;
        }
        // sliding window, using int[] as char frequency table
        int maxLen = 0;
        int count = 0; // count the # of distinct characters
        int[] freq = new int[256]; // ASCII characters 1) 0-31 control 2) 32-127 printable 3) 128-255 extended
        for (int start = 0, end = 0; end < s.length(); end++) {
            char eChar = s.charAt(end);
            // update freq/count,
            freq[eChar]++;
            count += (freq[eChar] == 1) ? 1 : 0;
            // if count exceeded restrain k, adjust start
            while (count > k) { 
                char sChar = s.charAt(start);
                // update freq/count
                freq[sChar]--;
                count -= (freq[sChar] == 0) ? 1 : 0;
                start++;
            }
            // update result
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }

    //--------------- Solution 2 ----------------//
    // a typical sliding window problem
    // int[256] + count:  char freq
    public int lengthOfLongestSubstringKDistinct2(String s, int k) {
        // input vlidation
        if (s == null || s.length() == 0 || k <= 0) {
            return 0;
        }
        // sliding window, using Map as char frequency table
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int start = 0, end = 0; end < s.length(); end++) {
            char eChar = s.charAt(end);
            map.put(eChar, map.getOrDefault(eChar, 0) + 1); //~~~~ map.getOrDefault(key, defaultValue)
            // if num of keys so far exceeded restrain k, adjust start
            while (map.size() > k) {    //~~~~ map.size number of <k,v> pairs
                char sChar = s.charAt(start);
                map.put(sChar, map.get(sChar) - 1);
                if (map.get(sChar) == 0) { 
                    map.remove(sChar); //~~~~  map.remove(key)
                }
                start++;
            }
            // update result
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}