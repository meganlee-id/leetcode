package com.meganlee;

import java.util.*;
import java.util.stream.*;

public class WordLadders2 {
    //----------------------- SOLUTION 1 -----------------------//
    // 1-end BFS + DFS
    // Assumption: 1) all words, including begin/end non-null/non-empty/same-len/unique 
    //             2) only a-z lowerletter chars
    //             3) end SHOULD be in dict, start NO NEED to be in list
    public List<List<String>> findLadders2(String start, String end, List<String> dict) {
        // Fast return
        if (!dict.contains(end)) {
            return new ArrayList();
        }
        
        // STEP 1: BFS - WHETHER there is an anwser
        Set<String> dictSet = new HashSet(dict); // convert dict into a set for quick lookup, otherwise "Time Limit Exceeded" 
        Set<String> visited = new HashSet();     // visited in previous level
        Map<String, List<String>> graph = new HashMap();  // node's all "neighbors" exists in dict
        boolean foundEnd = bfs2(start, end, dictSet, visited, graph);

        // STEP 2: DFS - COLLECT all paths from TREE: {start + graph}
        List<List<String>> res = new ArrayList();
        if (foundEnd) {
            dfs2(res, new ArrayList(), start, end, graph);
        }
        return res;
    }

    // BFS: use level-by-level traversal
    private boolean bfs2(String start, String end, Set<String> dict, Set<String> visited, Map<String, List<String>> graph) {
        Set<String> level = new HashSet(Arrays.asList(start)); // first level
        visited.add(start); // add to visited. avoid loop when start also appears in dict. e.g hit (start) -> hot (in dict) -> hit (in dict)...
        while (!level.isEmpty() && !level.contains(end)) {
            Set<String> nextLevel = new HashSet();
            // for each word in previous level
            for (String word: level) {
                List<String> neighbors = new ArrayList();  // store next level neighbors (neighbor depth = word depth + 1)
                for (int i = 0; i < word.length(); i++) {  // for each position
                    char[] chars = word.toCharArray();     // use a char array to help
                    for (char ch = 'a'; ch <= 'z'; ch++) { // replace it with a diff 'char' (might be myself)
                        chars[i] = ch;
                        String mutation = new String(chars);
                        //-- has mutation in dict ---|--- NOT visited yet ---------|------- NOT in cur level ----|
                        if (dict.contains(mutation) && !visited.contains(mutation) && !level.contains(mutation)) {
                            neighbors.add(mutation);
                        }
                    }
                }
                graph.put(word, neighbors);
                nextLevel.addAll(neighbors);
            }
            visited.addAll(nextLevel);
            level = nextLevel;
        }
        return level.contains(end);
    }

    // DFS: output all paths with the shortest distance.
    private void dfs2(List<List<String>> res, List<String> path, String cur, String end, Map<String, List<String>> graph) {
        path.add(cur);
        if (cur.equals(end)) {
            res.add(new ArrayList(path));
        } else {
            for (String n: graph.getOrDefault(cur, Arrays.asList())) { // cur might not have neighbors, use getOrDefault
                dfs2(res, path, n, end, graph);
            }
        }
        path.remove(path.size() - 1); // remove(Obj o); no duplicates in dict
    }
}