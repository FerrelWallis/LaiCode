package cross_training3;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists_134 {
    //Merge K sorted lists into one big sorted list in ascending order.
    //Assumptions: ListOfLists is not null, and none of the lists is null.

    public ListNode merge(List<ListNode> listOfLists) {
        int k = listOfLists.size();
        ListNode dummyhead = new ListNode(0);
        ListNode p = dummyhead;
        PriorityQueue<ListNode> minheap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.value == o2.value) {
                    return 0;
                }
                return o1.value < o2.value ? -1 : 1;
            }
        });
        for (int i = 0; i < k; i++) {
            minheap.add(listOfLists.get(i));
        }
        while (!minheap.isEmpty()) {
            ListNode cur = minheap.poll();
            p.next = cur;
            p = p.next;
            if (cur.next != null) {
                minheap.add(cur.next);
                cur.next = null;
            }
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
