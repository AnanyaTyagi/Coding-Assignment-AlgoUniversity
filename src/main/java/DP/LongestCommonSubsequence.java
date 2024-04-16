package DP;

import java.util.Arrays;
import java.util.Scanner;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(lcs(s, t, n - 1, m - 1, dp));
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
