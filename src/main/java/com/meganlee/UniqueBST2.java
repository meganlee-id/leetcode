package com.meganlee;

import java.util.*;

public class UniqueBST2 {
    //--------------------  Solution 1 ---------------------//
    // pure recursion
    public List<TreeNode> generateTrees(int n) {
        // input checking
        if (n <= 0) {
            return new ArrayList();
        }
        // build a tree inrange
        return treesInRange(1, n);   // pay attention to the range [1, n]
    }
    
    private List<TreeNode> treesInRange(int start, int end) {
        // base case
        if (start > end) {
            return Arrays.asList((TreeNode) null); // ATTENTION! must have this as empty subtree
        }
        // general case: the trees are sharing the same sub-structure!!!
        List<TreeNode> trees = new ArrayList();
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = treesInRange(start, i - 1);
            List<TreeNode> rightTrees = treesInRange(i + 1, end);
            for (TreeNode l: leftTrees) {
                for (TreeNode r: rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    trees.add(root);
                }
            }
        } 
        return trees;
    }

    //--------------------  Solution 2 ---------------------//
    // recursion + cache
    public List<TreeNode> generateTrees2(int n) {
        // input checking
        if (n <= 0) {
            return new ArrayList();
        }
        List[][] cache = new List[n + 1][n + 1]; // dp[start][end], each cell is a list
        return helper(1, n, cache);
    }

    private List<TreeNode> helper(int start, int end, List[][] cache) {
        // base case
        if (start > end) {
            return Arrays.asList((TreeNode) null);
        }
        // general case
        // --- 1) update cache
        if (cache[start][end] == null) {
            List<TreeNode> trees = new ArrayList();
            for (int val = start; val <= end; val++) {
                List<TreeNode> leftTrees = helper(start, val - 1, cache);
                List<TreeNode> rightTrees = helper(val + 1, end, cache);
                for (TreeNode right : rightTrees) {
                    for (TreeNode left : leftTrees) {
                        TreeNode root = new TreeNode(val);
                        root.right = right;
                        root.left = left;
                        trees.add(root);
                    }
                }
            }
            cache[start][end] = trees;
        }
        // --- 2) compute result
        return cache[start][end];
    }


    //--------------------  Solution 3 ---------------------//
    // dp[start][len] --> really tricky, not recommended, but good practice for dp thoughts
    public List<TreeNode> generateTrees3(int n) {
        // input validation
        if (n <= 0) {
            return new ArrayList();
        }
        // create the dp table and initialize
        List[][] dp = new List[n + 1][n + 1];  // dp[start][end], each cell is a list
        List<TreeNode> nullTree = Arrays.asList((TreeNode) null); // type cast. otherwise will be NullException
        for (int len = 1; len <= n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int end = start + len - 1;
                dp[start][end] = new ArrayList();
                for (int i = start; i <= end; i++) {
                    List<TreeNode> leftTrees = (i == start) ? nullTree : dp[start][i - 1];
                    List<TreeNode> rightTrees = (i == end)  ? nullTree : dp[i + 1][end];
                    for (TreeNode l : leftTrees) {
                        for (TreeNode r : rightTrees) {
                            TreeNode root = new TreeNode(i);
                            root.left = l;
                            root.right = r;
                            dp[start][end].add(root);
                        }
                    }
                }
            }
        }
        return dp[1][n];
    }
}

