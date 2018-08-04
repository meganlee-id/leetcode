package com.meganlee;


public class ReorderList {
    //------------------ Solution 1 ---------------------//
    // Brute-force O(N^2) this is the most obvious solution
    public void reorderList(ListNode head) {
        ListNode cur = head;
        // while cur.next.next is valid
        while (cur != null && cur.next != null) {
            // step 1: find the node previous to the tail node
            ListNode beforeTail = cur;
            while (beforeTail.next.next != null) {
                beforeTail = beforeTail.next;
            }
            // step 2: insert the tail node after cur
            ListNode tail = beforeTail.next;
            beforeTail.next = tail.next;
            tail.next = cur.next;
            cur.next = tail;
            // step 3: update cur
            cur = cur.next.next;
        }
    }

    //------------------ Solution 2 ---------------------//
    // O(N)
    public void reorderList2(ListNode head) {
        // input validation: num(nodes) <= 1
        if (head == null || head.next == null) {
            return;
        }
        // step 1: find the middle node
        ListNode tail1 = findMiddle(head);
        ListNode head2 = tail1.next;
        tail1.next = null; // don't forget this!!!
        // step 2: reverse the 2nd half
        head2 = reverse(head2);
        // step 3: merge 1st and 2nd halves
        merge(head, head2);
    }

    private ListNode findMiddle(ListNode head) {
        // assume head != null
        ListNode walker = head, runner = head;
        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }
        return walker;
    }

    private ListNode reverse(ListNode cur) {
        ListNode pre = null;
        while (cur != null) {
            ListNode post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }
        return pre;
    }

    private void merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0), tail = dummy;
        while (head2 != null) { // head2 is shorter
            ListNode a = head1;
            ListNode b = head2;
            head1 = head1.next;
            head2 = head2.next;
            tail.next = a;
            a.next = b;
            tail = b;
        }
        tail.next = head1;
    }
}
