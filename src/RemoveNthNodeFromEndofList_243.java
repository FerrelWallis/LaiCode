public class RemoveNthNodeFromEndofList_243 {
    public static void main(String[] args) {
        RemoveNthNodeFromEndofList_243 test = new RemoveNthNodeFromEndofList_243();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        test.removeNthFromEnd(head, 2);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode fast = dummyhead;
        ListNode slow = dummyhead;
        for (int i = 0; fast != null && i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyhead.next;
    }

    static class ListNode {
        int value;
        ListNode next;
        public ListNode(int val) {
            value = val;
            next = null;
        }
    }
}
