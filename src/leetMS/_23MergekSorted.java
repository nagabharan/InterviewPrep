package leetMS;

import leetcode.linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by nagabharan on 0025, November 25, 2016.
 */
public class _23MergekSorted {
    public ListNode sol(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        ListNode nh = new ListNode(0);
        ListNode np = nh;

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });

        for (ListNode l : lists)
            if (l != null)
                pq.offer(l);

        while (!pq.isEmpty()) {
            ListNode n = pq.poll();
            np.next = n;
            np = np.next;

            if (n.next != null)
                pq.offer(n.next);
        }
        return nh.next;
    }
}
