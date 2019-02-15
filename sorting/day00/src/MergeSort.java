
public class MergeSort extends SortAlgorithm {

    private static final int INSERTION_THRESHOLD = 10;

    /**
     * This is the recursive step in which you split the array up into
     * a left and a right portion, sort them, and then merge them together.
     * Use Insertion Sort if the length of the array is <= INSERTION_THRESHOLD
     *
     * TODO
     * Best-case runtime: 0(n lgn)   [O(1) *with linked list]
     * Worst-case runtime: O(n lgn)
     * Average-case runtime: O(n lgn)
     *
     * Space-complexity: 0(n)
     */
    @Override
    public int[] sort(int[] array) {


        if (array.length <= 1) { return array;}

        if (array.length < 10) {
            sort(array);
        }


        int halfLength = array.length / 2;


        int[] first = new int[halfLength];
        int[] second = new int[array.length - halfLength];

        System.arraycopy(array,0,first, 0, halfLength);
        System.arraycopy(array, halfLength, second, 0, array.length - halfLength);

        int[] sorted_left = sort(first);
        int[] sorted_right = sort(second);

        array = merge(sorted_left, sorted_right);

        return array;

    }

    /**
     * Given two sorted arrays a and b, return a new sorted array containing
     * all elements in a and b. A test for this method is provided in `SortTest.java`
     */
    public int[] merge(int[] a, int[] b) {

        int[] k = new int[a.length + b.length];
        int indexA = 0;
        int indexB = 0;
        int i = 0;


        while (i < k.length) {
            if (indexA<a.length && indexB<b.length) {
                if (a[indexA] < b[indexB]) {
                    k[i] = a[indexA];
                    indexA += 1;
                    i+=1;
                } else {
                    k[i] = b[indexB];
                    indexB +=1;
                    i+=1;
                }
            } else if (indexA<a.length && indexB >= b.length) {
                k[i] = a[indexA];
                indexA += 1;
                i+=1;
            } else if (indexB<b.length && indexA >= a.length) {
                k[i] = b[indexB];
                indexB+=1;
                i+=1;
            }
        }


        return k;
    }

}
