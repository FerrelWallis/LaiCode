package cross_training4;

import java.util.HashMap;
import java.util.HashSet;

public class FirstNonRepeatingCharacterInStream_288 {
    //public Solution() {
    //    // Initialize the class.
    //  }
    //
    //  public void read(char ch) {
    //    // Implement this method here.
    //  }
    //
    //  public Character firstNonRepeating() {
    //    // Implement this method here.
    //    return null;
    //  }

    public class Solution {
        //LRU思路一样
        //Doubly link list(node<character>) + hashmap(character,node) + HashSet<Character> dup
        class Node {
            Node pre;
            Node next;
            char c;
            public Node(char c) {
                this.c = c;
            }
        }

        private Node head;
        private Node tail;
        private HashMap<Character, Node> single;
        private HashSet<Character> dup;

        public Solution() {
            single = new HashMap<>();
            dup = new HashSet<>();
        }

        public void read(char ch) {
            if (!dup.contains(ch)) { //已经是dup的元素啥也不用做
                if (single.containsKey(ch)) { //之前不dup，因为新加元素开始dup了
                    dup.add(ch);
                    Node node = single.get(ch);
                    single.remove(ch);
                    delete(node);
                } else { //之前没出现过
                    Node node = new Node(ch);
                    single.put(ch, node);
                    append(node);
                }
            }
        }

        private void append(Node node) {
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                node.pre = tail;
                tail = node;
            }
        }

        private void delete(Node node) {
            if (node.pre != null) {
                node.pre.next = node.next;
            }
            if (node.next != null) {
                node.next.pre = node.pre;
            }
            if (head == node) {
                head = node.next;
            }
            if (tail == node) {
                tail = node.pre;
            }
        }

        public Character firstNonRepeating() {
            if (head == null) {
                return null;
            }
            return head.c;
        }
    }
}
