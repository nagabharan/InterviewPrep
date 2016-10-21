package practiceOA;

import leetcode.linkedlist.ListNode;

/**
 * Created by nagabharan on 21-Oct-16.
 */
public class Merge2SortedLists {
    public static ListNode mtsl(ListNode l1, ListNode l2) {
        ListNode fh = new ListNode(0);
        ListNode fp = fh;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                fp.next = l1;
                l1 = l1.next;
            } else {
                fp.next = l2;
                l2 = l2.next;
            }
            fp = fp.next;
        }
        fp.next = (l1 == null) ? l2 : l1;
        return fh.next;
    }
}
