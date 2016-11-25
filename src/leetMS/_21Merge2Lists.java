package leetMS;

import leetcode.linkedlist.ListNode;

/**
 * Created by nagabharan on 0025, November 25, 2016.
 */
public class _21Merge2Lists {
    public ListNode sol(ListNode l1, ListNode l2) {
        ListNode nh = new ListNode(0);
        ListNode np = nh;

        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    np.next = l1;
                    l1 = l1.next;
                } else {
                    np.next = l2;
                    l2 = l2.next;
                }
                np = np.next;
            }
            if (l1 == null) {
                np.next = l2;
                break;
            }
            if (l2 == null) {
                np.next = l1;
                break;
            }
        }
        return nh.next;
    }
}
