package com.meganlee;


public class ReverseNodesInKGroup {
    //------------------- BASICS ------------------//
    // this is the solution for reversing all groups
    public ListNode reverseAllKGroup(ListNode head, int k) {
        // input validation
        if (head == null || k <= 1) {
            return head;
        }
        // reverse
        ListNode dummy = new ListNode(0), pre = dummy;
        dummy.next = head;
        while (pre.next != null) {
            ListNode tail = pre.next;
            for (int i = 0; i < k - 1 && tail.next != null; i++) {
                ListNode cur = tail.next;
                tail.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            pre = tail;
        }
        return dummy.next;
    }

    //------------------- Solution ------------------//
    // last group < k nodes won't be reversed
    public ListNode reverseKGroup(ListNode head, int k) {
        // input validation
        if (head == null || k <= 1) {
            return head;
        }
        // reverse in k group
        ListNode dummy = new ListNode(0), pre = dummy;
        dummy.next = head;
        while (pre.next != null) {
            // count # of nodes in next group
            ListNode tail = pre.next;
            int cnt = 0;
            while (tail != null && cnt < k) {
                cnt++;
                tail = tail.next;
            }
            // 1. not enough nodes, break
            if (cnt < k) {
                break;
            }
            // 2. enough nodes, reverse next group of k nodes
            tail = pre.next;
            for (int i = 0; i < k - 1; i++) {
                ListNode cur = tail.next;
                tail.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            pre = tail;
        }
        return dummy.next;
    }

}

