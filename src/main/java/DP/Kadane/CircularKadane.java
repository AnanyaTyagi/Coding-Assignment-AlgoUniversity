package DP.Kadane;

import java.util.Scanner;

public class CircularKadane {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String arrString= sc.nextLine();
        String[] spliarr =arrString.split(" ");
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]= Integer.parseInt(spliarr[i]);;
        }
        int[] dp = new int[n];
        dp[0]=arr[0];
        for(int i=1;i<n;i++){
            dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);

        }
        int ans= arr[0];
        //for handling all negative elements case case
        for(int i=1;i<n;i++){
            ans= Math.max(ans, dp[i]);
        }

        //min subarray
        int[] dpMin = new int[n];
        dpMin[0]=arr[0];
        for(int i=1;i<n;i++){
            dpMin[i] = Math.min(dpMin[i-1]+arr[i], arr[i]);

        }
        int ansMin= arr[0];
        int totalSum =arr[0];
        for(int i=1;i<n;i++){
            ansMin= Math.min(ansMin, dpMin[i]);
            totalSum +=arr[i];
        }

        if(ans<0)
            System.out.println(ansMin);
        else
        System.out.println(Math.max(totalSum-ansMin, ans));

    }
}




