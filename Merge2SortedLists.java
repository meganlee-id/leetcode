

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


public class Merge2SortedLists {
	//------ Define the Node class needed for the problem ------//
	class ListNode {
		int val;
		ListNode next;
		public ListNode(int v) {
			val = v;
		}
	}
	
	//-------- 1st Solution: Iterative ---------//

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(0);
        ListNode tail = fakeHead;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        
        if (l1 == null) tail.next = l2;
        else tail.next = l1;
        
        return fakeHead.next; 
    }
    
    
	//-------- 2nd Solution: Recursive ---------//
    
    // a more concise and nice looking version
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // The base case: either of 2 lists is null
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        // The general case: neither is null
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
}