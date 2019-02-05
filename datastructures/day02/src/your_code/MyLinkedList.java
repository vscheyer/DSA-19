package your_code;

public class MyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        Chicken val;
        Node prev;
        Node next;

        private Node(Chicken d, Node prev, Node next) {
            this.val = d;
            this.prev = prev;
            this.next = next;
        }

        private Node(Chicken d) {
            this.val = d;
            prev = null;
            next = null;
        }
    }

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Chicken c) {
        addLast(c);
    }

    public Chicken pop() {
        return removeLast();
    }

    public void addLast(Chicken c) {
        Node n1 = new Node(c, tail, null);
        if (tail != null) {
            tail.next = n1;
        }
        if (head == null) {
            head = n1;
        }
        tail = n1;
        size++;
    }

    public void addFirst(Chicken c) {
        Node n1 = new Node(c, null, head);
        if (head != null) {
            head.prev = n1;
        }
        head = n1;
        if (tail == null) {
            tail = n1;
        }
        size++;
    }

    public Chicken get(int index) { // O(N) operation
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Chicken bob = current.val;
        return bob;
    }

    public Chicken remove(int index) {
        Node current = head;
        Chicken bob = null;
        Node nodeBefore;
        Node nodeAfter;
        if (index == 0) {
            return removeFirst();
        }
        if (index == size-1) {
            return removeLast();
        } else {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            nodeBefore = current.prev;
            nodeAfter = current.next;
            nodeBefore.next = current.next;
            nodeAfter.prev = current.prev;
        }
        bob = current.val;
        size--;
        return bob;
    }

    public Chicken removeFirst() {
        //System.out.print(size);
        Node old = head;
        Chicken chick = old.val;
        if (isEmpty()) {
            chick = null;
        }
        if (size == 1) {
            head = null;
            tail = null;

        } else {
            head = head.next;
        }
        size--;
        //System.out.print(size);
        return chick;
    }

    public Chicken removeLast() {
        Node old = tail;
        Chicken chick = old.val;
        if (isEmpty()) {
            chick = null;
        }
        if (size == 1) {
            head = null;
            tail = null;

        } else {
            tail = tail.prev;
        }
        size--;
        //System.out.print(size);
        return chick;
    }
}