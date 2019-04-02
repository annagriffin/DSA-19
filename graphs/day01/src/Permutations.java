import java.lang.reflect.Array;
import java.util.*;

public class Permutations {

    public static List<List<Integer>> permutations(List<Integer> A) {
        // TODO
        List<List<Integer>> permutations = new LinkedList<>();

        List<Integer> unused = new LinkedList<>();

        for (Integer i : A) {
            unused.add(i);
        }

        permutationHelper(new LinkedList<>(), unused, permutations);

        return permutations;
    }


    public static void permutationHelper(List<Integer> current, List<Integer> unused, List<List<Integer>> permutations) {


        if (unused.size() == 0) {


            permutations.add(Arrays.asList(current.toArray(new Integer[current.size()])));

        } else {
            for (Integer i : unused.toArray(new Integer[unused.size()])) {
                current.add(i);
                unused.remove(i);
                permutationHelper(current, unused, permutations);
                current.remove(i);
                unused.add(i);
            }
        }

    }

}