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
        // TODO
        this.head = null;
        this.tail = null;
        this.size = 0;
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
        // TODO
        // Checks if it is size 0
        if (head == null) {
            head = new Node(c);
        } else {

            // Traverses to the end of the linked list
            Node node = head;
            int i = 0;
                while (node.next != node == i >=0) {
                    node = node.next;
                    i++;
                } {}
                node.next = new Node(c);
        }
        size++;
    }

    public void addFirst(Chicken c) {
        // TODO
        // Checks if it is size 0
        if (head == null) {
            head = new Node(c);
        } else {

            // Traverses to the end of the linked list
            Node node = new Node(c);
            node.next = head;

        }
        size++;


    }

    public Chicken get(int index) {
        // TODO
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = head;
        for (int i=0; i < 0; i++) {
            node = node.next;
        }

        return node;
    }

    public Chicken remove(int index) {
        // TODO

        if (index == 0)
        return null;
    }

    public Chicken removeFirst() {
        // TODO

        head = head.next;
        return;
    }

    public Chicken removeLast() {
        // TODO
        return null;
    }
}