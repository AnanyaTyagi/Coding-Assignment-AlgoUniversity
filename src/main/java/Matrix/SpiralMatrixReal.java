package Matrix;

import java.util.ArrayList;
import java.util.Scanner;

public class SpiralMatrixReal {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String size = s.nextLine();
        String[] sizeOfMatrix = size.split(" ");
        int row = Integer.valueOf(sizeOfMatrix[0]);
        int column = Integer.valueOf(sizeOfMatrix[1]);
        long[][] matrix = new long[row + 1][column + 1];


        if (row == 1 && column == 1) {
            String uniMatrix = s.nextLine();
            System.out.println(Integer.valueOf(uniMatrix));
            System.exit(0);
        }

        for (int i = 0; i < row; i++) {
            String rowString = s.nextLine();
            String[] rowValues = rowString.split(" ");
            for (int j = 0; j < column; j++) {
                matrix[i][j] = Integer.valueOf(rowValues[j]);
            }
        }

        int minrow=0;
        int maxrow=row-1;
        int mincol=0;
        int maxcol=column-1;
        while(minrow<=maxrow  && mincol<=maxcol){
            for(int i=minrow,j=mincol;j<=maxcol ;j++){
                System.out.print(matrix[i][j]+" ");
                //k++;
            }
            minrow++;

            for(int i=minrow,j=maxcol;i<=maxrow ;i++){
                System.out.print(matrix[i][j]+" ");
                //k++;
            }
            maxcol--;

            if(minrow<=maxrow){
                for(int i=maxrow,j=maxcol;j>=mincol;j--){
                    System.out.print(matrix[i][j]+" ");
                    //k++;
                }

                maxrow--;
            }

            if(mincol<=maxcol){
                for(int i=maxrow,j=mincol;i>=minrow;i--){
                    System.out.print(matrix[i][j]+" ");
                    //k++;
                }
                mincol++;
            }

        }

        int startRow= 0;
        int startCol= 0;
        int endRow = row-1;
        int endCol = column-1;

        while(startCol<=endCol && startRow<=endRow) {

            for (int i = startCol; i <= endCol; i++) {
                System.out.println(matrix[startRow][i]);
            }
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.println(matrix[i][endCol]);
            }
            for (int i = endCol - 1; i >= startCol; i--) {
                if (startRow == endRow)
                    break;
                System.out.println(matrix[endRow][i]);
            }
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                if (startCol == endCol)
                    break;
                System.out.println(matrix[i][startCol]);
            }
            startRow++;
            endCol--;
            endRow--;
            startCol++;
        }
       // spiralFill(matrix,1,1,row,column, list);

    }
     public static void spiralFill(Integer[][] matrix, int startRow, int startCol, int endRow, int endCol, ArrayList<Integer> list) {

        if(startRow> endRow && startCol>endCol)
            return;
        for(int i = startCol; i<=endCol; i++){
            System.out.println(matrix[startRow][i]);
        }
         for(int i = startRow + 1; i<=endRow; i++){
             System.out.println(matrix[i][endCol]);
         }
         for(int i = endCol-1; i>=startCol; i--){
             if(startRow == endRow)
                 break;
             System.out.println(matrix[endRow][i]);
         }
         for(int i = endRow-1; i>=startRow+1; i--){
             if(startCol == endCol)
                 break;
             System.out.println(matrix[i][startCol]);
         }
         spiralFill(matrix, startRow+1, startCol+1, endRow-1, endCol-1, list);
     }

}