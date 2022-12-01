package RangeQueriesPrefixSum;

import java.util.Scanner;

public class WallPainting {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Integer N = s.nextInt();
        Integer K = s.nextInt();
        int[][] array = new int[N][4];
        int[][] matrix= new int[1002][1002];
        int[][] prefixMatrixSum= new int[1002][1002];

        for (int i = 0; i <N; i++)  {
            //i
            array[i][0] = s.nextInt();
            //j
            array[i][1] = s.nextInt();
            //k
            array[i][2] = s.nextInt();
            //l
            array[i][3] = s.nextInt();

            matrix[array[i][0]][array[i][1]] += 1;
            matrix[array[i][0]][array[i][3]]+= -1;
            matrix[array[i][2]][array[i][1]]+= -1;
            matrix[array[i][2]][array[i][3]]+= 1;

        }

        prefixMatrixSum[0][0] = matrix[0][0];

        // Filling first row and first column
        for (int i = 1; i < 1001; i++)
            prefixMatrixSum[0][i] = prefixMatrixSum[0][i - 1] + matrix[0][i];
        for (int i = 1; i < 1001; i++)
            prefixMatrixSum[i][0] = prefixMatrixSum[i - 1][0] + matrix[i][0];

        // updating the values in the
        // cells as per the general formula.
        for (int i = 1; i < 1001; i++) {
            for (int j = 1; j < 1001; j++) {
                // values in the cells of new array
                // are updated
                prefixMatrixSum[i][j] = prefixMatrixSum[i - 1][j] + prefixMatrixSum[i][j - 1]
                        - prefixMatrixSum[i - 1][j - 1] + matrix[i][j];
            }
        }

        int count = 0;
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                if(prefixMatrixSum[i][j]==K)
                    count++;
            }
        }

//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++)
//                System.out.print(prefixMatrixSum[i][j] + " ");
//            System.out.println();
//        }

        System.out.print(count);

    }
}
