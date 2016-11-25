package leetMS;

import leetcode.linkedlist.ListNode;

/**
 * Created by nagabharan on 0025, November 25, 2016.
 */
public class _24SwapNodePair {
    public ListNode sol(ListNode h) {
        if (h == null || h.next == null)
            return h;
        ListNode nh = new ListNode(0);
        nh.next = h;
        ListNode np = nh;

        while (np.next != null && np.next.next != null) {
            ListNode t1 = np;
            np = np.next;
            t1.next = np.next;

            ListNode t2 = np.next.next;
            np.next.next = np;
            np.next = t2;
        }
        return nh.next;
    }
}
