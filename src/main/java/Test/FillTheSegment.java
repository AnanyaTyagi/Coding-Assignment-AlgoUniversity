package Test;

import java.util.Scanner;

public class FillTheSegment {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Integer N = s.nextInt();
        Integer K = s.nextInt();
        Integer Q = s.nextInt();

        Integer[] arrayQ = new Integer[Q+1];
        Integer[] array = new Integer[N+1];
        Integer[] prefix = new Integer[N];

        for (int i = 1; i <=N; i++) {
            array[i] = 0;
        }
        for (int i = 1; i <= Q; i++) {
            arrayQ[i] = s.nextInt();
            array[arrayQ[i]] = 1;
        }
        long maxXeroLength = Integer.MAX_VALUE;
        long maxSum = 0;
        for(int i =1; i<= K;i++) {
           maxSum +=array[i] ;
        }
        if(maxXeroLength>maxSum)
            maxXeroLength = maxSum;

        long windowSUm = maxSum;
        for(int i =K+1; i<= N;i++) {
           windowSUm = windowSUm- array[i-K] + array[i];
           if(maxXeroLength>windowSUm)
               maxXeroLength = windowSUm;
        }

        System.out.println(maxXeroLength);
    }
}
