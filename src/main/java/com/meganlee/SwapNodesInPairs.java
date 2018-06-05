package com.meganlee;


public class SwapNodesInPairs {
    //------------- Solution 1 ---------------//
    // Recursion Version, no space constraint
    public ListNode swapPairs(ListNode head) {
        // base case: num(nodes) <= 1
        if (head == null || head.next == null) {
            return head;
        }
        // general case: num(nodes) >= 2
        ListNode newHead = head.next;
        ListNode rest = swapPairs(newHead.next);
        newHead.next = head;
        head.next = rest;
        return newHead;
    }

    //------------- Solution 2 ---------------//
    // Space constrain & could not change val
    public ListNode swapPairs2(ListNode head) {
        //------ input check: <= 0 nodes ----------//
        if (head == null || head.next == null) {
            return head;
        }
        //------- for there are >= 2 nodes --------//
        // pre:     node previous to the pair
        // n1, n2:  nodes to be swapped in each group
        // post:    node after the pair
        ListNode dummy = new ListNode(0), pre = dummy;
        dummy.next = head;
        while (pre.next != null && pre.next.next != null) {
            // 1. record
            ListNode n1 = pre.next, n2 = n1.next, post = n2.next;
            // 2. swap
            pre.next = n2;
            n2.next = n1;
            n1.next = post;
            // 3. update pre
            pre = n1;  // ATTENTION: pre = n1 not n2!!!
        }
        return dummy.next;
    }
}