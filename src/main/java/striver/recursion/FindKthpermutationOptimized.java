package striver.recursion;

import java.util.Scanner;


public class FindKthpermutationOptimized {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        int k = s.nextInt();
        s.close();
        Character[] arr = new Character[n];
//        for (int i = 1; i <= n; i++)
//            arr[i-1] = (char) i;

        for (int i = 0; i < n; i++)
            arr[i] = (char) ('0' + i + 1);

        kthPermutation(arr, n, k, 0);
        // Print the permutation
        StringBuilder permutation = new StringBuilder();
        for (char c : arr)
            permutation.append(c);
        System.out.println(permutation.toString());
    }

    private static void kthPermutation(Character[] arr, int n, int k, int index) {

        if(k==0)
            return;

        if(index==0)
            k = k-1;
           int block = k/fact(n-1);
            k = k%fact(n-1);
            swapArray(arr, block+index, index);
           kthPermutation(arr, n-1, k, index+1);

    }

    private static void swapArray(Character[] arr, int i, int index) {
        Character c = arr[i];
        arr[i]= arr[index];
        arr[index] = c;
    }

    private static int fact(int n) {
        int ans=n;
        for(int i = n-1; i>=1;i--){
            ans*=i;
        }
        return ans;
    }
}
