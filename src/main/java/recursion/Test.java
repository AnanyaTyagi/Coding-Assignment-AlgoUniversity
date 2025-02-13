package recursion;

import java.util.Arrays;

public class Test {

    public static void main(String args[]){
        int [] arr = {6, -2, 4, 1, 9, -3, -6, 8};
        int k = 11;
        System.out.println(func(arr, k));
    }

    private static int func(int[] arr, int k) {
        int length = arr.length;
        int maxLength = length;
        int l = 0;
        int r = length-1;
        int sum = 0;
        for(int i = 0;i<arr.length;i++)
        {
            sum+=arr[i];
        }
         while(l<=r){
             if(sum -arr[l] <k){
                 return maxLength-1;
             }
             if(sum -arr[r] <k){
                 return maxLength-1;
             }
             if(sum -arr[l]-arr[r] <k){
                 return maxLength-2;
             }
             sum = sum-arr[r]-arr[l];
             l++;
             r--;
             maxLength = maxLength-2;
         }
         for
         return 0;
    }
}
