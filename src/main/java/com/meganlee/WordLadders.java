package com.meganlee;

import java.util.*;

public class WordLadders {
    //--------------------- Solution 1 ----------------------//
    // one-way BFS: level by level traversal
    // Assuption 1) all words, including begin/end non-null/non-empty/same-len/unique 
    //           2) only a-z lowerletter chars
    //           3) endWord SHOULD be in dict, beginWord NO NEED to be in list, they r n
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Fast return using endWord
        if (!wordList.contains(endWord)) {
            return 0;
        }
        // dict.add(end); // if endWord don't have to be in dict, we add it

        // BFS traverse
        Set<String> dict  = new HashSet(wordList);  // construct a set for faster lookup
        Set<String> visited = new HashSet();        // visited in previous level
        int dictance = 1;
        Set<String> level = new HashSet(Arrays.asList(beginWord));    // first level
        visited.add(beginWord);
        while (!level.isEmpty() && !level.contains(endWord)) {
            Set<String> nextLevel = new HashSet();
            // for each word in previous level
            for (String word: level) {
                for (int i = 0; i < word.length(); i++) {  // for each char position
                    char[] chars = word.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) { // change it with 26 mutations
                        chars[i] = ch;
                        String mutation = new String(chars);
                        // found next neighbor: mutation
                        if (dict.contains(mutation) && !visited.contains(mutation)) { // in dict, haven't be visited
                            nextLevel.add(mutation);
                            dict.remove(mutation); // NOTE: understand why we could remove it!
                        }
                    }
                }
            }
            level = nextLevel;
            dictance++;
        }
        // if we reach here, we couldntt find next leve
        // 1. level.isEmpty(): still words left, but no connectivity
        // 2. dict.isEmpty():  no words left, no further connectivity
        return 0;
    }

    //--------------------- Solution 2 ----------------------//
    // two-way BFS: level by level traversal
   public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        // Fast return using endWord
        if (!wordList.contains(endWord)) {
            return 0;
        }

        // 2-end BFS traverse
        Set<String> dict = new HashSet(wordList);  // use a set for faster lookup
        Set<String> visited = new HashSet();
        Set<String> beginSet = new HashSet(Arrays.asList(beginWord));
        Set<String> endSet = new HashSet(Arrays.asList(endWord));
        int dictance = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // set the smaller set to be "beginSet"
            if (beginSet.size() > endSet.size()){
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            // compute next level from the smaller "beginSet"
            Set<String> set = new HashSet();
            for (String word: beginSet) {                  // for each word in previous level
                for (int i = 0; i < word.length(); i++) {  // for each char position
                    char[] chars = word.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) { // change it with 26 mutations
                        chars[i] = ch;
                        String mutation = new String(chars);
                        if (endSet.contains(mutation)){
                            return dictance + 1;
                        } else if (dict.contains(mutation) && !visited.contains(mutation)){
                            set.add(mutation);  // put to next level
                            visited.add(mutation);
                        }
                    }
                }
            }
            beginSet = set;
            dictance++;
        }
        return 0;
    }

    //----------- A util fuction that is not used here but worth mentioning ----------//
    // O(Len*26): Use Character iteration to find all possible paths
    // O(N):      Do not compare one word to all the other words and check if they only differ by one character.
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