package medium;

import util.ListNode;
import util.Usage;

import java.util.Stack;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class _19 {

    public static void main(String[] args) {
        ListNode head = Usage.createLinkedList();
        ListNode curr = removeNthFromEndOpt(head, 2);

        Usage.printLinkedList(curr);
    }

    static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        Stack<ListNode> stack = new Stack<>();
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        for (int i = 1; i <= n; i++) {
            stack.pop();
        }

        if (!stack.isEmpty()) {
            ListNode temp = stack.peek();
            temp.next = temp.next.next;
        } else if (stack.isEmpty() && head.next != null) {
            head = head.next;
        } else {
            head = null;
        }

        return head;
    }

    static ListNode removeNthFromEndOpt(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }

        if (fast == null)
            return slow.next;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}
