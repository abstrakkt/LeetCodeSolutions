package easy;

import util.ListNode;

//https://leetcode.com/problems/merge-two-sorted-lists/
public class _21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        if (list1 == null && list2 != null) {
            return list2;
        } else if (list2 == null && list1 != null) {
            return list1;
        } else if (list1 == null && list2 == null) {
            return null;
        } else {
            if (list1.val < list2.val) {
                res.val = list1.val;
                list1 = list1.next;
            } else {
                res.val = list2.val;
                list2 = list2.next;
            }
            res.next = mergeTwoLists(list1, list2);
        }
        return res;
    }
}
