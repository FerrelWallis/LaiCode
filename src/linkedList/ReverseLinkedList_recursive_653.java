package linkedList;

public class ReverseLinkedList_recursive_653 {

    // 1 <- ( 2 -> 3 -> null) => null <- 1 <- 2 <- 3
    // head.next.next -> head && head.next -> null
    public ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        }
        ListNode newhead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newhead;
    }
}
