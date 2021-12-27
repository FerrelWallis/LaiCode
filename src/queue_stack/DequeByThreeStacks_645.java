package queue_stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeByThreeStacks_645 {
    // tail     head
    // [1 2 3 5 4]

    //head [4 5]
    //tail [2 1]
    //buffer []

    //1. move half ele from head to buffer
    //2. move left ele in head to tail
    //3. move ele in buffer back to the head
    Deque<Integer> head;
    Deque<Integer> tail;
    Deque<Integer> buffer;

    public DequeByThreeStacks_645() {
        head = new ArrayDeque<>();
        tail = new ArrayDeque<>();
        buffer = new ArrayDeque<>();
    }

    public void moveHalf(Deque<Integer> stackfrom, Deque<Integer> stackto) {
        int size = stackfrom.size();
        for (int i = 0; i < size / 2; i++) {
            buffer.offerLast(stackfrom.pollLast());
        }
        while (!stackfrom.isEmpty()) {
            stackto.offerLast(stackfrom.pollLast());
        }
        while (!buffer.isEmpty()) {
            stackfrom.offerLast(buffer.pollLast());
        }
    }

    public void offerFirst(int element) {
        head.offerLast(element);
    }

    public void offerLast(int element) {
        tail.offerLast(element);
    }

    public Integer pollFirst() {
        if (isEmpty()) {
            return null;
        }
        if (head.isEmpty()) {
            moveHalf(tail, head);
        }
        return head.pollLast();
    }

    public Integer pollLast() {
        if (isEmpty()) {
            return null;
        }
        if (tail.isEmpty()) {
            moveHalf(head, tail);
        }
        return tail.pollLast();
    }

    public Integer peekFirst() {
        if (isEmpty()) {
            return null;
        }
        int peek = pollFirst();
        head.offerLast(peek);
        return peek;
    }

    public Integer peekLast() {
        if (isEmpty()) {
            return null;
        }
        int peek = pollLast();
        tail.offerLast(peek);
        return peek;
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return (head.isEmpty() ? 0 : head.size()) + (tail.isEmpty() ? 0 : tail.size());
    }

    public boolean isEmpty() {
        return head.isEmpty() && tail.isEmpty();
    }


}
