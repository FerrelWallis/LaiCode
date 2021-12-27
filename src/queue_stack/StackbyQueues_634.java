package queue_stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackbyQueues_634 {

    //[ 1 2 3 ] size = 3
    //[ 1 2 ]
    //poll out ele and offer it back to the queue for size - 1
    //then poll out the top ele
    Deque<Integer> queue;

    public StackbyQueues_634() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.offerLast(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public Integer pop() {
        if (isEmpty()) {
            return null;
        }
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.offerLast(queue.pollFirst());
        }
        return queue.pollFirst();
    }

    /** Get the top element. */
    public Integer top() {
        if (isEmpty()) {
            return null;
        }
        int topele = pop();
        queue.offerLast(topele);
        return topele;
    }

    /** Returns whether the stack is empty. */
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
