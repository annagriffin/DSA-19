import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Problems {

    private static PriorityQueue<Integer> minPQ() {
        return new PriorityQueue<>(11);
    }

    private static PriorityQueue<Integer> maxPQ() {
        return new PriorityQueue<>(11, Collections.reverseOrder());
    }

    private static double getMedian(List<Integer> A) {
        double median = (double) A.get(A.size() / 2);
        if (A.size() % 2 == 0)
            median = (median + A.get(A.size() / 2 - 1)) / 2.0;
        return median;
    }

    // Runtime of this algorithm is O(N^2). Sad! We provide it here for testing purposes
    public static double[] runningMedianReallySlow(int[] A) {
        double[] out = new double[A.length];
        List<Integer> seen = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            int j = 0;
            while (j < seen.size() && seen.get(j) < A[i])
                j++;
            seen.add(j, A[i]);
            out[i] = getMedian(seen);
        }
        return out;
    }


    /**
     *
     * @param inputStream an input stream of integers
     * @return the median of the stream, after each element has been added
     */
    public static double[] runningMedian(int[] inputStream) {
        double[] runningMedian = new double[inputStream.length];
        // TODO

        PriorityQueue<Integer> max = maxPQ();
        PriorityQueue<Integer> min = minPQ();

        if (inputStream.length == 0) {
            return new double[] {};
        }
        int medianIdx = 0;

        if (inputStream.length == 1) {
            runningMedian[0] = inputStream[0];
            return runningMedian;
        }

        runningMedian[0] = inputStream[0];
        max.offer(inputStream[0]);

        System.out.println("hi");
        for (int i=1; i<inputStream.length; i++) {



            if (inputStream[i] <= runningMedian[medianIdx]) {
                max.offer(inputStream[i]);
            } else {
                min.offer(inputStream[i]);
            }



            if (min.size() == 0) {
                if (max.peek() > inputStream[i]) {
                    min.offer(max.peek());
                    max.poll();
                }
                medianIdx += 1;
                int temp = inputStream[i];
                double dub = (double) temp;
                runningMedian[medianIdx] = (dub + runningMedian[medianIdx-1]) / 2.0;

            } else {

                if (max.size() - min.size() > 1) {
                    min.offer(max.peek());
                    max.poll();
                } else if (max.size() - min.size() < -1) {
                    max.offer(min.peek());
                    min.poll();
                }

                if (max.size() == min.size()) {
                    medianIdx += 1;
                    runningMedian[medianIdx] = (min.peek() + max.peek()) / 2.0;

                } else if (min.size() > max.size()) {
                    medianIdx += 1;
                    runningMedian[medianIdx] = min.peek();

                } else {
                    medianIdx += 1;
                    runningMedian[medianIdx] = max.peek();

                }
            }
            System.out.println(runningMedian[i]);


        }

        return runningMedian;
    }

}
