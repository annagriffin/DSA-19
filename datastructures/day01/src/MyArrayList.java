public class MyArrayList {
    private Cow[] elems;
    private int size;

    // TODO: Runtime: O(1)
    public MyArrayList() {
        // TODO

        this.elems = new Cow[10];
        this.size = 0;
    }

    // TODO: Runtime: O(1)
    public MyArrayList(int capacity) {
        // TODO
        elems = new Cow[capacity];
        size = 0;
    }

    // TODO: Runtime: O(1)*
    public void add(Cow c) {
        // TODO
        if (size >= elems.length) {
            Cow[] big = new Cow[elems.length * 2];
            System.arraycopy(elems,0,big,0,elems.length);
            elems = big;
        }

        elems[size] = c;
        size++;

    }

    // TODO: Runtime: O(1)
    public int size() {
        // TODO
        return size;
    }

    // TODO: Runtime: O(1)
    public Cow get(int index) {
        // TODO

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        return elems[index];
    }

    // TODO: Runtime: O(N)
    public Cow remove(int index) {
        // TODO

        Cow element = get(index);
        for (int i=index; i<size-1; i++) {
            elems[i] = elems[i+1];
        }
        size--;

        if (size <= elems.length / 4) {
            Cow[] small = new Cow[elems.length / 2];
            System.arraycopy(elems,0,small,0,elems.length / 2);
            elems = small;
        }
        return element;
    }

    // TODO: Runtime: O(N)
    public void add(int index, Cow c) {
        // TODO
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        add(c);

        for (int i=size-1; i>index; i--) {
            elems[i] = elems[i-1];
        }

        elems[index] = c;
    }
}