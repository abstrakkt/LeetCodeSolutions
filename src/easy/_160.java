package easy;

import util.ListNode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/intersection-of-two-linked-lists/
public class _160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode, Integer> visited = new HashMap<>();
        while (headA != null) {
            if (!visited.containsKey(headA)) {
                visited.put(headA, 1);
            } else {
                return headA;
            }
            headA = headA.next;
        }
        while (headB != null) {
            if (!visited.containsKey(headB)) {
                visited.put(headB, 1);
            } else {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNodeOpt(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode currA = headA, currB = headB;
        while (currA != null) {
            lenA++;
            currA = currA.next;
        }
        while (currB != null) {
            lenB++;
            currB = currB.next;
        }
        currA = headA;
        currB = headB;
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++)
                currA = currA.next;
        } else {
            for (int i = 0; i < lenB - lenA; i++)
                currB = currB.next;
        }
        while (currA != currB) {
            currA = currA.next;
            currB = currB.next;
        }
        return currA;
    }
}
