import java.util.Arrays;

public class LongestIncreasingSubsequence {

    // Runtime:
    // Space:
    public static int LIS(int[] A) {
        // TODO

        int len = A.length;
        int lis[] = new int[len];

        // set as 1 for each so far
        for (int i = 0; i < len; i++) {
            lis[i] = 1;
        }


        for (int i=1; i<len; i++) {
            for (int j=0; j < i; j++) {

                if (A[i] > A[j] && lis[i] < lis[j]+1) {


                    lis[i] = lis[j] +1;
                }
            }
        }

        int longest= 0;



        for (int k = 0; k < len; k++) {

            if (lis[k] > longest) {


                longest = lis[k];

            }
        }







        return longest;
    }
}