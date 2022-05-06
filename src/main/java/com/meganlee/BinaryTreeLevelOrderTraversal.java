package com.meganlee;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    //------------------- Solution 1 -------------------//
    // iterative BFS: size + queue
    public List<List<Integer>> levelOrder(TreeNode root) {
        // input validation
        List<List<Integer>> res = new ArrayList();
        if (root == null) {
            return res;
        }
        // traverse level by level
        Queue<TreeNode> q = new LinkedList(Arrays.asList(root));
        while (!q.isEmpty()) {
            List<Integer> vals = new ArrayList();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                vals.add(cur.val);
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            res.add(vals);
        }
        return res;
    }

    //------------------- Solution 2 -------------------//
    // recursive DFS: size + queue
    public List<List<Integer>> levelOrder2(TreeNode root) {
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
            res.add( new LinkedList());  // better use LinkedList, add a new level
        }
        // 2. get row of current root
        List<Integer> row  = res.get(level);
        row.add(curr.val);             // odd row, add to head
        // 3. recurive calls
        dfs(curr.left, res, level + 1);
        dfs(curr.right, res, level + 1);
    }
}
