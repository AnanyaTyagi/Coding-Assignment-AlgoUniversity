package DP;

import java.util.Arrays;
import java.util.Scanner;

public class MimicString {

    static int helper(String s,String t, int i, int j, int[][] dp) {
        if(i<0 ) //we need to consider i=0 th index
            return j+1;
        if(j<0)
            return i+1;

        if(dp[i][j]!=-1) return dp[i][j];

        if(s.charAt(i)==t.charAt(j))
            return dp[i][j] =  0+helper(s,t,i-1,j-1,dp);
        else return dp[i][j] = 1+Math.min(helper(s,t,i-1,j-1,dp),
                Math.min(helper(s,t,i-1,j,dp),helper(s,t,i,j-1,dp)));
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        while (x-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String s = sc.next();
            String t = sc.next();
            int[][] dp = new int[n][m];
            for(int row[]: dp)
                Arrays.fill(row,-1);
            System.out.println(helper(s, t, n-1, m-1, dp));

        }
    }
}
