package linkedList;

public class LinkedListInsertAtIndex_366 {

    //index < 0 || index > size
    //1. index == 0 insert at head
    //2. index == size insert at tail
    //3. index within the range, insert middle

    //du 1 2 3  index = 4
    //         p
    public ListNode insert(ListNode head, int index, int value) {
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode pre = dummyhead;
        for (int i = 0; i < index; i++) {
            if (pre == null) {
                return head;
            }
            pre = pre.next;
        }
        if (pre == null) {
            return head;
        }
        ListNode node = new ListNode(value);
        node.next = pre.next;
        pre.next = node;
        return dummyhead.next;
    }
}
