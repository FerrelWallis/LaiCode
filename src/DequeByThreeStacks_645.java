import java.util.ArrayDeque;
import java.util.Deque;

public class DequeByThreeStacks_645 {
    Deque<Integer> headStack;
    Deque<Integer> tailStack;
    Deque<Integer> bufferStack;

    //[peekFirst(), offerLast()#74, peekFirst(), offerFirst()#95, offerLast()#20, offerFirst()#143, pollLast(), pollFirst(),
    // offerFirst()#9]
    // expected:
    // <[null, offerLast(74), 74, offerFirst(95), offerLast(20), offerFirst(143), 20, 143, offerFirst(9)]>
    // but was:
    // <[null, offerLast(74), null, offerFirst(95), offerLast(20), offerFirst(143), 20, 143, offerFirst(9)]>

    public static void main(String[] args) {
        DequeByThreeStacks_645 test = new DequeByThreeStacks_645();
        test.offerFirst(1);
        test.offerFirst(2);
        test.offerFirst(3);

    }

    public DequeByThreeStacks_645() { //1,2,3,4,5,6
        headStack = new ArrayDeque<Integer>(); //3,2,1
        tailStack = new ArrayDeque<Integer>(); //4,5,6
        bufferStack = new ArrayDeque<Integer>();
    }

    public void offerFirst(int element) {
        headStack.offerFirst(element);
    }

    public void offerLast(int element) {
        tailStack.offerFirst(element);
    }

    public Integer pollFirst() {
        if (headStack.isEmpty()) {
            moveFromAnother(headStack, tailStack);
        }
        return headStack.pollFirst();
    }

    public Integer pollLast() {
        if (tailStack.isEmpty()) {
            moveFromAnother(tailStack, headStack);
        }
        return tailStack.pollFirst();
    }

    public void moveFromAnother(Deque<Integer> to, Deque<Integer> from) {
        if (from.isEmpty()) {
            return;
        }
        int size = from.size() / 2;
        while (size-- != 0) {
            bufferStack.offerFirst(from.pollFirst());
        }
        while (!from.isEmpty()) {
            to.offerFirst(from.pollFirst());
        }
        while (!bufferStack.isEmpty()) {
            from.offerFirst(bufferStack.pollFirst());
        }
    }

    public Integer peekFirst() {
        if (headStack.isEmpty()) {
            moveFromAnother(headStack, tailStack);
        }
        return headStack.peekFirst();
    }

    public Integer peekLast() {
        if (tailStack.isEmpty()) {
            moveFromAnother(tailStack, headStack);
        }
        return tailStack.peekFirst();
    }

    public int size() {
        return headStack.size() + tailStack.size();
    }

    public boolean isEmpty() {
        return headStack.isEmpty() && tailStack.isEmpty();
    }
}
