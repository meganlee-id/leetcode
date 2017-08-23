package com.meganlee;

import java.util.*;
import java.util.stream.*;

public class SubstringConcatenation {
    //------------------- Solution 1 -------------------//
    // brute-force, use each index of s as start point
    public static List<Integer> findSubstring(String s, String[] words) {
        // input checking
        List<Integer> res = new ArrayList();
        if (s == null || words == null || s.length() == 0 || words.length == 0) {
            return res;
        }
        // define frequently used variables
        int strLen = s.length(), wordLen = words[0].length(), numWords = words.length;
        if (strLen < wordLen * numWords) {
            return res; // fast check
        }
        // word frequency: (stream is slower than pure java)
        Map<String, Long> wordsCount = Arrays.stream(words).collect(Collectors.groupingBy(w -> w, Collectors.counting()));
        // Map<String, Long> wordsCount = new HashMap();
        // for (String w: words) {
        //     wordsCount.put(w, wordsCount.containsKey(w) ? wordsCount.get(w) + 1 : 1);
        // }
        for (int start = 0; start <= strLen - wordLen * numWords; start++) { // start index increments 1-by-1
            Map<String, Long> wordsLeft = new HashMap(wordsCount);         // reset unUsedWords with each start index
            for (int count = 0; count < numWords; count++) {
                String curWord = s.substring(start + count * wordLen, start + (count + 1) * wordLen);
                if (wordsLeft.containsKey(curWord) && wordsLeft.get(curWord) > 0) { // 1st condition needed!, you might have a word not contained in dict
                    wordsLeft.put(curWord, wordsLeft.get(curWord) - 1);
                    if (count == numWords - 1) { // solution found, add to res collection
                        res.add(start);
                    }
                } else {
                     break;
                }
            }
        }
        return res;  // remember to return res;
    }

    //------------------- Solution 2 -------------------//
    // sliding window
    public static List<Integer> findSubstring2(String s, String[] words) {
        // input checking
        List<Integer> res = new ArrayList();
        if (s == null || words == null || s.length() == 0 || words.length == 0) {
            return res;
        }
        // define frequently used variables
        int strLen = s.length(), wordLen = words[0].length(), numWords = words.length;
        if (strLen < wordLen * numWords) {
            return res; // fast check
        }
        // word frequency
        Map<String, Long> wordsCount = Arrays.stream(words).collect(Collectors.groupingBy(w -> w, Collectors.counting()));
        for (int i = 0; i < wordLen; i++) { // wordLen cycle of sliding window, in each cycle we reuse precomputed
            Map<String, Long> wordsLeft = new HashMap(wordsCount); // reset unUsedWords with each sliding window string
            // substring between [start, end] is always a candidate of a solution
            for (int start = i, end = i; end <= strLen - wordLen; end += wordLen) {
                String curWord = s.substring(end, end + wordLen);
                if (wordsLeft.containsKey(curWord)) {
                    if (wordsLeft.get(curWord) > 0) { // curWord still available
                        wordsLeft.put(curWord, wordsLeft.get(curWord) - 1); // use it
                        if (end == start + (numWords - 1) * wordLen) { // might find solution here
                            // collect result
                            res.add(start);
                            // move start
                            String startWord = s.substring(start, start + wordLen);
                            wordsLeft.put(startWord, wordsLeft.get(startWord) + 1);
                            start += wordLen;
                        }
                    } else { // curWord not available
                        // move start
                        String startWord = s.substring(start, start + wordLen);
                        wordsLeft.put(startWord, wordsLeft.get(startWord) + 1);
                        start += wordLen;
                        // end stays the same
                        end -= wordLen;
                    }
                } else { // word not contained in dict
                    wordsLeft = new HashMap(wordsCount); // reset wordsLeft
                    start = end + wordLen; // new start
                }
            }
        }
        return res;  // remember to return res;
    }
}
