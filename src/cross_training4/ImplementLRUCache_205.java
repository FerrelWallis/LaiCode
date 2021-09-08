package cross_training4;

import java.util.HashMap;

public class ImplementLRUCache_205 {

    //Implement a least recently used cache.
    //It should provide set(), get() operations.
    //If not exists, return null (Java).

    //doubly linked list + hashmap
    public class Solution<K, V> {

        private Node<K, V> head;
        private Node<K, V> tail;
        private int limit;
        private HashMap<K, Node<K, V>> map;

        // limit is the max capacity of the cache
        public Solution(int limit) {
            this.limit = limit;
            this.map = new HashMap<K, Node<K, V>>();
        }

        public void set(K key, V value) {
            Node<K, V> node = null;
            if (map.containsKey(key)) {
                node = map.get(key);
                node.value = value;
                remove(node);
            } else if (map.size() < limit) { //如果空间足够
                node = new Node<>(key, value);
            } else { //如果key不存在，且空间不够
                node = tail;
                remove(tail);
                node.update(key, value);
            }
            append(node);
        }

        private void append(Node<K,V> node) {
            map.put(node.key, node);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                node.next = head;
                head.pre = node;
                head = node;
            }
        }

        private void remove(Node<K,V> node) {
            map.remove(node.key);
            if (node.pre != null) {
                node.pre.next = node.next;
            }
            if (node.next != null) {
                node.next.pre = node.pre;
            }
            if (node == head) {
                head = node.next;
            }
            if (node == tail) {
                tail = node.pre;
            }
            node.pre = null;
            node.next = null;
        }

        public V get(K key) {
            Node<K, V> node = map.get(key);
            if (node == null) {
                return null;
            }
            remove(node);
            append(node);
            return node.value;
        }

        class Node<K, V> {
            Node<K, V> next;
            Node<K, V> pre;
            K key;
            V value;
            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }


            public void update(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }
    }
}
