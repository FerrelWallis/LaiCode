public class MergeTwoSortedLinkedLists_40 {

    public static void main(String[] args) {
        ListNode one = null;
        ListNode two = new ListNode(1);
        two.next = new ListNode(2);
        two.next.next = new ListNode(3);
        MergeTwoSortedLinkedLists_40 test = new MergeTwoSortedLinkedLists_40();
        test.merge(one, two);
    }

    public ListNode merge(ListNode one, ListNode two) {
        ListNode dummyhead = new ListNode(0);
        ListNode tail = dummyhead;
        //有一个没有遍历完就要继续
        while(one != null && two != null) {
            if (one != null) {
                tail.next = one;
                one = one.next;
            } else { //one == null || one.value > two.value
                tail.next = two;
                two = two.next;
            }
            tail = tail.next;
        }
        if (one != null) {
            tail.next = one;
        } else {
            tail.next = two;
        }
        //考虑tail后面是否要加null，这里因为是merge两个sorted list，所以当前tail.next肯定是null不会造成环
        return dummyhead.next;
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
