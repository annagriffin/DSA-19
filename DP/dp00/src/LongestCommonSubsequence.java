public class LongestCommonSubsequence {

    // Runtime:
    // Space:
    public static int LCS(String S1, String S2) {
        // TODO

        char[] s1 = S1.toCharArray();
        char[] s2 = S2.toCharArray();


        int grid[][] = new int[S1.length()+1][S2.length()+1];

        for (int i=0; i<= S1.length(); i++) {
            for (int j=0; j<= S2.length(); j++) {

                if (i == 0 || j == 0) {
                    grid[i][j] = 0;


                } else if (s1[i-1] == s2[j-1]) {

                    grid[i][j] = grid[i-1][j-1] +1;

                } else {

                    int larger = Integer.max(grid[i-1][j], grid[i][j-1]);
                    grid[i][j] = larger;
                }


            }
        }


        return grid[S1.length()][S2.length()];
    }
}