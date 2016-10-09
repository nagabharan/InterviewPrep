package leetcode.linkedlist;

/**
 * Created by nagabharan on 07-Oct-16.
 */
public class _21Merge2SortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(0);
        ListNode p = fakeHead;

        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    p.next = l1;
                    l1 = l1.next;
                } else {
                    p.next = l2;
                    l2 = l2.next;
                }
                p = p.next;
            } else if (l1 == null) {
                p.next = l2;
                break;
            } else if (l2 == null) {
                p.next = l1;
                break;
            }
        }
        return fakeHead.next;
    }
}