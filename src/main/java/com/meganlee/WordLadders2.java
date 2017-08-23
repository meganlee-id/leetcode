package com.meganlee;

import java.util.*;
import java.util.stream.*;

public class WordLadders2 {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // Assume 1) begin/endWord non-empty 2) all words same len/unique 3) only a-z chars
        // result collector
        List<List<String>> res = new ArrayList();

        // {start + nodeNeighbors, nodeLevel} defines the TREE that contains the answer   
        Map<String, List<String>> nodeNeighbors = new HashMap();  // node's all "neighbors" exists in dict
        Map<String, Integer> nodeLevel = new HashMap();           // which level a node belongs to in the BFS traversed TREE

        // STEP 1: use bfs to construct the TREE that conatins the answer {start + nodeNeighbors, nodeLevel}
        // the original wordList is a graph, we use BFS for the solution TREE, where last level has 'endWord'
        boolean foundEnd = bfs(start, end, dict, nodeNeighbors, nodeLevel);

        // STEP 2: use DFS TREE to collect all paths from TREE: {start + nodeNeighbors, nodeLevel}, 
        if (foundEnd) {
            dfs(res, new ArrayList(), start, nodeNeighbors, nodeLevel, end);
        }
        return res;
    }

    // BFS: use level-by-level traversal
    private boolean bfs(String start, String end, Set<String> dict, Map<String, List<String>> nodeNeighbors, Map<String, Integer> nodeLevel) {
        // initialize dict
        dict.add(end);
        List<String> level = Arrays.asList(start); // first level
        int distance = 1; 
        while (!level.isEmpty() && !level.contains(end)) {
            List<String> nextLevel = new ArrayList();
            for (String word : level) {
                // find all reachable words in dict
                List<String> neighbors = new ArrayList();
                for (int i = 0; i < word.length(); i++) {
                    char[] chars = word.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String mutation = new String(chars);
                        if (dict.contains(mutation)) {
                            neighbors.add(mutation);
                        }
                    }
                }
                // update {nodeNeighbors, nodeLevel, nextLevel}
                nodeNeighbors.put(word, neighbors);
                for (String n: neighbors) {
                    if (!nodeLevel.containsKey(n)) { // haven't visited in previous level || current level
                        nodeLevel.put(n, distance + 1);
                        nextLevel.add(n); // nextLevel should contain unique words
                    }
                }
            }
            level = nextLevel;
            distance++;
        }
        return level.contains(end);
      }

    // DFS: output all paths with the shortest distance.
    // ------------- 1) res: collector  -------  2) path: builder  -------- 3) {cur + nodeNeighbors, nodeLevel}: element pool  ------- 4) end: end condition
    private void dfs(List<List<String>> res, List<String> path, String cur, Map<String, List<String>> nodeNeighbors, Map<String, Integer> nodeLevel, String end) {
        path.add(cur);
        if (cur.equals(end)) {
            res.add(new ArrayList(path));
        } else {
            for (String n: nodeNeighbors.get(cur)) {
                if (nodeLevel.get(n) == nodeLevel.get(cur) + 1) {
                    dfs(res, path, n, nodeNeighbors, nodeLevel, end);
                }
            }
        }
        path.remove(path.size() - 1); // remove(Obj o); no duplicates in dict
    }
}