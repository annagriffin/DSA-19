import java.util.*;


public class Problems {

    public static BinarySearchTree<Integer> minimalHeight(List<Integer> values) {
        // TODO


        Collections.sort(values);



        BinarySearchTree<Integer> b = new BinarySearchTree<>();


        findMedian(b,values,values.size()-1, 0);


        return b;
    }

    private static void findMedian(BinarySearchTree<Integer> b, List<Integer> val, int high, int low) {



        if (low == 0 && high == 0 || low > high) {
            b.add(val.get(0));
            return;
        } else {
            int mid = (high + low) / 2;

            b.add(val.get(mid));

            findMedian(b, val, mid-1, 0);
            findMedian(b, val, high, mid+  1);
        }


    }

    public static boolean isIsomorphic(TreeNode n1, TreeNode n2) {
        // TODO
        return false;
    }
}
