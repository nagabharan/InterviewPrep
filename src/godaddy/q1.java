package godaddy;

/**
 * Created by nagabharan on 17-Sep-16.
 */
public class q1 {
    static LinkedListNode removeNodes(LinkedListNode list, int x) {
        while (list != null && list.val > x)
            list = list.next;
        if (list == null || list.next == null)
            return list;
        LinkedListNode prev = list;
        LinkedListNode prevptr = prev;
        LinkedListNode head = list.next;
        while (head != null) {
            if (head.val > x) {
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }
        return prevptr;
    }

    public static void main(String[] args) {
        LinkedListNode l = new LinkedListNode(1);
        l.next = new LinkedListNode(2);
        l.next.next = new LinkedListNode(3);
        l.next.next.next = new LinkedListNode(4);
        l.next.next.next.next = new LinkedListNode(5);
        l = removeNodes(l, 3);
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }

    static class LinkedListNode {
        int val;
        LinkedListNode next;

        LinkedListNode(int val) {
            this.val = val;
        }
    }
}
