package easy;

import util.ListNode;
import util.Usage;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//https://leetcode.com/problems/palindrome-linked-list/
public class _234 {
    public static void main(String[] args) {
        ListNode head = Usage.createLinkedList();
        System.out.println(isPalindromeOpt(head));
    }

    public static boolean isPalindrome(ListNode head) {
        String items = traverseList(head);
        int start = 0, end = items.length() - 1;
        while (start < end) {
            if (items.charAt(start) != items.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private static String traverseList(ListNode head) {
        String result = "";
        while (head != null) {
            result = result + head.val;
            head = head.next;
        }
        return result;
    }

    static boolean isPalindromeOpt(ListNode head) {
        Deque<ListNode> queue = new LinkedList<>();
        while (head != null) {
            queue.add(head);
            head = head.next;
        }

        while (queue.size() > 1){
            if (queue.peekFirst().val != queue.peekLast().val){
                return false;
            }
            queue.removeFirst();
            queue.removeLast();
        }
        return true;
    }

    public boolean isPalindromeOpt2(ListNode head) {
        if (head.next == null) {
            return true;
        } else if (head.next.next == null) {
            return head.val == head.next.val;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }
        ListNode nodeLeft = head;
        ListNode nodeRight = getHeadOfReversedList(slow);
        while (nodeLeft != null && nodeRight != null) {
            if (nodeLeft.val != nodeRight.val) {
                return false;
            }
            nodeLeft = nodeLeft.next;
            nodeRight = nodeRight.next;
        }
        return true;
    }

    private ListNode getHeadOfReversedList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
