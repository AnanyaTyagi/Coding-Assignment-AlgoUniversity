package DP.Kadane;

import java.util.Arrays;
import java.util.Scanner;

public class OriginalKadane {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String arrString= sc.nextLine();
        String[] spliarr =arrString.split(" ");
        int[] arr = new int[n+1];
        for(int i=0;i<n;i++){
            arr[i]= Integer.parseInt(spliarr[i]);;
        }
        int[] dp = new int[n];
        dp[0]=arr[0];
       for(int i=1;i<n;i++){
                     dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);

       }
       int ans= arr[0];
        for(int i=1;i<n;i++){
        ans= Math.max(ans, dp[i]);
        }
       System.out.println(ans);
    }

}
