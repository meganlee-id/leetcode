package com.meganlee;

import java.util.*;

public class StringConcatenationOfAllWords {
    //-------------------  Solution 1 --------------------//
    // Brute Force: check all substring with length of (numWords * wordLen)
    public List<Integer> findSubstring(String s, String[] words) {
        // input check
        List<Integer> res = new ArrayList();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return res;
        }
        // get freq
        Map<String, Integer> freq = new HashMap();
        for (String word: words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        // 2 pointers brute force
        int cnt = words.length, len = words[0].length();
        for (int start = 0; start <=  s.length() - cnt * len; start++) {
            if (isConcatWords(s, start, freq, cnt, len)) res.add(start);
        }
        return res;
    }
    
    private boolean isConcatWords(String s, int start, Map<String, Integer> freq, int cnt, int len) {
        Map<String, Integer> dict = new HashMap(freq);
        for (int i = 0; i < cnt; i++) {
            String nextWord = s.substring(start + i * len, start + (i + 1) * len);
            if (dict.containsKey(nextWord)) {
                dict.put(nextWord, dict.get(nextWord) - 1);
                dict.remove(nextWord, 0);
            } else {
                return false;
            }
        }
        return true;
    }

    //-------------------  Solution 2 --------------------//
    // sliding window: no backwards, reuse pre-computed results
    public List<Integer> findSubstring2(String s, String[] words) {
        // input check
        List<Integer> res = new ArrayList();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return res;
        }
        // get freq
        Map<String, Integer> freq = new HashMap();
        for (String word: words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        // sliding windown
        int cnt = words.length, len = words[0].length();
        // pay attention to the end conditions in for loop
        for (int start = 0; start <= Math.min(len - 1, s.length() - cnt * len); start++) {
            collect(s, start, freq, cnt, len, res);
        }
        return res;
    }
    
    private void collect(String s, int idx, Map<String, Integer> freq, int cnt, int len, List<Integer> res) {
        Map<String, Integer> dict = new HashMap(freq);
        // pay attention to the end conditions in for loop
        for (int start = idx, end = idx; start <= s.length() - cnt * len && end <= s.length() - len; end += len) {
            String nextWord = s.substring(end, end + len);
            if (!freq.containsKey(nextWord)) {      // word not in dict
                dict = new HashMap(freq); // !ATTENTION!: easy to forget this line!!! re-populate dict
                start = end + len;        // reset start
            } else if (freq.containsKey(nextWord)) { // word is valid
                // update cache
                dict.put(nextWord, dict.get(nextWord) - 1);
                // adjust start
                while (dict.get(nextWord) < 0) {
                    String startWord = s.substring(start, start + len);
                    dict.put(startWord, dict.get(startWord) + 1);
                    start += len;
                }
                // update res
                if ((end - start) / len == cnt - 1) res.add(start);
            }
        }
    }
}
