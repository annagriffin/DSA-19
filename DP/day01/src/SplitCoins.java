import java.util.Arrays;

public class SplitCoins {

    public static int splitCoins(int[] coins) {
        // TODO

        int sumTotal = 0;

        int coin = coins.length;

        for (int c : coins) {
            sumTotal = sumTotal + c;
        }


        int[][] DP = new int[coins.length][sumTotal];



        for (int k = 0; k < coins.length; k++) {
            for (int l=0; l < sumTotal; l++) {
                DP[k][l] = -1;
            }
        }



        return recursiveFunction(coin,0,coins, sumTotal, DP );
    }


    public static int recursiveFunction(int currCoin, int currSum, int[] coins, int sumTotal, int[][] DP){

        // BASE CASES
        int sum2 = sumTotal - currSum;


        if (currCoin == 0) {
            return Math.abs(currSum - sum2) ;
        }

        if (DP[currCoin-1][currSum] != -1 ) {
            return DP[currCoin-1][currSum];
        }

        DP[currCoin-1][currSum] = Math.min(recursiveFunction(currCoin-1, currSum+coins[currCoin-1], coins, sumTotal, DP), recursiveFunction(currCoin-1, currSum, coins, sumTotal, DP));



        return DP[currCoin-1][currSum];

    }

}
