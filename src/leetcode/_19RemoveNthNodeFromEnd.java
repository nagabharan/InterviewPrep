package leetcode;

/**
 * Created by nagabharan on 19-Sep-16.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class _19RemoveNthNodeFromEnd {


    public static ListNode solution(ListNode head, int n) {

        if (head == null)
            return null;

        ListNode slowptr = head, fastptr = head;

        for (int i = 0; i < n; i++)
            fastptr = fastptr.next;

        if (fastptr == null) {
            head = head.next;
            return head;
        }

        while (fastptr.next != null) {
            fastptr = fastptr.next;
            slowptr = slowptr.next;
        }

        slowptr.next = slowptr.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        solution(head, 2);
    }
}
