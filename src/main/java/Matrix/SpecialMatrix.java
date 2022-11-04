package Matrix;

import java.util.Scanner;

//su of each row and column is same
public class SpecialMatrix {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String size = s.nextLine();
        Integer sizeOfMatrix = Integer.valueOf(size);
        long[][] matrix = new long[sizeOfMatrix + 1][sizeOfMatrix + 1];
        long[] rowSum = new long[sizeOfMatrix+1];
        long[] colSum = new long[sizeOfMatrix+1];

        //mistake
//        if (sizeOfMatrix == 1) {
//            String uniMatrix = s.nextLine();
//            System.out.println(Integer.valueOf(uniMatrix));
//            System.exit(0);
//        }

        for (int i = 1; i <= sizeOfMatrix; i++) {
            String rowString = s.nextLine();
            String[] row = rowString.split(" ");
            for (int j = 1; j <= sizeOfMatrix; j++) {
                matrix[i][j] = Integer.valueOf(row[j - 1]);

            }
        }
        long maxColSum = 0, maxRowSum=0;
        for(int i =1; i<=sizeOfMatrix; i++) {
            long sum = 0;
            for (int j = 1; j<=sizeOfMatrix; j++) {
                sum = sum + matrix[i][j];
            }
            rowSum[i] = sum;
            if(maxRowSum<sum)
                maxRowSum = sum;
        }
        for(int i =1; i<=sizeOfMatrix; i++) {
            long sum = 0;
            for (int j = 1; j<=sizeOfMatrix; j++) {
                sum = sum + matrix[j][i];
            }
            colSum[i] = sum;
            if(maxColSum<sum)
                maxColSum = sum;
        }

        long columnDifSum = 0, rowDifSum = 0;
          for(int i = 1; i<=sizeOfMatrix; i++) {
              columnDifSum += (maxColSum-colSum[i]);
              rowDifSum += (maxRowSum-rowSum[i]);
        }
        System.out.print(Math.max(columnDifSum, rowDifSum));
    }
}
