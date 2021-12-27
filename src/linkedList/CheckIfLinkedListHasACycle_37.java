package linkedList;

public class CheckIfLinkedListHasACycle_37 {

    // 1 2 3 4         1 2 3
    //     s             s
    //         f           f
    //f == null  f.next == null
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
