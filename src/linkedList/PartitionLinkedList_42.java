package linkedList;

public class PartitionLinkedList_42 {


    public ListNode partition(ListNode head, int target) {
        ListNode small = new ListNode(0);
        ListNode curs = small;
        ListNode large = new ListNode(0);
        ListNode curl = large;
        while (head != null) {
            if (head.value < target) {
                curs.next = head;
                head = head.next;
                curs = curs.next;
                curs.next = null;
            } else {
                curl.next = head;
                head = head.next;
                curl = curl.next;
                curl.next = null;
            }
        }
        curs.next = large.next;
        return small.next;
    }
}
