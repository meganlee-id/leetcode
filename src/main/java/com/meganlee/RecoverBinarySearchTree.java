package com.meganlee;

public class RecoverBinarySearchTree {
    TreeNode[] pair = new TreeNode[2];
    TreeNode pre = null;

    public void recoverTree(TreeNode root) {
        // Use [] as mimic to instance variables:
        //      TreeNode[] pair = new TreeNode[2];
        //      TreeNode[] pre = new TreeNode[1]; 
        //      findPair(root, pair, pre); swap(pair);
        findPair(root);  
        swapPair();
    }
    
    private void findPair(TreeNode cur) {
        // base case
        if (cur == null) {
            return;
        }
        // general case: inorder traverse
        findPair(cur.left);
        if (pair[0] == null && pre != null && pre.val > cur.val) { // 1st not yet found, 1st node condition met
            pair[0] = pre;
        }
        if (pair[0] != null && pre != null && pre.val > cur.val) { // 1st already found, 2nd node condition met
            pair[1] = cur;
        }
        pre = cur;
        findPair(cur.right);
    }

    private void swapPair() {
        int temp = pair[0].val;
        pair[0].val = pair[1].val;
        pair[1].val = temp;
    }
}
