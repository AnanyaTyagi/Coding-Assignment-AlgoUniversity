package Matrix;

import java.util.Scanner;

public class SpiralMatrix {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String size = s.nextLine();
        String[] sizeOfMatrix = size.split(" ");
        int row = Integer.valueOf(sizeOfMatrix[0]);
        int column = Integer.valueOf(sizeOfMatrix[1]);
        Integer[][] matrix = new Integer[row+1][column+1];
        Integer[][] outputMatrix = new Integer[row+1][column+1];

        if(row == 1 && column==1) {
            String uniMatrix = s.nextLine();
            System.out.println(Integer.valueOf(uniMatrix));
            System.exit(0);
        }

        for(int i =1; i<=row; i++) {
            String rowString = s.nextLine();
            String[] rowValues = rowString.split(" ");
            for (int j = 1; j<=column; j++) {
                matrix[i][j] = Integer.valueOf(rowValues[j-1]);
            }
        }

        int columnCounter = column;
        int rowCounter = row;
        int i =1;
        int j = 1;
        int total = row* column;
        int counterOfPrinted=0;

        for(i =1; i<=rowCounter; i++) {

            if(counterOfPrinted == total)
                break;

            for (j = i; j<=columnCounter; j++) {
                System.out.print(matrix[i][j] + " ");
                counterOfPrinted++;
            }   
            if(counterOfPrinted == total)
                break;

            int indexI=0;
            j--;
            for(indexI=i+1; indexI<=rowCounter; indexI++) {
                System.out.print(matrix[indexI][j] + " ");
                counterOfPrinted++;

            }

            if(counterOfPrinted == total)
                break;

            indexI--;
            for(j=columnCounter-1; j>=i; j--) {
                System.out.print(matrix[indexI][j] + " ");
                counterOfPrinted++;

            }
            if(counterOfPrinted == total)
                break;


            j++;
            for(indexI=indexI-1; indexI>i; indexI--) {

                System.out.print(matrix[indexI][j] + " ");
                counterOfPrinted++;

            }
            rowCounter--;
            columnCounter--;
        }
    }
}
