package linkedList;

public class AddTwoNumbers_223 {

    //1 2 3 + 9 9 9 => 0 2 3 1
    //sum = 10
    //c = sum / 10 = 1;
    //d = sum % 10 = 0;
    //sum = 9+2+c = 12
    //c = 1 d = 2
    //sum = 3+9+c = 13
    //c = 1 d = 3
    //c = 1
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode dummyhead = new ListNode(0);
        ListNode cur = dummyhead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = (l1 == null ? 0 : l1.value) + (l2 == null ? 0 : l2.value) + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return dummyhead.next;
    }
}
