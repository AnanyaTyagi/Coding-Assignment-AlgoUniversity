package Test;

import java.util.Scanner;

public class RotateArray {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Integer N = s.nextInt();
        Integer K = s.nextInt();
        Integer[] array = new Integer[N];
        for(int i = 0; i<N ;i++){
            array[i] = s.nextInt();
        }

        for(int i = 0, j=N-1; i<N/2 && j>=N/2 ; i++, j--) {
             int t = array[i];
             array[i] = array[j];
             array[j] = t;
        }

        for(int i = 0, j=N-K-1; i<=(N-K-1)/2 && j>(N-K-1)/2 ; i++, j--) {
            int t = array[i];
            array[i] = array[j];
            array[j] = t;
        }


        for(int i = N-K, j=N-1; i<=(2*N - K -1)/2 && j>(2*N - K -1)/2 ; i++, j--) {
            int t = array[i];
            array[i] = array[j];
            array[j] = t;
        }

        for(int i = 0; i<N ;i++){
            System.out.print(array[i] + " ");
        }


    }
}
