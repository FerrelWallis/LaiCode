package linkedList;

public class CheckIfLinkedListIsPalindrome_306 {

    // 1 2 2 1  ||  1 2 1
    //1. find middle
    //2. break into 2 list
    //3. reverse the second list
    //4. compare
    public boolean isPalindrome(ListNode head) {
        if(head == null) {
            return true;
        }
        ListNode mid = findMiddle(head);
        ListNode one = head;
        ListNode two = mid.next;
        mid.next = null;
        two = reverse(two);
        return compare(one, two);
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public boolean compare(ListNode one, ListNode two) {
        while (two != null) {
            if (one.value != two.value) {
                return false;
            }
            two = two.next;
            one = one.next;
        }
        return true;
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

}
