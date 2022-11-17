package Test;

import java.util.Scanner;

public class MatrixReshape {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Integer N = s.nextInt();
        Integer M = s.nextInt();
        Integer R = s.nextInt();
        Integer C = s.nextInt();


        int[][] array = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                array[i][j] = s.nextInt();
            }
        }

        if (N * M != R * C) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    System.out.print(array[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            //int[][] arrayResult = new int[R][C];
            int row = 0, col = 0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {

                   // arrayResult[i][j] = array[row][col];
                    System.out.print(array[row][col]);
                    if(col!= M-1)
                        col++;
                    else {
                        row++;
                        col = 0;
                    }
                }
                System.out.println();
            }
        }
    }
}
