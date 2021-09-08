import java.util.LinkedList;

public class StackWithmin_32 {
    LinkedList<Integer> stack;
    LinkedList<Pair> minstack; //记录min以及min第一次出现时stack的size

    public static void main(String[] args) {
        StackWithmin_32 test = new StackWithmin_32();
        test.push(5);
        int a = test.top();
        int b = test.min();
    }

    public StackWithmin_32() {
        stack = new LinkedList();
        minstack = new LinkedList();
    }

    public int pop() {
        int cur = stack.pollFirst();
        Pair curMin = minstack.peekFirst();
        if (curMin.min == cur && curMin.size == stack.size()) {
            minstack.pollFirst();
        }
        return -1;
    }

    public void push(int element) {
        Pair curMin = minstack.peekFirst();
        if (curMin == null || curMin.min > element) {
            minstack.offerFirst(new Pair(element, stack.size()));
        }
        stack.offerFirst(element);
    }

    public int top() {
        return stack.isEmpty()? -1 : stack.peekFirst();
    }

    public int min() {
        Pair curMin = minstack.peekFirst();
        return curMin == null ? -1 : curMin.min;
    }

    class Pair {
        int min;
        int size;

        public Pair(int m, int s) {
            min = m;
            size = s;
        }
    }
}



