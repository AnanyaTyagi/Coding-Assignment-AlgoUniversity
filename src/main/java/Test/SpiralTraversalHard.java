package Test;

import java.util.Scanner;

public class SpiralTraversalHard {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Integer P = s.nextInt();
        Integer Q = s.nextInt();
        Integer N = s.nextInt();


        int[][] array = new int[P][Q];


        for (int i = 0; i < N; i++) {
            Integer X = s.nextInt();
            Integer Y = s.nextInt();
            Integer val = s.nextInt();
                array[X][Y] = val;
        }

        Integer A = s.nextInt();
        Integer B = s.nextInt();



    }
}
