package com.meganlee;


public class PopulateNextPointer {
    //--------------- Solution 1 -----------------//
    // recursion: divide and conquer
    public void connect(TreeLinkNode root) {
        // base case
        if (root == null) {
            return;
        }

        // general case: divide and conquer
        // divide
        connect(root.left);
        connect(root.right);

        // conquer: connect left and right parts level by level
        TreeLinkNode left = root.left, right = root.right;
        while (left != null && right != null) { // both null or both non-null (perfect binary tree)
            // link
            left.next = right;
            // next level
            left = left.right;
            right = right.left;
        }
    }

    //------------------- Solution 2 ----------------//
    // level-by-level traversal (use .next pointer)
    public void connect2(TreeLinkNode root) {
        TreeLinkNode levelHead = root;
        while (levelHead != null) {
            // 1. link all nodes
            TreeLinkNode cur = levelHead;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
                if (cur.right != null && cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            // 2. update level
            levelHead = levelHead.left;
        }
    }
}

