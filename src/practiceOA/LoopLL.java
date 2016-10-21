package practiceOA;

import leetcode.linkedlist.ListNode;

/**
 * Created by nagabharan on 21-Oct-16.
 */
public class LoopLL {
    public ListNode detectCyclt(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode sl = head, f = head, res = head;

        while (f.next != null && f.next.next != null) {
            sl = sl.next;
            f = f.next.next;
            if (sl == f) {
                while (res != sl) {
                    res = res.next;
                    sl = sl.next;
                }
                return res;
            }
        }
        return null;
    }
}
