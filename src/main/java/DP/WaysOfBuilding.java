package DP;

import java.util.Arrays;
import java.util.Scanner;


public class WaysOfBuilding {
    static final int MOD = 1000000007;

    static int helper(int[] arr, int N, int ind,int h, int[][] dp) {
        if (h == 0) {
            return 1;
        }
        //fails if h is negative
//        if (ind >= N || arr[ind]>h) {
//            return 0;
//        }

        if (ind >= N || h < 0) {
            return 0;
        }

        if (dp[ind][h] != -1) {
            return dp[ind][h];
        }
        int chosen = helper(arr, N,ind,h-arr[ind], dp);
        int notChosen= helper(arr,N, ind+1, h, dp);
        dp[ind][h] =(chosen+notChosen)%MOD;
        return dp[ind][h];
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        while (x-- > 0) {
            int n = s.nextInt();
            int t = s.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = s.nextInt();
            }
            int[][] dp = new int[n + 1][t + 1];
            for (int[] a : dp) {
                Arrays.fill(a, -1);
            }
            System.out.println(helper(arr, n, 0,t, dp));

        }
    }
}
