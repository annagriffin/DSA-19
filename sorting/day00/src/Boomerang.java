import java.util.HashMap;

public class Boomerang {

    public static int numberOfBoomerangs(int[][] points) {

        int num = 0;
        HashMap<Integer,Integer> hashmap = new HashMap<>();

        for (int i=0; i<points.length; i++) {
            for (int j=0; j<points.length; j++) {
                if (i == j) {

                }

                // splitting current point into x and y values
                int[] temp1 = points[i];
                int[] temp2 = points[j];

                // distance equation
                int dx = temp1[0] - temp2[0];
                int dy = temp1[1] - temp2[1];

                int distance = dx * dx + dy * dy;

                hashmap.put(distance, hashmap.getOrDefault(distance, 0) + 1);
            }

            for (int each : hashmap.values()) {
                num += each * (each-1);
            }

            hashmap.clear();

        }
        return num;
    }
}

