/**
 * Created by meganlee on 9/13/14.
 */

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode walker = head, runner = head.next;
        while (runner != null && runner.next != null) {
            if (runner == walker) {
                return true;
            }
            walker = walker.next;
            runner = runner.next.next;
        }
        return false;
    }
}

// NOTE: this is a very basic template for using slow and fast walker!!
