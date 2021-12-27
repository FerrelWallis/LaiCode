package linkedList;

public class MergeTwoSortedLinkedLists_40 {
    public ListNode merge(ListNode one, ListNode two) {
        ListNode dummyhead = new ListNode(0);
        ListNode cur = dummyhead;
        while (one != null && two != null) {
            if (one.value < two.value) {
                cur.next = one;
                one = one.next;
            } else {
                cur.next = two;
                two = two.next;
            }
            cur = cur.next;
        }
        if (one == null) {
            cur.next = two;
        } else {
            cur.next = one;
        }
        return dummyhead.next;
    }
}
