package easy;

import util.ListNode;
import util.Usage;

import java.util.List;

//https://leetcode.com/problems/reverse-linked-list/
public class _206 {
    public static void main(String[] args) {
        ListNode head = Usage.createLinkedList();

        Usage.printLinkedList(head);
        ListNode res = reverseList(head);
        Usage.printLinkedList(res);
    }

    static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            if (temp != null) {
                head = temp;
            } else {
                break;
            }
        }

        return head;
    }
}
