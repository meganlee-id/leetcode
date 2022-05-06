package com.meganlee;


public class PopulateNextPointer {
    //--------------- Solution 1 -----------------//
    // recursion: divide and conquer
    public void connect(TreeLinkNode root) {
        // 1. Base case
        if (root == null) {
            return;
        }
        // 2. General case: divide and conquer
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
    // level-by-level traversal (use a dummyHead)
    public void connect2(TreeLinkNode root) {
        TreeLinkNode preHead = root; // head of previous level
        while (preHead != null) { // whilc last level not null, we still need to connect it's next level
            TreeLinkNode newDummy = new TreeLinkNode(0); // newHead is dummyHead of new level
            TreeLinkNode tail = newDummy; // pre is the tail of new level
            TreeLinkNode cur  = preHead; // cur will traverse node of previous level
            while (cur != null) {
                if (cur.left != null) {
                    tail.next = cur.left;
                    tail = tail.next;
                }
                if (cur.right != null) {
                    tail.next = cur.right;
                    tail = tail.next;
                }
                cur = cur.next;
            }
            // 2. update head for level
            preHead = newDummy.next;
        }
    }
}
