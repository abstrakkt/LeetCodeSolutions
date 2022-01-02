package easy;

import util.ListNode;

//https://leetcode.com/problems/linked-list-cycle/
public class _141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode walker = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            walker = walker.next;
            fast = fast.next.next;
            if (walker == fast) return true;
        }
        return false;
    }
}
