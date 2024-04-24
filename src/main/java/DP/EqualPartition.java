package DP;

import java.util.Arrays;
import java.util.Scanner;

public class EqualPartition {

    static int H, N, totalSum;
    static int[] chocaltes;
    static boolean[][] dp ;


    public static boolean solver(int index, int sum) {
        if(sum == 0)
            return true;
        if(index == N)
            return false;
        if (dp[index][sum])
            return false;


        dp[index][sum] = true;


        if (chocaltes[index] <= sum && solver(index + 1, sum - chocaltes[index]))
            return true;


        return solver(index + 1, sum);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int k = 0 ; k < tc ; k++){
            N = sc.nextInt();
            chocaltes = new int[N];
            totalSum = 0;
            for (int i = 0; i < N; i++) {
                chocaltes[i] = sc.nextInt();
                totalSum+= chocaltes[i];
            }
            if(totalSum%2 == 1){
                System.out.println("NO");
                continue;
            }
            dp = new boolean[N][totalSum/2 +1];
            if(solver(0 , totalSum/2))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        sc.close();
    }

    public static class LongestPalindromicSubsequence {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String s = sc.next();
            String t = String.valueOf(new StringBuilder(s).reverse());
            int n = s.length();
            int[][] dp = new int[n][n];
            for (int[] row : dp)
                Arrays.fill(row, -1);
            System.out.println(lcs(s, t, n - 1, n - 1, dp));
        }

        private static int lcs(String s, String t, int i, int j, int[][]dp) {

            if (i < 0 || j < 0) {
                return 0;
            }
            if(dp[i][j]!=-1){
                return dp[i][j];
            }
            if(s.charAt(i)==(t.charAt(j))){
                return  dp[i][j]= 1+lcs(s, t, i-1, j-1, dp);
            }
            return dp[i][j]= Math.max(lcs(s,t,i-1,j,dp),lcs(s,t,i,j-1,dp));
        }
    }
}

