public class ReverseLinkedListInPairs_35 {
    //Reverse pairs of elements in a singly-linked list.
    //
    //Examples
    //
    //L = null, after reverse is null
    //L = 1 -> null, after reverse is 1 -> null
    //L = 1 -> 2 -> null, after reverse is 2 -> 1 -> null
    //L = 1 -> 2 -> 3 -> null, after reverse is 2 -> 1 -> 3 -> null

    //n1 -> n2 -> n3 ->...-> nn -> null
    //将n3->....->nn->null 作为subproblem，assume the subproblem is solved and then we only need to do 2 step to slove the whole
    //1) head = n1 next = n2, head.next -> newhead of subproblem
    //2) next.next = head;
    //time O(n) n space O(n / 2) = O(n)
    public ListNode reverseInPairs(ListNode head) {
        if (head == null || head.next == null) { //base case
            return head;
        }
        ListNode next = head.next;
        ListNode newhead = reverseInPairs(next.next);
        head.next = newhead;
        next.next = head;
        return next;
    }

    //iterate way: dummyhead
    public ListNode reverseInPairs2(ListNode head) {
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode cur = dummyhead;
        while (cur.next != null && cur.next.next != null) {
            ListNode next = cur.next.next;
            cur.next.next = next.next;
            next.next = cur.next;
            cur.next = next;
            cur = cur.next.next;
        }
        return dummyhead.next;
    }


    class ListNode {
        public int value;
        public ListNode next;
        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }
}
