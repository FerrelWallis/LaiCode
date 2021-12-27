package queue_stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class SortWith2Stacks_280 {

    //bottom - top
    //stack1 [1 1 2 3 5 9]
    //stack2 []  pre_min = 2 min = 2 counter = 1
    //

    //1. pop all ele out from stack1 which is larger then pre_min push into stack2
    //    1) find min ele => min
    //    2) counter
    //2. push min into the stack1 and
    //   then pop all ele out from stack2 and push back to stack 1 exclude min
    //   pre_min = min

    //stop when top ele in stack1 is <= premin then stop

    //s1 == null || s1.size == 0 return
    public void sort(LinkedList<Integer> s1) {
        if (s1 == null || s1.size() == 0) {
            return;
        }
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        helper(s1, s2);
    }

    public void helper(Deque<Integer> s1, Deque<Integer> s2) {
        int preMin = Integer.MIN_VALUE;
        while (s1.peekLast() > preMin) {
            int min = Integer.MAX_VALUE;
            int counter = 0;
            while (!s1.isEmpty() && s1.peekLast() > preMin) {
                int cur = s1.pollLast();
                if (cur < min) {
                    min = cur;
                    counter = 1;
                } else if (cur == min) {
                    counter++;
                }
                s2.offerLast(cur);
            }
            for (int i = 0; i < counter; i++) {
                s1.offerLast(min);
            }
            while (!s2.isEmpty()) {
                int cur = s2.pollLast();
                if (cur != min) {
                    s1.offerLast(cur);
                }
            }
            preMin = min;
        }
    }


}
