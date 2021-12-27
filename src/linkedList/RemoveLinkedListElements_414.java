package linkedList;

public class RemoveLinkedListElements_414 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode pre = dummyhead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.value == val) {
                pre.next = pre.next.next;
                cur.next = null;
                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next;
            }

        }
        return dummyhead.next;
    }


}
