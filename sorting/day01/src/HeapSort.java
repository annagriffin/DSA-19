public class HeapSort extends SortAlgorithm {
    int size;
    int[] heap;

    private int parent(int i) {
        return (i-1) / 2;
    }

    private int leftChild(int i) {
        return 2*i + 1;
    }

    private int rightChild(int i) {
        return 2 * (i + 1);
    }

    // Check children, and swap with larger child if necessary.
    // Corrects the position of element indexed i by sinking it.
    // Use either recursion or a loop to then sink the child
    public void sink(int i) {
        // TODO


        if (leftChild(i) < this.size && this.heap[leftChild(i)] > this.heap[i]) {
            swap(this.heap,i,leftChild(i));
            sink(leftChild(i));
        } else if (rightChild(i) < this.size && this.heap[rightChild(i)] > this.heap[i]) {
            swap(this.heap,i,this.rightChild(i));
            sink(rightChild(i));
        }

        return;


    }

    // Given the array, build a heap by correcting every non-leaf's position, starting from the bottom, then
    // progressing upward
    public void heapify(int[] array) {
        this.heap = array;
        this.size = array.length;

        int max = 0;

        for (int i=this.size / 2 - 1; i>=0; i--) {
            // TODO

            if (leftChild(i) < size && array[leftChild(i)] > array[i]) {
                sink(i);
            }

            if (rightChild(i) < size && array[rightChild(i)] > array[i]) {
                sink(i);
            }


        }

        return;
    }

    /**
     * Best-case runtime:
     * Worst-case runtime:
     * Average-case runtime:
     *
     * Space-complexity:
     */
    @Override
    public int[] sort(int[] array) {
        heapify(array);
        this.size = array.length;

        if (this.size <= 1) {
            return heap;
        }
        for (int i=this.size-1; i>0; i--) {
            // TODO
            swap(array, 0, this.size-1);
            this.size-=1;
            sink(0);
        }

        return heap;
    }
}
