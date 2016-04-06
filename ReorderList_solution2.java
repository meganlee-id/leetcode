/**
 * Created by meganlee on 9/13/14.
 */
public class ReorderList_solution2 {
    public void reorderList(ListNode head) {
        // input validation
        if (head == null || head.next == null) {
            return;
        }

        // step 1: find middle node: the tail node of first half
        ListNode mid = findMiddle(head);
        ListNode afterMid = mid.next;
        mid.next = null;     // don't forget this

        // step 2: reverse the second half
        afterMid = reverse(afterMid);

        // step 3: merge first half and second half
        merge(head, afterMid);
    }

    private ListNode findMiddle(ListNode head) {
        // assume head is not null (at least one node in the list)
        ListNode walker = head, runner = head.next;
        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }
        return walker;
    }

    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode afterHead = head.next;
            head.next = newHead;
            newHead = head;
            head = afterHead;
        }
        return newHead;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        // assume 1: size(head1) - size(head2) == 0 || 1
        // assume 2: head1 non-null
        ListNode dummyHead = new ListNode(0), tail = dummyHead;
        while (head1 != null && head2 != null) {
            ListNode afterHead1 = head1.next;
            ListNode afterHead2 = head2.next;
            tail.next = head1;
            head1.next = head2;
            tail = head2;
            head1 = afterHead1;
            head2 = afterHead2;
        }
        if (head1 != null) {
            tail.next = head1; // make sure list ends with a null
        }
        return dummyHead.next;
    }

    ////////////////// TEST ////////////////////////
    public static void main(String[] args) {
        int[] nodes = {1, 2};
        int[] nodes2 = {5, 6, 7};
        ListNode head = new ListNode(nodes);
        ListNode head2 = new ListNode(nodes2);
        ReorderList_solution2 solution = new ReorderList_solution2();
        solution.reorderList(head);
        System.out.println(head);
    }
}

// ERROR 1: Don't need to return for this problem
//          related: pay attention to this type of don't return
// ERROR 2: reverse(afterMid) ===> afterMid = reverse(afterMid);
// ERROR 3: List ==> ListNode
// ERROR 4: private merge(...) -> private ListNode merge(...)