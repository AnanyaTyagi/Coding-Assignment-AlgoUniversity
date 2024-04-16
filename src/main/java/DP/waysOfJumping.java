package DP;

import java.util.Arrays;
import java.util.Scanner;

public class waysOfJumping {
    static final int MOD = 1000000007;

    static int helper(int[] arr, int target, int ind, int[][] dp) {
        if (target == 0) {
            return 1;
        }

        if (ind >= arr.length || target < 0) {
            return 0;
        }

        if (dp[ind][target] != -1) {
            return dp[ind][target];
        }
        int chosen = helper(arr, target-arr[ind],ind, dp);
        int notChosen= helper(arr,target, ind+1, dp);
        dp[ind][target] =(chosen+notChosen)%MOD;
        return dp[ind][target];
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
            System.out.println(helper(arr, t, 0, dp));

        }
    }
}
