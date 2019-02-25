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

        int left = leftChild(i);
        int right = rightChild(i);


        if ((size-1) < left) {
            left = i;
        }

        if ((size-1) < right) {
            right = i;
        }



        if ((size-1) < right && heap[left] > heap[i]) {
            swap(heap,i, leftChild(i));
            return;
        } else if ((size-1) < left) {
            swap(heap,i,rightChild(i));
            return;
        }

        if (heap[i] < heap[left] || heap[i] < heap[right]) {
            if (heap[left] > heap[right]) {
                swap(heap,i, left);
                sink(left);
            } else {
                swap(heap,i,right);
                sink(right);
            }
        }

    return;

    }

    // Given the array, build a heap by correcting every non-leaf's position, starting from the bottom, then
    // progressing upward
    public void heapify(int[] array) {
        this.heap = array;
        this.size = array.length;



        for (int i=((this.size / 2) - 1); i>=0; i--) {
            // TODO

            sink(i);
        }


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

        if (this.size == 1) {
            return heap;
        }
        for (int i=this.size-1; i >0; i--) {
            // TODO
            swap(heap, i, 0);
            this.size -=1;
            sink(0);
        }

        return heap;
    }
}
