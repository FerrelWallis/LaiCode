public class DesignLinkedList_612 {



    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1,2);
        myLinkedList.get(1);
    }

    static class MyLinkedList {
        ListNode head;
        ListNode tail;
        int size;
        /** Initialize your data structure here. */
        public MyLinkedList() {
            head = null;
            tail = null;
            size = 0;
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if(head == null || size == 0 || index >= size) {
                return -1;
            }
            ListNode cur = head;
            for(int i = 0; i < index; i++) {
                cur = cur.next;
            }
            return cur.value;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            ListNode node = new ListNode(val);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                node.next = head;
                head = node;
            }
            size++;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            ListNode node = new ListNode(val);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = tail.next;
            }
            size++;
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index == size) {
                addAtTail(val);
            } else if (index == 0) {
                addAtHead(val);
            } else {
                ListNode cur = head;
                for (int i = 0; i < index - 1; i++) {
                    cur = cur.next;
                }
                ListNode node = new ListNode(val);
                node.next = cur.next;
                cur.next = node;
                size++;
            }
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if (index >= size) {
                return;
            }
            ListNode cur = head;
            for(int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            size--;
        }
    }

    static class ListNode {
        int value;
        ListNode next;
        public ListNode(int val) {
            value = val;
            next = null;
        }
    }
}
