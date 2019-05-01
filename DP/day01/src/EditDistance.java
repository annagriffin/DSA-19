public class EditDistance {

    public static int minEditDist(String a, String b) {
        // TODO: Your code here


        int[][] vals = new int[a.length()+1][b.length()+1];

        char[] A = a.toCharArray();
        char[] B = b.toCharArray();

        for (int i=0; i<A.length + 1; i++) {
            for (int j=0; j<B.length+1; j++) {

                if (i == 0) {
                    vals[i][j] = j;
                } else if (j == 0) {
                    vals[i][j] = i;
                } else if (A[i-1] == B[j-1]) {
                    vals[i][j] = vals[i-1][j-1];
                } else {

                    int min = getMin(vals[i][j-1],vals[i-1][j],vals[i-1][j-1]);
                    vals[i][j] = 1 + min;

                }
            }
        }
        return vals[A.length][B.length];
    }


    public static int getMin(int a, int b, int c) {

        int first = Integer.min(a,b);
        int smallest = Integer.min(first, c);

        return smallest;


    }

}
