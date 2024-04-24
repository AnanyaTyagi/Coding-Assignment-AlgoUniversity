package DP.OtherVariants;

import java.util.Arrays;
import java.util.Scanner;

public class EggDroppingQuantumExperiments {

//todo
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume newline after reading integer
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            scanner.nextLine(); // Consume newline after reading integers
            int[][] dp = new int[n + 1][k + 1];
            for (int[] row : dp)
                Arrays.fill(row, -1);

            System.out.println(experiments(n, k, dp));
        }
        scanner.close();
    }

        // Function to find the maximum score recursively
        private static int experiments( int n, int k, int[][] dp) {

            if(n==0||n==1||k==1)
                return n;

            if(dp[n][k]!=-1)
                return dp[n][k];
            int ans =Integer.MAX_VALUE;
            for (int j=1;j<=n;j++){
                int temp = 1+Math.max(experiments(n-j, k, dp), experiments(j-1, k-1, dp));
            ans = Math.min(ans, temp);
            }
            return dp[n][k]=ans;
        }
    }

