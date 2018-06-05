package com.meganlee;

import java.util.*;

public class StringConcatenationOfAllWords {
    //-------------------  Solution 1 --------------------//
    // Brute Force: check all substring with length of (numWords * wordLen)
    public List<Integer> findSubstring(String S, String[] L) {
        // assume S and L are non-null and non-empty, L doesn't contain empty string
        List<Integer> res = new ArrayList();
        Map<String, Integer> freq = new HashMap();
        for (String word: L) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        int numWords = L.length, wordLen = L[0].length();
        for (int start = 0; start <= S.length() - numWords * wordLen; start++) {
            if (isValid(S, start, freq, numWords, wordLen)) {
                res.add(start);
            }
        }
        return res;
    }

    private boolean isValid(String S, int start, Map<String, Integer> freq, int numWords, int wordLen) {
        Map<String, Integer> dict = new HashMap(freq); // clone the dict: un-used words
        for (int i = 0; i < numWords; i++) {
            int left = start + i * wordLen;
            String word = S.substring(left, left + wordLen);
            if (dict.containsKey(word)) {
                dict.put(word, dict.get(word) - 1);
                dict.remove(word, 0);
            } else {
                return false;
            }
        }
        return true;
    }


    //-------------------  Solution 2 --------------------//
    // sliding window: no backwards, reuse pre-computed results
    public List<Integer> findSubstring2(String S, String[] L) {
        // assume S and L are non-null and non-empty, L doesn't contain empty string
        List<Integer> res = new ArrayList();
        Map<String, Integer> freq = new HashMap();
        for (String word: L) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        int numWords = L.length, wordLen = L[0].length();
        for (int i = 0; i < wordLen; i++) {
            populateResult(S, i, freq, numWords, wordLen, res);
        }
        return res;
    }

    private void populateResult(String S, int i, Map<String, Integer> freq, int numWords, int wordLen, List<Integer> res) {
        Map<String, Integer> dict = new HashMap(freq);  // clone the dict: un-used words
        for (int start = i, end = i; end <= S.length() - wordLen; end += wordLen) {
            if (start > S.length() - numWords * wordLen) { // fast break
                return;
            }
            // case A: not valid word
            String word = S.substring(end, end + wordLen);
            if (!freq.containsKey(word)) {
                dict = new HashMap(freq);   // re-populate dict
                start = end + wordLen;      // adjust start
            // case B: a valid word, not enough count left in dict
            } else {
                // 1. adjust start to satisfy the invariant
                while (!dict.containsKey(word)) {
                    String sWord  = S.substring(start, start + wordLen);
                    dict.put(sWord, dict.getOrDefault(sWord, 0) + 1);
                    start += wordLen;
                }
                // 2. update cache
                dict.put(word, dict.get(word) - 1);
                dict.remove(word, 0);
                // 3. update result
                if (dict.isEmpty()) {
                    res.add(start);
                }
            }
        }
    }
}
