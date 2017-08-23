package com.meganlee;

import java.util.*;

public class LengthOfLongestSubstring {
    //---------- Solution 1:  Sliding Window--------------
    // brute-force
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxLen = 0;
        for (int start = 0; start < s.length(); start++) {
            for (int end = start; end < s.length(); end++) {
                Set<Character> seenChars = new HashSet();
                for (int i = start; i <= end; i++) {
                    if (seenChars.contains(s.charAt(i))) {
                        break;
                    } else {
                        seenChars.add(s.charAt(i));
                        maxLen = Math.max(maxLen, i - start + 1);
                    }
                }
            }
        }
        return maxLen;
    }

    //---------- Solution 2:  Sliding Window--------------
    // seen flag: HashSet or boolean[256]
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Set<Character> seenChars = new HashSet();
        int maxLen = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (seenChars.contains(ch)) {
                seenChars.remove(s.charAt(start));
                start++;
                end--; // DO NOT move end pointer (counter end++ effect in for loop)
            } else {
                seenChars.add(ch);
                maxLen = Math.max(maxLen, end - start + 1);
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

        int[] table = new int[256];
        Arrays.fill(table, -1);
        int maxLen = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            int lastIndex = table[ch];  // ch could be auto converted to in
            if (lastIndex < start) {    // NOT  in cur substr: either -1 for unseen, or <start for earlier occurrence
                maxLen = Math.max(maxLen, end - start + 1);
            } else {                    // seen in cur substr
                start = lastIndex + 1;
            }
            table[ch] = end;            // update seen table along each step
        }
        return maxLen;
    }
}