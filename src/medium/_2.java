package medium;

import util.ListNode;

//https://leetcode.com/problems/add-two-numbers/
public class _2 {

    private static final ListNode ZERO_NODE = new ListNode(0);

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return recursiveSum(l1, l2, 0);
    }

    private ListNode recursiveSum(ListNode a, ListNode b, int carry) {
        int sum = (a.val + b.val) + carry;
        int newCarry = sum / 10;

        ListNode r = new ListNode(sum % 10);
        if (a.next == null && b.next == null) {
            if (newCarry > 0) {
                r.next = new ListNode(newCarry);
            }
        } else {
            r.next = recursiveSum(
                    (a.next == null) ? ZERO_NODE : a.next,
                    (b.next == null) ? ZERO_NODE : b.next, newCarry);
        }

        return r;
    }

    public ListNode addTwoNumbersOpt(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode emptyNode = new ListNode(0);
        ListNode currentNode = new ListNode(0);
        ListNode result = currentNode;
        while (emptyNode != l1 || emptyNode != l2) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            currentNode = (currentNode.next = new ListNode(sum %= 10));
            l1 = null != l1.next ? l1.next : emptyNode;
            l2 = null != l2.next ? l2.next : emptyNode;
        }
        if (carry == 1)
            currentNode.next = new ListNode(carry);
        return result.next;

    }
}
