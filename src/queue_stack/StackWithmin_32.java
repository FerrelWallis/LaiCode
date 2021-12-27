package queue_stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class StackWithmin_32 {

    Deque<Integer> stack;
    Deque<Integer> min; //in desending
    // 3 2 5 2 1 2 9
    // 3 2 2 2 1 1 1

    public StackWithmin_32() {
        stack = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }

    //push
    public void push(int val) {
        stack.offerLast(val);
        if (min.isEmpty() || min.peekLast() >= val) {
            min.offerLast(val);
        }
    }

    //pop
    public Integer pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        int peek = stack.peekLast();
        if (min.peekLast().equals(peek)) {
            min.pollLast();
        }
        return peek;
    }

    //top
    public Integer top() {
        return stack.isEmpty() ? -1 : stack.peekLast();
    }

    //min
    public Integer min() {
        return min.isEmpty() ? -1 : min.peekLast();
    }



}
