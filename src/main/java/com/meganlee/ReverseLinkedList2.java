package com.meganlee;

public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // ASSUMPTION
        //   1) head is non-null 
        //   2) 1 <= m <= n <= len of list

        // step 1: move the pre to (m-1)th node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        // step 2: reverse the sub list
        ListNode tail = pre.next;
        for (int i = 0; i < n - m; i++) {
            ListNode cur = tail.next;
            tail.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
        }
        return dummy.next;
    }
}
