package DP.Knapsack;

import java.util.Arrays;
import java.util.Scanner;

public class GigaFactories {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         //it was never about minimising the cost but maximising the production
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] cost = new int[n];
        int[] units = new int[n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String arrString = sc.nextLine();
            String[] strArr = arrString.split(" ");
            cost[i] = Integer.valueOf(strArr[0]);
            units[i] = Integer.valueOf(strArr[1]);

        }

        int dp[][] = new int[n+1][c+1];
        for(int[] ar:dp){
            Arrays.fill(ar, -1);
        }

        System.out.println(recur(cost, units, n,c, 0, dp));

    }

    private static int recur(int[] cost, int[] units, int n, int curr_cost,int i, int[][] dp) {
         if(i==n || curr_cost==0){
             return 0;
         }
         int notTaken = 0;
        int taken = 0;

        if(dp[i][curr_cost]!=-1)
             return dp[i][curr_cost];
         if(cost[i]<=curr_cost){
             //take both chosen and not chosen case
             taken = units[i]+recur(cost, units, n,curr_cost-cost[i], i+1, dp);
         }
        notTaken= recur(cost, units, n,curr_cost, i+1, dp);
         return dp[i][curr_cost]=Math.max(taken, notTaken);
    }
}
