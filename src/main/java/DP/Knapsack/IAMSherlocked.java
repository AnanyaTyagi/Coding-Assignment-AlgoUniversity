package DP.Knapsack;

import java.util.Arrays;
import java.util.Scanner;

public class IAMSherlocked {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //it was never about minimising the cost but maximising the production
        int c = sc.nextInt();
        int m = sc.nextInt();
        int n = sc.nextInt();

        String[] listOfNum = new String[c];
        for (int i = 0; i < c; i++) {
            listOfNum[i]=sc.nextLine();
        }

        int dp[][][] = new int[c][m+1][n+1];
        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }

        System.out.println(recur(listOfNum, m,n, 0, dp));

    }

    private static int recur(String[] listOfn, int m, int n, int i, int[][][] dp) {
        if(i>listOfn.length-1){
            return 0;
        }

         if(m==0 && n==0)
             return 0;
        int notTaken = 0;
        int taken = 0;

        if(dp[i][m][n]!=-1)
            return dp[i][m][n];

       int countZero =countZeros(listOfn[i]);
       int countOne = listOfn[i].length()-countZero;
        if(countOne<=n && countZero<=m){
            taken = 1+recur(listOfn, m-countZero,n-countOne, i+1, dp);
            notTaken= recur(listOfn, m,n, i+1, dp);
            return dp[i][m][n]=Math.max(taken, notTaken);
        } else{
           return dp[i][m][n]=recur(listOfn, m,n, i+1, dp);
        }

    }

    public static int countZeros(String binaryString) {
        int countZero = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            char digit = binaryString.charAt(i);
            if (digit == '0') {
                countZero++;
            }
        }
        return  countZero;
    }
}
