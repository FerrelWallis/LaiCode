public class AddTwoNumbers_223 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(8);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(1);
        AddTwoNumbers_223 test = new AddTwoNumbers_223();
        ListNode ans = test.addTwoNumbers(l1, l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //corner case
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode r1 = reverse(l1);
        ListNode r2 = reverse(l2);
        ListNode newhead = add(r1, r2);
        return reverse(newhead);
    }

    public ListNode add(ListNode head1, ListNode head2) {
        int carry = 0;
        ListNode dummyhead = new ListNode(0);
        ListNode cur = dummyhead;
        while(head1 != null || head2 != null) { //将两个list都遍历到尾的时候停止
            int value1 = (head1 == null)? 0 : head1.value;
            int value2 = (head2 == null)? 0 : head2.value;
            int sum = value1 + value2 + carry;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            head1 = (head1 == null)? null : head1.next;
            head2 = (head2 == null)? null : head2.next;
            carry = sum / 10;
        }
        //check会不会因为仅为比原来多一位
        if(carry > 0) {
            cur.next = new ListNode(carry);
        }
        return dummyhead.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode nxt = null;
        ListNode cur = head;
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }


    static class ListNode {
        public int value;
        public ListNode next;
        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }
}
