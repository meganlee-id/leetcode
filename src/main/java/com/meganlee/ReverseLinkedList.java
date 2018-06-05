package com.meganlee;

public class ReverseLinkedList {
    //--------------------- Solution 1 -----------------------//
    // Recursive: Time O(n) Space O(n)
    public ListNode reverseList(ListNode head) {
        // base case: null || one node
        if (head == null || head.next == null) {
            return head;
        }
        // general case
        ListNode newHead = reverseList(head.next);
        ListNode newTail = head.next; // tail of reverseList(head.next); at line 11
        newTail.next = head;
        head.next = null;
        return newHead;
    }

    //--------------------- Solution 2 -----------------------//
    // Iterative: 3 pointers, move to a new List
    public ListNode reverseList2(ListNode head) {
        // null || one node, no revese needed
        if (head == null || head.next == null) {
            return head;
        }
        // 3 pointers
        ListNode pre = null; // newHead
        ListNode cur = head;
        while (cur != null) {
            // reverse
            ListNode post = cur.next;
            cur.next = pre;
            // update pointer
            pre = cur;
            cur = post;
        }
        return pre;
    }


    //--------------------- Solution 3 -----------------------//
    // Tail to Head: A basic step for reversing in GROUPs
    public ListNode reverseList3(ListNode head) {
        // null || one node, no revese needed
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode tail = head;
        // while we still have nodes to reverse
        while (tail.next != null) {
            ListNode cur = tail.next;
            tail.next = cur.next;
            cur.next = pre;
            pre = cur;
        }
        return pre;
    }
}