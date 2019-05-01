public class DungeonGame {

    public static int minInitialHealth(int[][] map) {
        // TODO: Your code here

        int rows = map.length;
        int cols = map[0].length;




        int[][] DP = new int[rows][cols];




        // fill in amount needed to get to end from current row

        DP[rows-1][cols-1] = Math.max(1-map[rows-1][cols-1], 1);

        for (int i = rows-2; i >= 0; i--) {
            DP[i][cols-1] = Math.max(DP[i+1][cols-1]-map[i][cols-1], 1);

        }



        for (int j = cols-2; j >= 0; j--) {
            DP[rows-1][j] = Math.max(DP[rows-1][j+1]-map[rows-1][j], 1);
        }

        // traverse through and see how much each direction move would cost
        // take the minimum cost move.

        for (int i = rows-2; i >= 0; i--) {
            for (int j = cols-2; j>=0; j--) {

                int d = Math.max(DP[i+1][j]-map[i][j], 1);
                int r = Math.max(DP[i][j+1]-map[i][j], 1);

                DP[i][j] = Math.min(d, r);
            }
        }

        return DP[0][0];


    }



    }