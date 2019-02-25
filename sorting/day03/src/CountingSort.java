public class CountingSort {

    /**
     * Use counting sort to sort non-negative integer array A.
     * Runtime: TODO
     *
     * k: maximum element in array A
     */
    static void countingSort(int[] A) {
        // TODO

        int max = 0;

        for (Integer e : A) {
            if (e > max) {
                max = e;
            }
        }

        int[] frequencies = new int[max+1];

        for (int i=0; i<A.length; i++) {
            frequencies[A[i]] += 1;
        }

        int aIdx = 0;


        for (int i = 0; i< frequencies.length; i++) {
            for (int temp = frequencies[i]; temp != 0; temp--) {
                A[aIdx] = i;
                aIdx += 1;
            }
        }





    }

}
