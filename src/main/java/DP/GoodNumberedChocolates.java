package DP;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.max;

public class GoodNumberedChocolates {

    static int solver(int[] arrHappiness, int N, int ind, int[][] dp) {

        if(N==0)
            return 0;
        if(ind>=N)
        return 0;

        if(dp[ind][N]!=-1){
            return dp[ind][N];
        }
        int chosen = arrHappiness[ind]+solver(arrHappiness, N-ind-1, ind, dp);
        int notChosen= solver(arrHappiness, N, ind+1, dp);

        dp[ind][N] =max(chosen, notChosen);
        return dp[ind][N];
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        while (x-- > 0) {
            int n = s.nextInt();
            int[] arrHappiness = new int[n];
            for (int i = 0; i < arrHappiness.length; i++) {
                arrHappiness[i] = s.nextInt();
            }
            int[][] dp = new int[n + 1][n+1];
            for (int[] a : dp) {
                Arrays.fill(a, -1);
            }

            System.out.println(solver(arrHappiness, n, 0, dp));
        }
    }
}
