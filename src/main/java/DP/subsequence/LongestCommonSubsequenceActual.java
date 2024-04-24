package DP.subsequence;

import java.util.Arrays;
import java.util.Scanner;

public class LongestCommonSubsequenceActual {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        int n = s.length();
        int m = t.length();
        String[][] dp = new String[n][m];
        for (String[] row : dp)
            Arrays.fill(row, "*");
        System.out.println(lcs(s, t, n - 1, m - 1, dp));
    }

    private static String lcs(String s, String t, int i, int j, String[][]dp) {

        if (i < 0 || j < 0) {
            return "";
        }
        if(!dp[i][j].equals("*")){
            return dp[i][j];
        }
        if(s.charAt(i)==(t.charAt(j))){
            return  dp[i][j]= lcs(s, t, i-1, j-1, dp)+s.charAt(i);

        }
        String answer =null;
        if(lcs(s,t,i-1,j,dp).length()>lcs(s,t,i,j-1,dp).length()){
            return dp[i][j]=lcs(s,t,i-1,j,dp) ;
        }
        return dp[i][j]= lcs(s,t,i,j-1,dp);
    }
}
