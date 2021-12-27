package linkedList;

public class DesignLinkedList_612 {
    ListNode head;
    ListNode tail;
    int size;

    public DesignLinkedList_612() {
        head = null;
        tail = null;
        size = 0;
    }

    //get(index)
    public int get(int index) {
        if (index < 0 || index >= size) {
            return  -1;
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.value;
    }

    //addAtHead(val)
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    //addAtTail(val)
    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    //addAtIndex(index, val)
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            ListNode cur = head;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            ListNode node = new ListNode(val);
            node.next = cur.next;
            cur.next = node;
        }
    }

    //deleteAtIndex(index)
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
    }


}
