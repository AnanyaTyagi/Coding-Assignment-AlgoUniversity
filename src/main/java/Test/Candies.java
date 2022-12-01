package Test;

import java.util.Arrays;
import java.util.Scanner;

public class Candies {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        if(N <M){
            System.out.println(-1);
            System.exit(0);
        }

        int array[] = new int[N];

        long totalSum = 0;
        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
            totalSum+=array[i];
        }
        Arrays.sort(array);

        long l = 0;
        long r = totalSum;
        while(l+1<r) {

            long mid = l + (r-l)/2;

            if(predicate(M , N, mid, array)){
                l = mid;
            } else {
                r = mid;
            }
        }
        System.out.println(r);
    }

    public static boolean predicate(long M, long N, long mid, int[] arr) {


        return true;

    }

}
