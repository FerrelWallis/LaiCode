package linkedList;

public class MergeSortLinkedList_29 {
    //1. partition
    //2. merge
    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMiddle(head);
        ListNode one = head;
        ListNode two = mid.next;
        mid.next = null;
        one = mergeSort(one);
        two = mergeSort(two);
        return merge(one, two);
    }

    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode merge(ListNode one, ListNode two) {
        ListNode dummyhead = new ListNode(0);
        ListNode cur = dummyhead;
        while (one != null && two != null) {
            if (one.value < two.value) {
                cur.next = one;
                one = one.next;
                cur = cur.next;
            } else {
                cur.next = two;
                two = two.next;
                cur = cur.next;
            }
        }
        cur.next = one == null ? two : one;
        return dummyhead.next;
    }


}
