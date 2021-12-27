package queue_stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueByTwoStacks_31 {

    Deque<Integer> out = new ArrayDeque<>();
    Deque<Integer> in = new ArrayDeque<>();

    //size
    public int size() {
        return (out.isEmpty() ? 0 : out.size()) + (in.isEmpty() ? 0 : in.size());
    }

    //isEmpty
    public boolean isEmpty() {
        return (out.isEmpty() && in.isEmpty());
    }

    //offer
    public void offer(int val) {
        in.offerLast(val);
    }

    //poll
    public Integer poll() {
        if (isEmpty()) {
            return null;
        }
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.offerLast(in.pollLast());
            }
        }
        return out.pollLast();
    }

    //peek()
    public Integer peek() {
        if (isEmpty()) {
            return null;
        }
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.offerLast(in.pollLast());
            }
        }
        return out.peekLast();
    }
}
