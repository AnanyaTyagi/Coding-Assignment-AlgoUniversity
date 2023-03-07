package DP;

import java.util.Scanner;

public class WineShelf {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] prices = new int[N + 1];
        long[][] dp = new long[N+1][N+1];
        for(int i = 0; i<=N; i++){
            for(int j = 0; j<=N; j++){
                dp[i][j] = -1;
            }
        }
        for(int i = 1; i<= N;i++){
            prices[i] = sc.nextInt();
        }

        System.out.println(dpRecur(prices, 1, N, dp));

    }

    private static long dpRecur(int[] prices, int i, int j,long[][] dp) {

        int year = i+ prices.length-j-1;

        if(i>j)
            return 0;

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        dp[i][j] = (Math.max(dpRecur(prices, i+1, j, dp)+ prices[i]*year,dpRecur(prices, i, j-1, dp)+ prices[j]*year)%1000000007);
        return dp[i][j];

    }
}
