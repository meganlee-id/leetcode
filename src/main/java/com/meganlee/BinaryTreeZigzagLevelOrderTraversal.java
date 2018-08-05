package com.meganlee;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    //------------------- Solution 1 -------------------//
    // BFS: Queue + Size
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // input validation
        List<List<Integer>> res = new ArrayList();
        if (root == null) {
            return res;
        }
        // define the first level
        Queue<TreeNode> q = new LinkedList(Arrays.asList(root));
        int curLevel = 0; //------ see which level it is
        // level by level traversal
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> row = new ArrayList();
            for (int i = 0; i < size; i++) {
                TreeNode n = q.poll();
                row.add(n.val);
                if (n.left != null) {
                    q.offer(n.left);
                }
                if (n.right != null) {
                    q.offer(n.right);
                }
            }
            if (curLevel % 2 == 1) {
                Collections.reverse(row);
            }
            curLevel++;
            res.add(row);
        }
        return res;
    }


    //------------------- Solution 1 -------------------//
    // DFS: with level
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        dfs(root, res, 0);
        return res;
    }
    
    private void dfs(TreeNode curr, List<List<Integer>> res, int level) {
        // base case
        if (curr == null) return;
        // general case
        // 1. reach a new level, create the row holder
        if (res.size() <= level) { 
            res.add( new LinkedList());  // better use LinkedList, new level
        }
        // 2. get row of current root
        List<Integer> row  = res.get(level);
        if (level % 2 == 0) row.add(curr.val); // even row, add to end
        else row.add(0, curr.val);             // odd row, add to head
        // 3. recurive calls
        dfs(curr.left, res, level + 1);
        dfs(curr.right, res, level + 1);
    }
}
