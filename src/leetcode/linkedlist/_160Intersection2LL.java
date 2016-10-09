package leetcode.linkedlist;

import java.util.HashSet;

/**
 * Created by nagabharan on 08-Oct-16.
 */
public class _160Intersection2LL {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null)
            return null;

        HashSet<ListNode> set = new HashSet<>();

        while (head1 != null) {
            set.add(head1);
            head1 = head1.next;
        }

        while (head2 != null) {
            if (set.contains(head2))
                return head2;
            head2 = head2.next;
        }

        return null;

    }
}
