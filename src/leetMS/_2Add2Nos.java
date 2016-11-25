package leetMS;

import leetcode.linkedlist.ListNode;

/**
 * Created by nagabharan on 0025, November 25, 2016.
 */
public class _2Add2Nos {
    public ListNode sol(ListNode l1, ListNode l2) {
        int c = 0;

        ListNode nh = new ListNode(0);
        ListNode p1 = l1, p2 = l2, np = nh;

        while (p1 != null || p2 != null) {
            if (p1 != null) {
                c += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                c += p2.val;
                p2 = p2.next;
            }
            np.next = new ListNode(c % 10);
            np = np.next;
            c /= 10;
        }
        if (c == 1)
            np.next = new ListNode(1);

        return nh.next;
    }
}
