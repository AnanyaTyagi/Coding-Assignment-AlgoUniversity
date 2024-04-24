package DP.Kadane;

import java.util.Arrays;
import java.util.Scanner;

public class OneHoleKadane {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String arrString= sc.nextLine();
        String[] spliarr =arrString.split(" ");
        int[] arr = new int[n];
        int[] rArray = new int[n];
         int j = n-1;

        boolean allNegative = true;
        int maxInArray = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            arr[i]= Integer.parseInt(spliarr[i]);
            rArray[j--]=arr[i];
            if(arr[i]>=0)
                allNegative=false;
            maxInArray= Math.max(maxInArray, arr[i]);
        }

        //made wrong dp as backward..it was supposed to be reversed
      //  maxSumSubarray(arr,  n);
        if(allNegative){
            System.out.println(maxInArray);
            System.exit(0);
        }
        int[] dp = new int[n];
        int[] dpArr = new int[n];

        dp[0]=arr[0];
        dpArr[0]=rArray[0];
        int maxSum=arr[0];
        for(int i=1;i<n;i++){
            dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
            maxSum=Math.max(dp[i],maxSum);

        }
  dpArr[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            dpArr[i] = Math.max(dpArr[i+1]+arr[i], arr[i]);

        }
        int ans= maxSum;


        for(int i=1;i<n-1;i++){
             ans=Math.max(ans, dp[i-1]+dpArr[i+1]);

        }

        System.out.println(ans);

    }

    public static void maxSumSubarray(int A[], int n)
    {
        //add code here.
        // Arrays to store the maximum sum subarray ending at each index
        int[] dpForward = new int[n];
        int[] dpBackward = new int[n];

        // Calculating the maximum sum subarray ending at each index
        int maxSum = A[0];
        dpForward[0] = A[0];
        for (int i = 1; i < n; i++) {
            dpForward[i] = Math.max(A[i], dpForward[i - 1] + A[i]);
            maxSum = Math.max(maxSum, dpForward[i]);
        }

        // Calculating the maximum sum subarray starting from each index
        dpBackward[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            dpBackward[i] = Math.max(A[i], dpBackward[i + 1] + A[i]);
        }

        // Calculating the maximum sum subarray by removing at most one element
        for (int i = 1; i < n - 1; i++) {
            maxSum = Math.max(maxSum, dpForward[i - 1] + dpBackward[i + 1]);
        }

        System.out.print( maxSum);
    }
}





/*Complete the function below*/


class Solution
{
    //Function to return maximum sum subarray by removing at most one element.
    public static void maxSumSubarray(int A[], int n)
    {
        //add code here.
        // Arrays to store the maximum sum subarray ending at each index
        int[] dpForward = new int[n];
        int[] dpBackward = new int[n];

        // Calculating the maximum sum subarray ending at each index
        int maxSum = A[0];
        dpForward[0] = A[0];
        for (int i = 1; i < n; i++) {
            dpForward[i] = Math.max(A[i], dpForward[i - 1] + A[i]);
            maxSum = Math.max(maxSum, dpForward[i]);
        }

        // Calculating the maximum sum subarray starting from each index
        dpBackward[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            dpBackward[i] = Math.max(A[i], dpBackward[i + 1] + A[i]);
        }

        // Calculating the maximum sum subarray by removing at most one element
        for (int i = 1; i < n - 1; i++) {
            maxSum = Math.max(maxSum, dpForward[i - 1] + dpBackward[i + 1]);
        }

        System.out.print( maxSum);
    }
}
