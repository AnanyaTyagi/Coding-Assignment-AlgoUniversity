package DP.Kadane;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class DividingSequence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
           int[] dp = new int[n];
        Arrays.fill(dp,-1);

        for(int i=0;i<n;i++)
            dp[i]=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]%arr[j]==0)
                    dp[i]=Math.max(dp[i], dp[j]+1);
            }
        }

//        if(n==1){
//            System.out.println(1);
//            System.exit(0);
//        }
//        int maxCountNeededForSequence = recur(n, arr, 1, dp);
        int ans=0;
        for(int i=0;i<n;i++)
            ans=Math.max(ans, dp[i]);
        System.out.println(n-ans);
    }

   public static int recur(int n, int[]arr, int i, int []dp){
        if(i==n){
            return 0;
        }

        if(dp[i]!=-1)
            return dp[i];

        int successChosen = 0;
        int chosen = 0;
        int notChosen = 0;
        if(arr[i]%arr[i-1]==0){
           successChosen =  2+ recur(n, arr, i+1, dp);
        } else {
            chosen = 1 + recur(n, arr, i + 1, dp);
        }
            notChosen=recur(n, arr, i+1, dp);
            dp[i] = Math.max(successChosen, Math.max(chosen, notChosen));

            return dp[i];

   }
}
