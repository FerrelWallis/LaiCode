package linkedList;

public class MiddleNodeOfLinkedList_36 {

    //fast = head slow = head
    // 1 2 3 4                      1 2 3
    //   s                            s
    //     f                            f
    //f.next.next == null           f.next == null
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
