package practiceOA;

import leetcode.linkedlist.ListNode;

/**
 * Created by nagabharan on 21-Oct-16.
 */
public class InsertCycleLL {
    public ListNode insertCLL(ListNode head, int val) {
        if (head == null) {
            ListNode t = new ListNode(val);
            t.next = t;
            return t;
        }

        ListNode fp = head;

        do {
            if (val <= fp.next.val && val >= fp.val)
                break;
            if (fp.val > fp.next.val && (val < fp.next.val || val > fp.val))
                break;
            fp = fp.next;
        } while (fp != head);

        ListNode t = new ListNode(val);
        t.next = fp.next;
        fp.next = t;
        return t;
    }
}
