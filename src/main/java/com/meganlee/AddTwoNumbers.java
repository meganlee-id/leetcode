package com.meganlee;


public class AddTwoNumbers {
    //--------------- Solution 1  ----------------//
    // recursion: T=O(N), S=O(N) sumList/recursion call
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return helper(l1, l2, 0);
    }

    private ListNode helper(ListNode l1, ListNode l2, int carry) {
        // base case
        if((l1 == null) && (l2 == null) && (carry == 0)) {
            return null;
        }

        // general case
        int digitA = (l1 == null) ? 0 : l1.val;
        int digitB = (l2 == null) ? 0 : l2.val;
        int sum = digitA + digitB + carry;
        carry = sum / 10;
        ListNode res = new ListNode(sum % 10);

        l1 = (l1 == null) ? null : l1.next;
        l2 = (l2 == null) ? null : l2.next;
        res.next = helper(l1, l2, carry);
        return res;
    }

    //--------------- Solution 2  ----------------//
    // iterative: T=O(N), S=O(N) sumList
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int carry = 0;                                  // carry
        ListNode dummyHead = new ListNode(0);           // result, taks advantage of dummyHead
        ListNode p1 = l1, p2 = l2, pSum = dummyHead;    // 3 pointers
        while((p1 != null) || (p2 != null) || (carry != 0)) {
            // compute current digit
            int digitA = (l1 == null) ? 0 : l1.val;
            int digitB = (l2 == null) ? 0 : l2.val;
            int sum = digitA + digitB + carry;
            carry = sum / 10;
            pSum.next = new ListNode(sum % 10);

            // update states for next iteration
            p1 = (p1 == null) ? null : p1.next;
            p2 = (p2 == null) ? null : p2.next;
            pSum = pSum.next;
        }
        return dummyHead.next;
    }
}


