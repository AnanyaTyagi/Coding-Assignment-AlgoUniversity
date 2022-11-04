package Matrix;

import java.util.Scanner;

public class RotateAMatrix {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String size = s.nextLine();
        Integer sizeOfMatrix = Integer.valueOf(size);
        Integer[][] matrix = new Integer[sizeOfMatrix+1][sizeOfMatrix +1];
        Integer[][] outputMatrix = new Integer[sizeOfMatrix+1][sizeOfMatrix +1];

        if(sizeOfMatrix == 1) {
                    String uniMatrix = s.nextLine();
                   System.out.println(Integer.valueOf(uniMatrix));
                   System.exit(0);
        }

        for(int i =1; i<=sizeOfMatrix; i++) {
            String rowString = s.nextLine();
            String[] row = rowString.split(" ");
            for (int j = 1; j<=sizeOfMatrix; j++) {
                matrix[i][j] = Integer.valueOf(row[j-1]);

            }
        }

        for(int i =1; i<=sizeOfMatrix; i++) {
            for (int j = i; j<=sizeOfMatrix; j++) {
                if(i==j) {
                    continue;
                } else {
                    matrix[i][j] = matrix[i][j] + matrix[j][i];
                    matrix[j][i] = matrix[i][j] - matrix[j][i];
                    matrix[i][j] = matrix[i][j] - matrix[j][i];
                }
            }
        }

            int index = 1;
            for (int j = 1; j<=sizeOfMatrix; j++) {
                for(int i =sizeOfMatrix; i>=1; i--) {

                    outputMatrix[index][j]=matrix[i][j];
                       index++;
                }
                index = 1;
            }

        for(int i =1; i<=sizeOfMatrix; i++) {
            for (int j = 1; j<=sizeOfMatrix; j++) {
                System.out.print(outputMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
