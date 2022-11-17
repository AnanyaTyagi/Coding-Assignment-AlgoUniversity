package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Spaceship {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        Integer N = s.nextInt();
        int[] array = new int[2 * N];

        for (int i = 0; i < 2 * N; i++) {
            array[i] = s.nextInt();
        }

        int minUnstability = Integer.MAX_VALUE;
        Arrays.sort(array);
        for (int i = 0; i < 2 * N; i++) {
            for (int j = i + 1; j < 2 * N; j++) {
                int totalUnstability = 0;
                int p = 0;
                int q = 0;

                while (p < 2 * N) {

                        if(p==i || p==j){
                            p++;
                        } else {
                            q = p + 1;
                            while (q < 2 * N) {

                                if (q == i || q == j) {
                                    q++;
                                } else {
                                    //f = 1;
                                    totalUnstability += array[q] - array[p];
                                    p = q + 1;
                                    break;
                                }
                            }
                        }
                    }
               // System.out.println("//////////////"+minUnstability);
                minUnstability = Math.min(totalUnstability, minUnstability);
            }
        }
        System.out.println(minUnstability);
    }
}
