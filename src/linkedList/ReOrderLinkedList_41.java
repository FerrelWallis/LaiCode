package linkedList;

public class ReOrderLinkedList_41 {

    //1 2 3 4 => 1 4 2 3    1 2 3 => 1 3 2
    //1. find the middle
    //2. reserve the latter part
    //3.merge 2 part into 1
    public ListNode reorder(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode one = head;
        ListNode two = slow.next;
        slow.next = null;
        two = reverse(two);
        return merge(one, two);
    }

    public ListNode merge(ListNode one, ListNode two) {
        ListNode head = one;
        while (two != null) {
            ListNode next = one.next;
            one.next = two;
            two = two.next;
            one.next.next = next;
            one = next;
        }
        return head;
    }

    public ListNode reverse(ListNode head) {
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
