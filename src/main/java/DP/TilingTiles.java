package DP;

import java.util.Arrays;
import java.util.Scanner;

public class TilingTiles {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] dp = new long[N+1];
        Arrays.fill(dp, -1);


        if(N==1 || N==2){
            System.out.println(N);
            System.exit(0);
        }
        int firstAnswer = 1;
        int secondAnswer = 2;
        int answer;
        for(int i = 3; i<=N;i++){
            answer= (firstAnswer%1000000007+ secondAnswer%1000000007)%1000000007;
            firstAnswer = secondAnswer;
            secondAnswer = answer;
           // System.out.println(firstAnswer);
        }

        System.out.println(secondAnswer);


      // System.out.println(recur(N, dp));
    }

//    private static long recur(int n, long[] dp) {
//
//        if(n==1)
//            return 1;
//        if(n==2)
//            return 2;
//
//        if(dp[n]!=-1){
//            return dp[n];
//        }
//
//        dp[n] = (recur(n-1,dp) + recur(n-2, dp))%1000000007;
//        return dp[n];
//    }
}
