package com.meganlee;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;  // insert node into the sorted list (dummyHead list)
        while (cur != null) {
            ListNode pre = dummyHead;
            // step 1: find the predecessor
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            // step 2: Record for updating cur
            ListNode next = cur.next;
            // step 3: insert
            cur.next = pre.next;
            pre.next = cur;
            // step 4: update cur
            cur = next;
        }
        return dummyHead.next;
    }
}