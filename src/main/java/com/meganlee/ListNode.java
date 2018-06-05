package com.meganlee;

public class ListNode {
    public int val; 
    public ListNode next;
    public ListNode(int x) {
        val = x;
    }

    // Easy to make a single-linked-list
    static public ListNode fromArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode dummyHead = new ListNode(0); // use dummy
        ListNode tail = dummyHead;
        for (int i = 0; i < arr.length; i++) {
            tail.next = new ListNode(arr[i]); // append new node to tail
            tail = tail.next; // update tail
        }
        return dummyHead.next;
    }
    
    // For bettering printing: "13->3->8->null"
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode iter = this;
        while (iter != null) {
            sb.append(iter.val + "->");
            iter = iter.next;
        }
        return sb.append("null").toString();
    }
}