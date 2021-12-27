package linkedList;

public class InsertInSortedLinkedList_39 {

    public ListNode insert(ListNode head, int value) {
        ListNode node = new ListNode(value);
        //1. insert head
        //2. insert middle
        //3. insert tail
        if (head == null || head.value >= value) {
            node.next = head;
            return node;
        }
        ListNode pre = head;
        while (pre != null) {
            if (pre.value < value && (pre.next == null || pre.next.value >= value)) {
                node.next = pre.next;
                pre.next = node;
                break;
            }
            pre = pre.next;
        }
        return head;
    }
}
