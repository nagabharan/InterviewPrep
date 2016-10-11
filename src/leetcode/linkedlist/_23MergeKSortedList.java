package leetcode.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by nagabharan on 11-Oct-16.
 */
public class _23MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode fh = new ListNode(0);
        ListNode p = fh;

        for (ListNode list : lists) {
            if (list != null)
                q.add(list);
        }

        while (!q.isEmpty()) {
            ListNode n = q.remove();
            p.next = n;
            p = p.next;

            if (n.next != null)
                q.add(n.next);
        }

        return fh.next;
    }
}
