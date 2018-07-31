package com.meganlee;

import java.util.*;

public class LengthOfLongestSubstringKDistinct {
    //--------------- Solution 1 ----------------//
    // a typical sliding window problem
    // int[256] + count:  char freq
    public int lengthOfLongestSubstringKDistinct2(String s, int k) {
        // input vlidation
        if (s == null || s.length() == 0 || k < 1) { // must check k invalidaty
            return 0;
        }
        // sliding window, using Map as char frequency table
        int maxLen = 0;
        Map<Character, Integer> freq = new HashMap();
        for(int start = 0, end = 0; end < s.length(); end++) {
            // get end char
            char eChar = s.charAt(end);
            // invariant not satisfied, try to move start one-by-one
            // could also use while here, here we use (if with end--) a trick
            if (freq.size() == k && !freq.containsKey(eChar)) {
                char sChar = s.charAt(start);
                freq.put(sChar, freq.get(sChar) - 1);
                freq.remove(sChar, 0); //~~~~  freq.remove(key, val)
                start++;
                end--;
            // invariant satisfied, update cache, update res
            } else {
                freq.put(eChar, freq.getOrDefault(eChar, 0) + 1);
                maxLen = Math.max(maxLen, end - start + 1);
            }
        }
        return maxLen; 
    }

    //--------------- Solution 2 ----------------//
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
            // 1) update cache(freq/count)
            char ch = s.charAt(end);
            freq[ch]++;
            count += (freq[ch] == 1) ? 1 : 0;
            // 2) adjust start, to keep the invariant
            while (count > k) { 
                // update freq/count,
                char sCh = s.charAt(start);
                freq[sCh]--;
                count -= (freq[sCh] == 0) ? 1 : 0;
                // increment start
                start++;
            }
            // 3) invariant hold: update result
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}