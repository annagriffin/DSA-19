import java.util.*;

public class BarnRepair {
    public static int solve(int M, int[] occupied) {
        // TODO

        PriorityQueue<Integer> gaps = new PriorityQueue<>(Collections.reverseOrder());
        int boards = 1;

        int prev = -1;
        Arrays.sort(occupied);

        int count = occupied[(occupied.length - 1)] - occupied[0] + 1;


        for (int i : occupied ) {
            if (prev == -1) {
                prev = i;
            } else {
                if (i - prev != 1) {
                    gaps.add(i - prev -1);

                }
                prev = i;

            }
        }
        System.out.println(gaps);


        while (boards < M && !gaps.isEmpty()) {
            int gap = gaps.poll();
            count = count - gap;
            boards = boards + 1;

        }

        System.out.println(count);










        return count;
    }






}