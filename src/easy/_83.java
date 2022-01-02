package easy;

import util.ListNode;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
public class _83 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null)
            if (curr.next != null && curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }

        return head;
    }
}
