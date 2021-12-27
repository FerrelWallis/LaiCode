package linkedList;

public class ReverseLinkedList_iterative_34 {

    public ListNode reverse(ListNode head) {
        //null <- 1 <- 2 <- 3 -> null => null <- 1 <- 2 <- 3
        //                  pp   p
        // ListNode prepre = null; ListNode pre = head
        // ListNode next = pre.next;
        // pre.next -> prepre
        // prepre = pre
        // pre = next
        //when pre == null stop reverse
        if (head == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
