package linkedList;

public class RemoveNthNodeFromEndofList_243 {
    //1 2 3 4    n = 2
    //s
    //      f

    //1. nth node is the head of list
    //2. nth node is the tail of list
    //3. middle node

    //du 1 2 3 4  n = 4
    //     s
    //           f
    //1. move fast n + 1 step further  for
    //2. move fast slow at the same until fast == null
    //3. delete nth node => slow.next = slow.next.next

    //1. nth node is head
    //2. nth node  is tail
    //3. n < 0
    //4. n > size of list
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n < 0) {
            return head;
        }
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode slow = dummyhead;
        ListNode fast = dummyhead;
        for (int i = 0; i < n + 1; i++) {
            if (fast == null) {
                return head;
            }
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummyhead.next;
    }

}
