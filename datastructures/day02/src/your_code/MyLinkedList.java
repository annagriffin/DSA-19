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
            tail = head;
        } else {

            // Traverses to the end of the linked list
            Node node = tail;
            node.next = new Node(c);
            tail = node.next;
            tail.prev = node;

        }
        size++;
    }

    public void addFirst(Chicken c) {
        // TODO
        // Checks if it is size 0
        if (head == null) {
            head = new Node(c);
            tail = head;
        } else {

            // Traverses to the end of the linked list
            Node node = new Node(c);
            node.next = head;
            head.prev = node;
            head = node;


        }
        size++;


    }

    public Chicken get(int index) {
        // TODO
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = head;
        for (int i=0; i < index; i++) {
            node = node.next;
        }

        return node.val;
    }

    public Chicken remove(int index) {
        // TODO
        if (size==0) {
            throw new IndexOutOfBoundsException();
        }
        Chicken chicken = get(index);
        if (index == 0) {
            return removeFirst();
        } else if (index==size-1) {
            return removeLast();
        } else {

            Node node = head;
            for (int i=0; i<index;i++) {
                node = node.next;
            }
            Node node1 = node.prev;
            node1.next = node1.next.next;
            Node node2 = node.next;
            node2.prev = node2.prev.prev;
            node.next = null;
            node.prev = null;
            size--;

        }
        return chicken;
    }

    public Chicken removeFirst() {
        // TODO
        if (head==null) {
            throw new IndexOutOfBoundsException();
        }
        if (size==1) {
            Chicken chick = head.val;
            head = null;
            tail = null;
            size = 0;
            return chick;
        } else {
            Chicken chick = head.val;
            head = head.next;
            head.prev = null;
            size--;
            return chick;
        }

    }

    public Chicken removeLast() {
        // TODO
        if (tail==null) {
            throw new IndexOutOfBoundsException();
        }

        if (size == 1) {
            Chicken chick = tail.val;
            head = null;
            tail = null;
            size = 0;
            return chick;
        } else {

            Chicken chick = tail.val;
            tail = tail.prev;
            tail.next = null;
            size--;
            return chick;
        }



    }
}