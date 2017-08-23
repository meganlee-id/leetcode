package com.meganlee;

import java.util.*;

public class WordLadders {
    //--------------------- Solution 1 ----------------------//
    // one-way BFS: level by level traversal
    public int ladderLength(String start, String end, Set<String> dict) {
        // Assume 1) all words, including start, end non-empty/same-len/unique 3) only a-z chars
        dict.add(end);
        List<String> level = Arrays.asList(start); // first level
        int dictance = 1;
        while (!level.isEmpty()) {
            List<String> nextLevel = new ArrayList();
            for (String word : level) {
                for (int i = 0; i < word.length(); i++) {
                    char[] chars = word.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String mutation = new String(chars);
                        // found next neighbor: mutation
                        if (dict.contains(mutation)) {
                            if (mutation.equals(end)) {
                                return dictance + 1;   // end found, return here
                            } else {
                                nextLevel.add(mutation);
                                dict.remove(mutation); // NOTE: understand why we could remove it!
                            }
                        }
                    }
                }
            }
            level = nextLevel;
            dictance++;
        }
        // if we reach here, we either didn't find next level, or we ran out of dict
        return 0;
    }

    //----------- A util fuction that is not used here but worth mentioning ----------//
    private boolean isConnected(String a, String b) {  
        // count the # of diff chars
        int diff = 0;  
        for (int i = 0; i < a.length(); i++) {  
            if (a.charAt(i) != b.charAt(i)) {  
                diff++;  
                if (diff >= 2) {
                    return false;  
                }
            }
        }
        return diff == 1;  
    }
}